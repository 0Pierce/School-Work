using System;

namespace PerryBrown
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter 4 sides of a polygon");
            double s1 = Double.Parse(Console.ReadLine());
            double s2 = Double.Parse(Console.ReadLine());
            double s3 = Double.Parse(Console.ReadLine());
            double s4 = Double.Parse(Console.ReadLine());

            double perimeter = s1 + s2 + s3 + s4;

            Console.WriteLine("Your perimeter is: " + perimeter);
        }
    }
}
