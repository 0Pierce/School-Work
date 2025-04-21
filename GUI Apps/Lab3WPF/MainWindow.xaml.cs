using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Xml.Linq;
using Lab3WPF.Models;

namespace Lab3WPF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {


        ObservableCollection<AddItemToBill> billList = new ObservableCollection<AddItemToBill>();

        public MainWindow()
        {
            InitializeComponent();
            fillComboBoxes();
            billList.CollectionChanged += BillList_CollectionChanged;
        }


        private void fillComboBoxes()
        {
            Trace.WriteLine("Filled boxes");
            CBBeverages.ItemsSource = Models.Menu.getCategory("Beverage");
            CBAppetizers.ItemsSource = Models.Menu.getCategory("Appetizer");
            CBMainCourses.ItemsSource = Models.Menu.getCategory("Main Course");
            CBDessert.ItemsSource = Models.Menu.getCategory("Desert");
        }

  

        private void Button_Click_Add(object sender, RoutedEventArgs e)
        {
            updateBill();
        }


        private void updateBill(AddItemToBill editedItem = null)
        {
            Trace.WriteLine("Clicked");
            List<string> selected = new List<string>();

            if (CBBeverages.SelectedItem != null)
            {
                selected.Add(CBBeverages.SelectedItem.ToString());
            }
            if (CBAppetizers.SelectedItem != null)
            {
                selected.Add(CBAppetizers.SelectedItem.ToString());
            }
            if (CBMainCourses.SelectedItem != null)
            {
                selected.Add(CBMainCourses.SelectedItem.ToString());
            }
            if (CBDessert.SelectedItem != null)
            {
                selected.Add(CBDessert.SelectedItem.ToString());
            }
            Trace.WriteLine("Clicked 2");
            if (editedItem != null)
            {
                
                 editedItem.Quant = editedItem.Quant;
                 editedItem.Price = Models.Menu.getPrice(editedItem.Name) * editedItem.Quant;
            }

            int count = 1;

            Trace.WriteLine("Before loop");
            foreach (string sel in selected)
            {
                if (sel != null)
                {
                    // Find an existing item in the billList
                    var existingItem = billList.FirstOrDefault(item => item.Name == sel);
                    if (existingItem != null)
                    {
                        // Increment the quantity of the existing item
                        existingItem.Quant++;
                        existingItem.Price = Models.Menu.getPrice(sel) * existingItem.Quant;
                    }
                    else
                    {
                        // Add a new item if it doesn't exist
                        AddItemToBill item = new AddItemToBill(sel, Models.Menu.getPrice(sel), 1);
                        billList.Add(item);
                    }
                }
                else
                {
                    Console.WriteLine("Found null");
                }
            }

            Trace.WriteLine("Refresh");
            // Refresh the DataGrid
            dataGridBill.ItemsSource = null;
            dataGridBill.ItemsSource = billList;
            double total = 0;
            double tax = 0;
            Trace.WriteLine("Changing costs");
            foreach (AddItemToBill item in billList)
            {
                total += item.Price;
                tax += item.Price * 0.13;
            }
            Trace.WriteLine("Changed costs");
            lblTax.Content = $"${tax.ToString("0.00")}";
            lblTotal.Content = $"${total.ToString("0.00")}";
            lblTotalTax.Content = $"${(total + tax).ToString("0.00")}";

            Trace.WriteLine("Set Values");
            CBAppetizers.SelectedValue = " ";
            CBBeverages.SelectedValue = " ";
            CBDessert.SelectedValue = " ";
            CBMainCourses.SelectedValue = " ";
            Trace.WriteLine("Finished");
        }





        private void Button_Click_Clear(object sender, RoutedEventArgs e)
        {
            billList.Clear();
            dataGridBill.ItemsSource = billList;
            lblTotal.Content = "$0.00";
            lblTax.Content = "$0.00";
            lblTotalTax.Content = "$0.00";
        }
        private bool isCommittingEdit = false;
        private void DataGrid_CellEditEnding(object sender, DataGridCellEditEndingEventArgs e)
        {
            // Check if the edited column is the Quantity column
            if (e.Column.Header.ToString() == "Quantity" && !isCommittingEdit)
            {
                isCommittingEdit = true;
                dataGridBill.CommitEdit(DataGridEditingUnit.Row, true);
                isCommittingEdit = false;
                var editedItem = (AddItemToBill)e.Row.Item;
                updateBill(editedItem);


            }
        }

        private void BillList_CollectionChanged(object sender, System.Collections.Specialized.NotifyCollectionChangedEventArgs e)
        {
            // Check if the action was a removal
            if (e.Action == System.Collections.Specialized.NotifyCollectionChangedAction.Remove)
            {

                double total = 0;
                double tax = 0;
                Trace.WriteLine("Changing costs");
                foreach (AddItemToBill item in billList)
                {
                    total += item.Price;
                    tax += item.Price * 0.13;
                }
                Trace.WriteLine("Changed costs");
                lblTax.Content = $"${tax.ToString("0.00")}";
                lblTotal.Content = $"${total.ToString("0.00")}";
                lblTotalTax.Content = $"${(total + tax).ToString("0.00")}";
            }
        }


        private void logo_Click(object sender, RoutedEventArgs e)
        {
            Trace.WriteLine("Clicked logo");

            try
            {
                var startInfo = new ProcessStartInfo
                {
                    FileName = "https://www.youtube.com",
                    UseShellExecute = true
                };
                Process.Start(startInfo);

            }
            catch (System.ComponentModel.Win32Exception noBrowser)
            {
                if (noBrowser.ErrorCode == -2147467259)
                    MessageBox.Show(noBrowser.Message);
            }
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            UserControl loginUserControl = new UserControl();
            loginUserControl.Show();
  
        }
    }
}