using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Letters
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("Enter a letter");
            string letter = Console.ReadLine();


            switch (letter.ToLower())
            {

                case "a":
                    Console.WriteLine("Apple");
                    break;

                case "b":
                    Console.WriteLine("Baby or Candy");
                    break;

                case "c":
                    Console.WriteLine("Baby or Candy");
                    break;

                default:
                    Console.WriteLine("Sorry I don’t know that letter.");
                    break;










            }


        }
    }
}
