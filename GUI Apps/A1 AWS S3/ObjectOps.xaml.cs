using Amazon;
using Amazon.Runtime;
using Amazon.S3;
using Amazon.S3.Model;
using Amazon.S3.Transfer;
using Microsoft.Win32;
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

namespace A1_AWS_S3
{


    public class S3ObjectInfo
    {
        public string Name { get; set; }
        public long Size { get; set; }
    }

    /// <summary>
    /// Interaction logic for ObjectOps.xaml
    /// </summary>
    public partial class ObjectOps : Window
    {


        private static readonly AWSCredentials credentials = new BasicAWSCredentials("", "");
        private static readonly IAmazonS3 s3Client = new AmazonS3Client(credentials, RegionEndpoint.CACentral1);
        private string objectPath;
        public ObservableCollection<S3ObjectInfo> S3Objects { get; set; }

        public ObjectOps()
        {

      

            InitializeComponent();
            S3Objects = new ObservableCollection<S3ObjectInfo>();
            loadBuckets();


        }

        private async void loadBuckets()
        {

            try
            {
                var bucketListResponse = await s3Client.ListBucketsAsync();
                var bucketsList = new List<string>();

                foreach (var bucket in bucketListResponse.Buckets)
                {
                    bucketsList.Add(bucket.BucketName);
                }
                dbObject.ItemsSource = bucketsList;
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error loading buckets: {ex.Message}");
            }
        }

        private async void loadObjects()
        {
            
            string selectedBucket = dbObject.SelectedItem as string; 

            if (!string.IsNullOrEmpty(selectedBucket))
            {
                try
                {
                    S3Objects.Clear();

                   
                    var request = new ListObjectsV2Request
                    {
                        BucketName = selectedBucket 
                    };

                    
                    var response = await s3Client.ListObjectsV2Async(request);

                    foreach (S3Object obj in response.S3Objects)
                    {
                        S3Objects.Add(new S3ObjectInfo
                        {
                            Name = obj.Key,
                            Size = obj.Size
                        });
                    }

                   objectDataGrid.ItemsSource = S3Objects;
                }
                catch (AmazonS3Exception ex)
                {
                    MessageBox.Show($"Error loading objects: {ex.Message}");
                }
            }
            else
            {
                MessageBox.Show("Select a bucket");
                MessageBox.Show($"Bucket name: '{selectedBucket}'");
            }
        }


        private void btnBack_Click(object sender, RoutedEventArgs e)
        {
            MainWindow main = new MainWindow();
            main.Show();
            this.Close();

        }

        private void btnBrowse_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog fileDialog = new OpenFileDialog();

            if(fileDialog.ShowDialog()==true )
            {
                objectPath = fileDialog.FileName;
                tbObject.Text = objectPath;
            }
        }

        private void btnUpload_Click(object sender, RoutedEventArgs e)
        {
            if (string.IsNullOrEmpty(tbObject.Text) == false && dbObject.Text != null)
            {

                uploadObject();

            }
            else
            {
                MessageBox.Show("Please enter a file path");
            }
        }

        private async void uploadObject()
        {
            try
            {
                var fileTransferUtility = new TransferUtility(s3Client);
                await fileTransferUtility.UploadAsync(tbObject.Text, dbObject.Text);
                loadObjects();
            }catch(Exception ex)
            {
                MessageBox.Show($"Error uploading object: {ex.Message}");
            }
           
        }

        private void dbObject_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            loadObjects();
        }
    }
}
