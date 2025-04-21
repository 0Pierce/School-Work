using System;

namespace WillowPools
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter the length of the rectangle");
            double length = Double.Parse(Console.ReadLine());

            Console.WriteLine("Enter the width");
            double width = Double.Parse(Console.ReadLine());

            Console.WriteLine("Enter the height");
            double height = Double.Parse(Console.ReadLine());

            double volume = length * width * height;

            Console.WriteLine("The volume is: " + volume + "ft^3");

        }
    }
}
