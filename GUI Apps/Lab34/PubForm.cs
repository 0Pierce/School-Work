using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab34
{
    public partial class PubForm : Form
    {
        private Publisher publisher;

        public PubForm(Publisher pub)
        {
            InitializeComponent();
            this.publisher = pub;
        }

        private void PubForm_Load(object sender, EventArgs e)
        {
           
        }

        private void btnPubl_MouseClick(object sender, MouseEventArgs e)
        {
            if (publisher != null)
            {
                publisher.PublishMessage(txtbContent.Text);

                // Get all subscribed emails
                string emails = string.Join(", ", SubForm.subscribedEmails);

                // Get all subscribed phone numbers
                string phoneNumbers = string.Join(", ", SubForm.subscribedPhoneNumbers);

                // Display
                MessageBox.Show($"Message {txtbContent.Text} sent to:\nEmails: {emails}\nPhone Numbers: {phoneNumbers}");
            }
            else
            {
                MessageBox.Show("Publisher object is null. Message cannot be sent.");
            }
        }

        private void btnExitP_MouseClick(object sender, MouseEventArgs e)
        {
            this.Close();
        }
    }
}
