using System;
using System.Collections.Generic;
using System.Diagnostics;
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

namespace Lab3WPF
{
    /// <summary>
    /// Interaction logic for UserControl.xaml
    /// </summary>
    public partial class UserControl : Window
    {

        //Im really unsure how were suppose to set up the properties
        //So Im going to do all of them
        //Since the assignment asks to create getters and setter methods
        public static string UserName;
        public static string Password;

        //Another way
        public static string UserName2 {  get; private set; }
        public static string Password2 { get; private set; }

        public bool send;

        public UserControl()
        {
            InitializeComponent();
            //One way of doing it
            UserName2 = tbName.Text;
            Password2 = tbPass.Password.ToString();
            
        }


        //Another way of doing it, and its read only
        public string getUserName()
        {
            return tbName.Text.ToString();
        }

        public string getPassword()
        {
            return tbPass.Password.ToString();
        }

        //Really unsure what kind of test im suppose to do? The question simply says to create a driver
        //So I popup the window and let the user input and then output the properties using the methods.
        //I hope this is fine
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Trace.WriteLine($"Username: {getUserName()}");
            Trace.WriteLine($"Password: {getPassword()}");
        }
    }
}
