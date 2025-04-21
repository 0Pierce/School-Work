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
using System.Web;
using System.IO;
using System.Text.Json;

namespace Lab102
{
    public partial class Form1 : Form
    {

        private Dictionary<string, PrimeMinister> primeMinisters =
        new Dictionary<string, PrimeMinister>();


        public Form1()
        {
            InitializeComponent();

            string fileName = "PrimeMinisters.json";
            StreamReader reader = new StreamReader(fileName);


            string serializedAtom = JsonSerializer.Serialize(elements[0]);

            primeMinisters = serializer.Deserialize
            <Dictionary<string, PrimeMinister>>(streamReader.ReadToEnd());


        }

        private void label1_Click(object sender, EventArgs e)
        {
            
        }
    }
}
