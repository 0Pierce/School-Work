using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab34
{
    public delegate void UnsubscribeHandler(string contact);

    public partial class SubForm : Form
    {


        public static List<string> subscribedEmails = new List<string>();
        public static List<string> subscribedPhoneNumbers = new List<string>();

        private Publisher publisher;

        private MenuForm menuForm;
        private Boolean validEmail;
        private Boolean validPNum;

        public event UnsubscribeHandler Unsubscribe;

        public SubForm(MenuForm menuForm, Publisher pub)
        {
            
            InitializeComponent();
            this.menuForm = menuForm;
          
            this.Show();
            Console.WriteLine("Showed new form");
            this.publisher = pub;
        }

        private void SubForm_Load(object sender, EventArgs e)
        {
     
        }

      

        private void btnUnsub_MouseClick(object sender, MouseEventArgs e)
        {
            if (cBoxEmail.Checked)
            {
                // Remove email from the list
                string emailToRemove = txtBoxEmail.Text.Trim();
                Unsubscribe?.Invoke(emailToRemove);
            }
            else if (cBoxSMS.Checked)
            {
                // Remove SMS from the list
                string smsToRemove = txtBoxSMS.Text.Trim();
                Unsubscribe?.Invoke(smsToRemove);
            }

            
            txtBoxEmail.Clear();
            txtBoxSMS.Clear();
            cBoxEmail.Checked = false;
            cBoxSMS.Checked = false;
        }

        private void btnSub_MouseClick(object sender, MouseEventArgs e)
        {
            if (validEmail || validPNum)
            {
                if (validEmail && !subscribedEmails.Contains(txtBoxEmail.Text))
                {
                    menuForm.SetPubButtonEnabled(true);
                    subscribedEmails.Add(txtBoxEmail.Text);
                    SendViaEmail emailSender = new SendViaEmail(txtBoxEmail.Text);
                    emailSender.Sub(publisher);
                    MessageBox.Show("Email subscribed!");
                    validEmail = false;
                }
                else if (validPNum && !subscribedPhoneNumbers.Contains(txtBoxSMS.Text))
                {
                    menuForm.SetPubButtonEnabled(true);
                    subscribedPhoneNumbers.Add(txtBoxSMS.Text);
                    SendViaPhone phoneSender = new SendViaPhone(txtBoxSMS.Text);
                    phoneSender.Sub(publisher);
                    MessageBox.Show("SMS subscribed!");
                    validEmail = false;
                }
                else
                {
                    MessageBox.Show("Email or phone number already subscribed!");
                }
               
            }
        }

        private void btnCancel_MouseClick(object sender, MouseEventArgs e)
        {
            this.Close();
            menuForm.Show();
        }

        private void cBoxEmail_CheckStateChanged(object sender, EventArgs e)
        {
            if (cBoxEmail.Checked)
            {
                txtBoxEmail.Enabled = true;
                cBoxSMS.Checked = false;
                lblSMS.Visible = false;
            }
            else
            {
                txtBoxEmail.Enabled = false;
                txtBoxEmail.Clear();
            }
        }

        private void cBoxSMS_CheckStateChanged(object sender, EventArgs e)
        {
            if (cBoxSMS.Checked)
            {
                txtBoxSMS.Enabled = true;
                cBoxEmail.Checked = false;
                lblEmail.Visible = false;
            }
            else
            {
                txtBoxSMS.Enabled = false;
                txtBoxSMS.Clear();
            }

        }

        private void txtBoxSMS_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!char.IsNumber(e.KeyChar) && e.KeyChar != (char)Keys.Back && e.KeyChar != '-')
            {
                e.Handled = true;
            }
        }

        public static bool IsValidPhoneNum(string num)
        {
            String format = @"^\d{3}-\d{3}-\d{4}$";
            bool isValid = Regex.IsMatch(num, format);
            if (isValid)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        }

        //Made using microsoft's C# exampple using regex
        public static bool IsValidEmail(string email)
        {
            if (string.IsNullOrWhiteSpace(email))
                return false;

            try
            {
               
                email = Regex.Replace(email, @"(@)(.+)$", DomainMapper,
                                      RegexOptions.None, TimeSpan.FromMilliseconds(200));

               
                string DomainMapper(Match match)
                {
                   
                    var idn = new IdnMapping();

                  
                    string domainName = idn.GetAscii(match.Groups[2].Value);

                    return match.Groups[1].Value + domainName;
                }
            }
            catch (RegexMatchTimeoutException e)
            {
                return false;
            }
            catch (ArgumentException e)
            {
                return false;
            }

            try
            {
                return Regex.IsMatch(email,
                    @"^[^@\s]+@[^@\s]+\.[^@\s]+$",
                    RegexOptions.IgnoreCase, TimeSpan.FromMilliseconds(250));
            }
            catch (RegexMatchTimeoutException)
            {
                return false;
            }
        }

        private void txtBoxEmail_Leave(object sender, EventArgs e)
        {
            if (IsValidEmail(txtBoxEmail.Text))
            {
                validEmail = true;
                lblEmail.Visible = false;
            }
            else
            {
                validEmail = false;
                lblEmail.Visible = true;
            }
        }

        private void txtBoxSMS_Leave(object sender, EventArgs e)
        {
            if (IsValidPhoneNum(txtBoxSMS.Text))
            {
                validPNum = true;
                lblSMS.Visible = false;
            }
            else
            {
                validPNum = false;
                lblSMS.Visible = true;
            }

        }

        //Makes sure both forms close
        private void SubForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            //menuForm.Close();
        }
    }
}
