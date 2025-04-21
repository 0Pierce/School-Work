using System;

namespace GerardThePlumber
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter the pipe length");
            double length = double.Parse(Console.ReadLine());

            Console.WriteLine("Enter the amount per meter");
            double lengthP = double.Parse(Console.ReadLine());
            double lenghtcost = length * lengthP;

           

            Console.WriteLine("Enter the amount of joints");
            double joints = double.Parse(Console.ReadLine());

            Console.WriteLine("Enter the price per joint");
            double jointsP = double.Parse(Console.ReadLine());
            double jointcost =joints * jointsP;

            double tPrice = jointcost + lenghtcost;
           


            Console.WriteLine("The total cost of the job will be: " + tPrice);

        }
    }
}
