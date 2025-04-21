using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Days
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("Enter the week day");
            String day = Console.ReadLine();
            char jeff;


            int bob = int.Parse(jeff.ToString());

            Console.WriteLine($"Answer is {bob}");

            switch (day.ToLower())
            {

                case "saturday":
                   
                case "wednesday":
                    Console.WriteLine("Home day");
                    break;

                case "monday":
                case "tuesday":
                case "thursday":
                case "friday":
                case "sunday":
                    Console.WriteLine("Work day");
                    break;





            }




        }
    }
}
