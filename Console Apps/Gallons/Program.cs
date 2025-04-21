using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gallons
{
    class Program
    {

        /*
         * Write a C# program that displays a conversion table from gallons to liters. The program should
           display gallons from 10 to 20 in one-gallon increments and the corresponding liter equivalents.
           Use the relationship that 1 gallon contains 3.785 liters. Your table must look professional!
         */

        static void Main(string[] args)
        {

            int count = 10;
            double liter = 0;
            

            while (count <= 20)
            {

                Console.WriteLine($" - {count} Gallons = {liter = count * 3.785 }");


                count++;

            }

            Console.WriteLine();





        }
    }
}
