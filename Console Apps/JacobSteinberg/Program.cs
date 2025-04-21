using System;

namespace JacobSteinberg
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter the miles driven");
            int miles = int.Parse(Console.ReadLine());

            Console.WriteLine("Enter the fueled used");
            int fuelU = int.Parse(Console.ReadLine());

            int mileage = miles * fuelU;

            Console.WriteLine("Your mileage is: "+ mileage);

        }
    }
}
