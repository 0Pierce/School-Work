using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using static System.Reflection.Metadata.BlobBuilder;

namespace A2_DynamoDB
{
    /// <summary>
    /// Interaction logic for EbookReader.xaml
    /// </summary>
    /// 

    public class Book
    {
        public string BookTitle { get; set; }
        public string BookAuthor { get; set; }
        public string LastReadDate { get; set; }
        public string PdfURL {  get; set; }
        public int PagesRead { get; set; }

    }


    public partial class EbookReader : Window
    {
        private static AmazonDynamoDBClient client;
        private static ObservableCollection<Book> Books { get; set; }
        private static string UserName;


        public EbookReader(string username, AmazonDynamoDBClient Client)
        {
            InitializeComponent();

            UserName = username;
            client = Client;
            Books = new ObservableCollection<Book>();
            bookList.ItemsSource = Books;

            lblWelcome.Content = "Hello "+username;


            createBooks();
            loadBooksList();
        }


        private static async void createBooks()
        {
            Book book = new Book();
            book.BookTitle = "Lab2";
            book.LastReadDate = "2022-05-01";
            book.PagesRead = 0;
            book.BookAuthor = "Prof";
            book.PdfURL = "https://booksbucketlab.s3.ca-central-1.amazonaws.com/Lab%232.pdf";
            await UploadBookAsync(book);

/*            Book book2 = new Book();
            book2.BookTitle = "Lab4";
            book2.LastReadDate = "2022-05-01";
            book2.PagesRead = 0;
            book2.BookAuthor = "Prof#2";
            book2.PdfURL = "https://booksbucketlab.s3.ca-central-1.amazonaws.com/Lab%231.pdf";
            await UploadBookAsync(book2);*/
        }


        private static async void loadBooksList()
        {
            try
            {
                var request = new QueryRequest
                {
                    TableName = "bookShelf",
                    KeyConditionExpression = "UserName = :userName",
                    ExpressionAttributeValues = new Dictionary<string, AttributeValue> {
                    { ":userName", new AttributeValue { S = UserName } }
                }};

                var response = await client.QueryAsync(request);

                var books = response.Items.Select(item => new Book
                {
                    BookTitle = item["BookTitle"].S,
                    BookAuthor = item["BookAuthor"].S,
                    LastReadDate = item["LastReadDate"].S,
                    PdfURL = item["PDFUrl"].S,
                    PagesRead = int.Parse(item["PagesRead"].N)
                }).OrderByDescending(b => DateTime.Parse(b.LastReadDate)).ToList();

                Books.Clear(); 
                foreach (var book in books)
                {
                    Books.Add(book);
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error loading books: " + ex.Message);
            }
        }


        private static async Task UploadBookAsync(Book book)
        {
            try
            {
                var request = new PutItemRequest
                {
                    TableName = "bookShelf",
                    Item = new Dictionary<string, AttributeValue>
            {
                { "UserName", new AttributeValue { S = UserName } }, // Partition key
                { "BookTitle", new AttributeValue { S = book.BookTitle } },
                { "BookAuthor", new AttributeValue { S = book.BookAuthor } },
                { "PDFUrl", new AttributeValue { S = book.PdfURL } },
                { "LastReadDate", new AttributeValue { S = book.LastReadDate } },
                { "PagesRead", new AttributeValue { N = book.PagesRead.ToString() } }
            }
                };

                await client.PutItemAsync(request);
                /*MessageBox.Show("Book uploaded successfully.");*/
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error uploading book: " + ex.Message);
            }
        }


        private void bookList_Selected(object sender, SelectionChangedEventArgs e)
        {
            if(bookList.SelectedItem is Book selectedBook)
            {


                BookViewer bookViewer = new BookViewer(selectedBook, this, client, UserName);
                bookViewer.Show();
                this.Hide();
            }
        }

    }
}
