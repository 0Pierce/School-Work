using System;

namespace BuildersINC
{
    class Program
    {
        static void Main(string[] args)
        {
            
            //Input
            Console.WriteLine("Enter the diameter in ft");
            double diameter = Double.Parse(Console.ReadLine());

            Console.WriteLine("Enter the price of railing per foot");
            double price = Double.Parse(Console.ReadLine());

            //Processing
            //Gets the circumference and cost
            double circumference = 2 * 3.14 * (diameter / 2);
            double cost = circumference * price;

            //Output
            //Rounds the two doubles to 2 d places
            Console.WriteLine("The circumference is: " + Math.Round(circumference, 2) + " The cost is: " + Math.Round(cost, 2) + "$");
        }
    }
}
