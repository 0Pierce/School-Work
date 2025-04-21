using Amazon.DynamoDBv2;
using Amazon.DynamoDBv2.Model;
using Amazon.Runtime;
using System.ComponentModel;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace A2_DynamoDB
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        private static readonly AmazonDynamoDBClient client = new AmazonDynamoDBClient(
            new BasicAWSCredentials("", ""),
            new AmazonDynamoDBConfig
            {
                RegionEndpoint = Amazon.RegionEndpoint.CACentral1 // Canada Central region
            }
        );
        private static string tableName = "users";

        public MainWindow()
        {
            InitializeComponent();
            createTable();
            initDB();




        }


        private async void initDB()
        {


            await createTable();

            for (int i = 0; i < 3; i++)
            {
                await createUser($"name{i}@gmail.com", $"pass{i}{i + 1}");
            }
        }




        public static async Task createTable()
        {
            try
            {
                /*MessageBox.Show("Connected");*/
                // Check if the table already exists
                var existingTable = await client.DescribeTableAsync(new DescribeTableRequest
                {
                    TableName = tableName
                });

                if (existingTable.Table != null)
                {
                    Console.WriteLine($"Table '{tableName}' already exists.");
                    /*MessageBox.Show("Table exists");*/
                    return; // Table already exists, no need to create it
                }
            }
            catch (ResourceNotFoundException)
            {
                
                Console.WriteLine($"Table '{tableName}' does not exist. Creating table...");
                /*MessageBox.Show("Creating Table");*/

                var request = new CreateTableRequest
                {
                    TableName = tableName,
                    AttributeDefinitions = new List<AttributeDefinition>
            {
               
                new AttributeDefinition
                {
                    AttributeName = "Username",
                    AttributeType = "S" 
                }
               
            },

                    KeySchema = new List<KeySchemaElement>
            {
                new KeySchemaElement
                {
                    AttributeName = "Username",
                    KeyType = "HASH"
                }
            },
                    ProvisionedThroughput = new ProvisionedThroughput
                    {
                        ReadCapacityUnits = 2,
                        WriteCapacityUnits = 2
                    }
                };

                var response = await client.CreateTableAsync(request);
               
            }
            catch (Exception e)
            {
                Console.WriteLine("Failed to create table: " + e.Message);
            }
        }


        public static async Task createUser(string username, string hashedPassword)
        {
            var user = new Dictionary<string, AttributeValue> {
                { "Username", new AttributeValue { S = username } },
                { "Password", new AttributeValue { S = hashedPassword } } 
            };

            var putItemRequest = new PutItemRequest
            {
                TableName = tableName,
                Item = user
            };

            await client.PutItemAsync(putItemRequest);
            
        }




        private async void Button_Click(object sender, RoutedEventArgs e)
        {
            if (string.IsNullOrEmpty(tbPass.Password) && string.IsNullOrEmpty(tbUsername.Text))
            {
                MessageBox.Show("Fill out the fields");
            }
            else
            {


                if(await authUser(tbUsername.Text, tbPass.Password))
                {
                    
                    EbookReader window = new EbookReader(tbUsername.Text, client);
                    window.Show();
                    this.Close();
                }
                else
                {
                    MessageBox.Show("Invalid Login");
                }
               
            }
        }


        private static async Task<bool> authUser(string user, string pass)
        {
            var request = new GetItemRequest
            {
                TableName = "users",
                Key = new Dictionary<string, AttributeValue>
        {
            { "Username", new AttributeValue { S = user } }
        }
            };

            var response = await client.GetItemAsync(request);

            
            if (response.Item.Count > 0)
            {
                
                string storedPassword = response.Item["Password"].S;

                
                return pass == storedPassword; 
            }

            
            return false;
        }


    }


 }


