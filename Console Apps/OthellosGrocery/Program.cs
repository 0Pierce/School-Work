using System;

namespace OthellosGrocery
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter the weight KG");
            double weight = double.Parse(Console.ReadLine());

            Console.WriteLine("Enter the price");
            double price = double.Parse(Console.ReadLine());

            double bagAmount = weight / 5;

            double cost = weight * price;
            double costF = cost + bagAmount * 5;

            Console.WriteLine("Final variables are: " + bagAmount + " , " + cost + " " );
            Console.WriteLine("The total cost is: " + costF + "$");
        }
    }
}
