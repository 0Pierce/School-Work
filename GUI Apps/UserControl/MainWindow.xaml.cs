using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace UserControl
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        public static string UserName { get; private set; }
        public static string UserPass { get; private set; }


        public MainWindow()
        {
            InitializeComponent();
            UserName = tbName.Text;
            UserPass = tbPass.Password;
        }
    }
}