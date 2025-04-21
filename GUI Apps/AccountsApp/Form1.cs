using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace AccountsApp
{
    public partial class Accounts : Form
    {

        private List<Account> accounts;
        private List<double> limit;
        private List<double> interest;

        public Accounts()
        {
            InitializeComponent();
            accounts = new List<Account>();
            limit = new List<double>();
            interest = new List<double>();
            
        }

        private void Accounts_Load(object sender, EventArgs e)
        {

        }

       

        private void checkingBut_CheckedChanged(object sender, EventArgs e)
        {
            limitBox.Enabled = true;
            interestBox.Enabled = false;
            interestBox.BackColor = Color.Tomato;
            limitBox.BackColor = Color.Green;
            //savingBut.Checked = false;
        }

        private void savingBut_CheckedChanged(object sender, EventArgs e)
        {
            limitBox.Enabled = false;
            interestBox.Enabled = true;
            limitBox.BackColor = Color.Tomato;
            interestBox.BackColor = Color.Green;
            //checkingBut.Checked = false;
        }

        private void createAccbtn_Click(object sender, EventArgs e)
        {
            if (accNumBox.Text != null && cNameBox != null && balBox.Text != null && (limitBox.Text != null || interestBox.Text != null))
            {

               try
               {

              

                if (checkingBut.Checked)
                {
                    //Storing this in an array for easier access.
                    limit.Add(double.Parse(limitBox.Text));

                    Account account = new CheckingAcc(int.Parse(accNumBox.Text), cNameBox.Text, int.Parse(balBox.Text), double.Parse(limitBox.Text));
                    accounts.Add(account);
                }
                else if (savingBut.Checked)
                {
                    //Storing this in an array for easier access.
                    interest.Add(double.Parse(interestBox.Text));

                    Account account = new SavingsAcc(int.Parse(accNumBox.Text), cNameBox.Text, int.Parse(balBox.Text), double.Parse(interestBox.Text));
                    accounts.Add(account);
                }

               }
                catch (FormatException ex)
                {
                    MessageBox.Show($"Invalid Input {ex.Message}");
                }

                accNumBox.Clear();
                cNameBox.Clear();
                balBox.Clear();
                interestBox.Clear();
                limitBox.Clear();
                checkingBut.Checked = true;

                MessageBox.Show($"Account Created! There are {accounts.Count} accounts");
                

            }
            else
            {
                MessageBox.Show("Missing Field");
            }

        }

        private void accSearchbtn_Click(object sender, EventArgs e)
        {
            if(accNumSearchBox.Text!= null)
            {
                int number = int.Parse(accNumSearchBox.Text);
                for(int i = 0; i< accounts.Count; i++) 
                { 
                    if(number == accounts[i].Number) 
                    
                    {
                        accNumBox.Text = accounts[i].Number.ToString();
                        cNameBox.Text = accounts[i].Name.ToString();
                        balBox.Text = accounts[i].Balance.ToString();

                        //This doesnt really work, 
                        if (i < limit.Count)
                        {
                            limitBox.Text = limit[i].ToString();
                        }
                        if (i < interest.Count)
                        {
                            interestBox.Text = interest[i].ToString();
                        }
                        


                    }
                
                }
            }
        }
    }
}
