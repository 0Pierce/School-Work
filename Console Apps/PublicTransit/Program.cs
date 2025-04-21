using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PublicTransit
{



    class Program
    {
        static void Main(string[] args)
        {

            Console.Write("What is your name? ");
            string name = Console.ReadLine();

            Console.Write("How much do you spend daily with public transit? ");
            int cost = int.Parse(Console.ReadLine());

            Console.WriteLine($"{name}'s monthly spending with public transit is ${cost * 20}");

        }
    }
}
