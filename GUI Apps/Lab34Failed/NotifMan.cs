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
    public partial class NotifMan : Form
    {
        public NotifMan()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void btnManSub_Click(object sender, EventArgs e)
        {
            
            ManSubs subsFrame = new ManSubs();
            subsFrame.Show();
            this.Hide();

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

     
    }
}
