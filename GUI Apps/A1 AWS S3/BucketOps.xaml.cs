using Amazon;
using Amazon.Runtime;
using Amazon.S3;
using Amazon.S3.Model;
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
    /// <summary>
    /// Interaction logic for BucketOps.xaml
    /// </summary>
    public partial class BucketOps : Window
    {
        private static readonly AWSCredentials credentials = new BasicAWSCredentials("", "");
        private static readonly IAmazonS3 s3Client = new AmazonS3Client(credentials, RegionEndpoint.CACentral1);

        public ObservableCollection<S3Bucket> Buckets { get; set; }

        public BucketOps()
        {
         
            InitializeComponent();
            Buckets = new ObservableCollection<S3Bucket>();
            LoadBuckets();
            bucketDataGrid.ItemsSource = Buckets;

        }



        private async void LoadBuckets()
        {
            try
            {
                var response = await s3Client.ListBucketsAsync();
                Buckets.Clear();
                foreach (var bucket in response.Buckets)
                {
                    Buckets.Add(bucket);
                }
                bucketDataGrid.ItemsSource = Buckets;
            }
            catch (AmazonS3Exception ex)
            {
                MessageBox.Show($"Error loading buckets: {ex.Message}");
            }
        }

        private void btnBack_Click(object sender, RoutedEventArgs e)
        {
           MainWindow main = new MainWindow();
           main.Show();
           this.Close();

        }

        private async void btnCreateBucket_Click(object sender, RoutedEventArgs e)
        {
            string bucketName = tbBucketName.Text.Trim();
            if (!string.IsNullOrEmpty(bucketName))
            {
                try
                {
                    await s3Client.PutBucketAsync(new PutBucketRequest
                    {
                        BucketName = bucketName
                    });
                    MessageBox.Show("Bucket created successfully.");
                    LoadBuckets(); // Refresh the bucket list
                }
                catch (AmazonS3Exception ex)
                {
                    MessageBox.Show($"Error creating bucket: {ex.Message}");
                }
            }
            else
            {
                MessageBox.Show("Please enter a valid bucket name.");
            }
        }

        private async void btnDeleteBucket_Click(object sender, RoutedEventArgs e)
        {
            string bucketName = tbBucketName.Text.Trim();

            if(!string.IsNullOrEmpty(bucketName))
            {
                try
                {
                    await s3Client.DeleteBucketAsync(new DeleteBucketRequest
                    {
                        BucketName = bucketName
                    });
                    MessageBox.Show($"Bucket: {bucketName} has been deleted");
                    LoadBuckets();
                }
                catch(AmazonS3Exception ex)
                {
                    MessageBox.Show($"Error deleting {bucketName} | Error: {ex.Message}");
                }
            }
        }
    }
}
