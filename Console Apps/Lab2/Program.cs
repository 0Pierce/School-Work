using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;




namespace Lab2
{

    /*
     * A machine purchased for $28,000 depreciates at a rate of $4,000 a year for seven years. Write and run a
       C# program that computes and displays a depreciation table for seven years.
     */

    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Year     Depreciation        End-Of-Year-Value       Accumulated Depreciation");
            Console.WriteLine("----     ------------        -----------------       ------------------------");
            int count = 1;
            int endValue = 28000;
            int accu=0;
            do
            {

                Console.WriteLine($"{count,2} {4000,14} {endValue-=4000,18} {accu+=4000,24}");
                
                
                count++;
            } while (count <= 7);

        }
    }
}
