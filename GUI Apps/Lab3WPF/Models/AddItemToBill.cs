using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab3WPF.Models
{
    public class AddItemToBill
    {
        public string Name { get; set; }
        public double Price { get; set; }

        public int Quant {  get; set; }


        public AddItemToBill(string name, double price, int quant)
        {
            this.Name = name;
            this.Price = price;
            this.Quant = quant;
        }



        public override string ToString()
        {
            return this.Name;
        }
    }
}
