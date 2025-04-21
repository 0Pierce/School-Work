using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using System;
using System.Collections.Generic;
using System.IO;
using System.Net.Http;
using System.Threading.Tasks;
using System.Windows;

namespace A2_DynamoDB
{
    public partial class BookViewer : Window
    {
        Book Book { get; set; }
        EbookReader ReaderWindow { get; set; }
        AmazonDynamoDBClient Client { get; set; }
        string UserName { get; set; } 

        public BookViewer(Book book, EbookReader readerWindow, AmazonDynamoDBClient client, string userName)
        {
            InitializeComponent();

            Book = book;
            ReaderWindow = readerWindow;
            Client = client;
            UserName = userName; 

            displayBook();
        }

        private async void displayBook()
        {
            if (Book != null && !string.IsNullOrEmpty(Book.PdfURL))
            {
                try
                {
                    using (HttpClient httpClient = new HttpClient())
                    {
                        byte[] pdfData = await httpClient.GetByteArrayAsync(Book.PdfURL);

                        using (MemoryStream pdfStream = new MemoryStream(pdfData))
                        {
                            pdfStream.Position = 0;
                            pdfViewer.Load(pdfStream);

                            // Set the PDF viewer to the last saved page
                            if (Book.PagesRead > 0)
                            {
                                pdfViewer.CurrentPage = Book.PagesRead;
                            }
                        }
                    }
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Error loading PDF: " + ex.Message);
                }
            }
            else
            {
                MessageBox.Show("No valid book or PDF URL.");
            }
        }

        private async void btnExit_Click(object sender, RoutedEventArgs e)
        {
            Book.PagesRead = pdfViewer.CurrentPage; // Get the current page
            await UpdateBookProgressAsync(Book, pdfViewer.CurrentPage); // Update the progress in DynamoDB
            this.Close();
            ReaderWindow.Show();
            ReaderWindow.Activate();
        }

        private async Task UpdateBookProgressAsync(Book book, int currentPage)
        {
            try
            {
                var request = new UpdateItemRequest
                {
                    TableName = "bookShelf",
                    Key = new Dictionary<string, AttributeValue>
                    {
                        { "UserName", new AttributeValue { S = UserName } }, 
                        { "BookTitle", new AttributeValue { S = book.BookTitle } }
                    },
                    ExpressionAttributeNames = new Dictionary<string, string>
                    {
                        { "#P", "PagesRead" },
                        { "#D", "LastReadDate" }
                    },
                    ExpressionAttributeValues = new Dictionary<string, AttributeValue>
                    {
                        { ":pagesRead", new AttributeValue { N = currentPage.ToString() } },
                        { ":lastReadDate", new AttributeValue { S = DateTime.UtcNow.ToString("yyyy-MM-dd") } }
                    },
                    UpdateExpression = "SET #P = :pagesRead, #D = :lastReadDate"
                };

                await Client.UpdateItemAsync(request);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error updating book progress: " + ex.Message);
            }
        }
    }
}
