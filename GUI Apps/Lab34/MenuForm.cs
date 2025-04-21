using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Lab34
{
    public partial class MenuForm : Form
    {
        private Publisher publisher;


        public MenuForm()
        {
            Console.WriteLine("Started program");
            InitializeComponent();
            publisher = new Publisher();
            
        }

        private void MenuForm_Load(object sender, EventArgs e)
        {

        }

        public void SetPubButtonEnabled(bool enabled)
        {
            btnPubN.Enabled = enabled;
        }


        private void btnManSubs_Click(object sender, EventArgs e)
        {
            
            Console.WriteLine("Clicked");
            SubForm subForm = new SubForm(this,publisher);
            Console.WriteLine("Called new form");
            subForm.Unsubscribe += HandleUnsubscription;
            this.Hide();
            

        }

        private void btnPublish_Click(object sender, EventArgs e)
        {
            PubForm PubForm = new PubForm(publisher);
            PubForm.Show();
        }

      

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        public void HandleUnsubscription(string contact)
        {
            if (SubForm.subscribedEmails.Contains(contact))
            {
                SubForm.subscribedEmails.Remove(contact);
            }
            else if (SubForm.subscribedPhoneNumbers.Contains(contact))
            {
                SubForm.subscribedPhoneNumbers.Remove(contact);
            }
        }
    }
}
