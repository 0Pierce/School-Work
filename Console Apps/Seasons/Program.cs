using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Seasons
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter a season or else");
            string season = Console.ReadLine();

            switch (season.ToLower())
            {

                case "summer":
                    Console.WriteLine("During summer you should wear a t-shirt");
                    break;

                case "fall":
                    Console.WriteLine(" During fall you should wear an overcoat.");
                    break;

                case "winter":
                    Console.WriteLine(" During winter you should wear a thermal coat.");
                    break;

                case "spring":
                    Console.WriteLine("During spring you should wear a jacket.");
                    break;

                default:
                    Console.WriteLine("I dont know");
                    break;



            }



        }
    }
}
