using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sum
{
    class Program
    {
        static void Main(string[] args)
        {
            int inp;
            int sum=0;
            int count=0;
            do
            {
                Console.WriteLine("Enter a number");
                inp = int.Parse(Console.ReadLine());
                sum = sum+inp;

                count++;

            } while (sum <100);

            Console.WriteLine($"The sum is {sum} and the average is {sum / count}");
            

        }
    }
}
