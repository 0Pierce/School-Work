using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab3WPF.Models
{
    public class Menu
    {


        public static IEnumerable<Item> GetAll()
        {

            //Beverages
            yield return new Item(999, null, "Beverage", 0);
            yield return new Item(1, "Soda", "Beverage", 1.95);
            yield return new Item(2, "Tea", "Beverage", 1.5);
            yield return new Item(3, "Coffee", "Beverage", 1.25);
            yield return new Item(4, "Mineral Water", "Beverage",2.95);
            yield return new Item(5, "Juice", "Beverage", 2.5);
            yield return new Item(6, "Milk", "Beverage", 1.5);
            yield return new Item(6, "Coke", "Beverage", 3);

            //Appetizers
            yield return new Item(998, null, "Appetizer", 0);
            yield return new Item(7, "Buffalo Wings", "Appetizer", 5.95);
            yield return new Item(8, "Buffalo Fingers", "Appetizer", 6.95);
            yield return new Item(9, "Potato Skins", "Appetizer", 8.95);
            yield return new Item(10, "Nachos", "Appetizer", 8.95);
            yield return new Item(11, "Mushroom Caps", "Appetizer", 10.95);
            yield return new Item(12, "Shrimp Cocktail", "Appetizer", 12.95);
            yield return new Item(13, "Chips and Salsa", "Appetizer", 6.95);

            //Main Courses
            yield return new Item(997, null, "Main Course", 0);
            yield return new Item(14, "Chicken Alfredo", "Main Course", 13.95);
            yield return new Item(15, "Chicken Picatta", "Main Course", 13.95);
            yield return new Item(16, "Turkey Club", "Main Course", 11.95);
            yield return new Item(17, "Lobster Pie", "Main Course", 19.95);
            yield return new Item(18, "Prime Rib", "Main Course", 20.95);
            yield return new Item(19, "Shrimp Scampi", "Main Course", 18.95);
            yield return new Item(20, "Turkey Dinner", "Main Course", 13.95);
            yield return new Item(21, "Stuffed Chicken", "Main Course", 14.95);
            yield return new Item(22, "Seafood Alfredo", "Main Course", 15.95);

            //Deserts
            yield return new Item(996, null, "Desert", 0);
            yield return new Item(23, "Apple Pie", "Desert", 3.95);
            yield return new Item(24, "Carrot Cake", "Desert", 5.95);
            yield return new Item(25, "Mud Pie", "Desert", 4.95);
            yield return new Item(26, "Apple Crisp", "Desert", 5.95);



        }


        public static double getPrice(string name)
        {
            Trace.WriteLine($"name: {name}");

            Item item = GetAll().FirstOrDefault(p => p.Name == name);
            return item.Price;
        }

        public static IEnumerable<Item> getCategory(string cat) { 
        
            return GetAll().Where<Item>(p => p.Category == cat);
        
        }

    }
}
