using PrimeMinisters;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Text.Json;


namespace Lab102
{
    public partial class frmPrimeMinisters : Form
    {

        private Dictionary<string, PrimeMinister> primeMinisters = new Dictionary<string, PrimeMinister>();

        public frmPrimeMinisters()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

            

            string fileName = "PrimeMinisters.json";
            StreamReader reader = new StreamReader(fileName);

            primeMinisters = JsonSerializer.Deserialize<Dictionary<string, PrimeMinister>>(reader.ReadToEnd());

            lsPms.DataSource = primeMinisters.Keys.ToList<string>();
            
        }

        private void lsPms_SelectedIndexChanged(object sender, EventArgs e)
        {

            string[] pictures = new string[8];
           
            //Adds all of the pictures to the array
            for(int i = 0; i < pictures.Length; i++)
            {
                pictures[i] = $"{i}.jpg";
            }


           

            int select = lsPms.SelectedIndex;
            //MessageBox.Show(select.ToString());
            //MessageBox.Show(primeMinisters.ElementAt(2).ToString());

            PrimeMinister pm = primeMinisters[lsPms.SelectedItem.ToString()];

            switch (select)
            {
                case 0:
                    picPhoto.Image = Image.FromFile(pictures[0]);
                    lblName.Text = $"{pm.FirstName} { pm.LastName}";
                    lblTerm.Text = $"Term: { pm.Term}";
                    lblParty.Text = $"Party: {pm.Party}";
                    break;
                case 1:
                    picPhoto.Image = Image.FromFile(pictures[1]);
                    lblName.Text = $"{pm.FirstName} {pm.LastName}";
                    lblTerm.Text = $"Term: {pm.Term}";
                    lblParty.Text = $"Party: {pm.Party}";
                    break;
                case 2:
                    picPhoto.Image = Image.FromFile(pictures[2]);
                    lblName.Text = $"{pm.FirstName} {pm.LastName}";
                    lblTerm.Text = $"Term: {pm.Term}";
                    lblParty.Text = $"Party: {pm.Party}";
                    break;
                case 3:
                    picPhoto.Image = Image.FromFile(pictures[3]);
                    lblName.Text = $"{pm.FirstName} {pm.LastName}";
                    lblTerm.Text = $"Term: {pm.Term}";
                    lblParty.Text = $"Party: {pm.Party}";
                    break;
                case 4:
                    picPhoto.Image = Image.FromFile(pictures[4]);
                    lblName.Text = $"{pm.FirstName} {pm.LastName}";
                    lblTerm.Text = $"Term: {pm.Term}";
                    lblParty.Text = $"Party: {pm.Party}";
                    break;
                case 5:
                    picPhoto.Image = Image.FromFile(pictures[5]);
                    lblName.Text = $"{pm.FirstName} {pm.LastName}";
                    lblTerm.Text = $"Term: {pm.Term}";
                    lblParty.Text = $"Party: {pm.Party}";
                    break;
                case 6:
                    picPhoto.Image = Image.FromFile(pictures[6]);
                    lblName.Text = $"{pm.FirstName} {pm.LastName}";
                    lblTerm.Text = $"Term: {pm.Term}";
                    lblParty.Text = $"Party: {pm.Party}";
                    break;
                case 7:
                    picPhoto.Image = Image.FromFile(pictures[7]);
                    lblName.Text = $"{pm.FirstName} {pm.LastName}";
                    lblTerm.Text = $"Term: {pm.Term}";
                    lblParty.Text = $"Party: {pm.Party}";
                    break;



                    
            }
        }

     
    }
}
