using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Length_Conv
{
    class Program
    {

        /*
         * Write a C# program that converts feet to meters. The program should display feet from 3 to 30
           in three-foot increments and the corresponding meter equivalents. Use the relationship that 1
           meter is equivalent to 3.28 feet. Your table must look professional!
         */

        static void Main(string[] args)
        {
            double meter=0;
            for (double i = 3; i <= 30; i += 3) 
            {

                Console.WriteLine($"{i} feet  = Meters {meter = i/3.28}");



            }



        }
    }
}
