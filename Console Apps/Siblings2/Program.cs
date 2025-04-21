using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Siblings2
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("How many siblings do you have?");
            int siblings = int.Parse(Console.ReadLine());

            Console.WriteLine("I have: " + siblings + 1 + " siblings");

        }
    }
}
