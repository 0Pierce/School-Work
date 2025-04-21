using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab3WPF.Models
{
    public class Item
    {
        public int Id {  get; set; } 
        public string Name { get; set; }
        public string Category { get; set; }
        public double Price { get; set; }


  

        //Constructor
        public Item(int id, string name, string category, double price)
        {
            this.Id = id;
            this.Name = name;
            this.Category = category;
            this.Price = price;

        }

        public override string ToString()
        {
            return Name; // Return the name of the item
        }
    }
}
