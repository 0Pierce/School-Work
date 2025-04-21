using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TwoIncrement
{
    class Program
    {
        static void Main(string[] args)
        {
            int count=2;
            do
            {
                Console.Write($"{count} ");
                count += 2;

            } while(count <=10);

            Console.WriteLine();
            int num =2;
            for (int i = 0; i < 5; i+=2)
            {
                Console.Write($"{num} ");
                num += 2;
            }

        }
    }
}
