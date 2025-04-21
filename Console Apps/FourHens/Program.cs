using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FourHens
{
    class Program
    {
        static void Main(string[] args)
        {
            int hen1, hen2, hen3, hen4;

            Console.WriteLine("Enter the amount of eggs per hen starting at 1");
            hen1 = int.Parse(Console.ReadLine());
            hen2 = int.Parse(Console.ReadLine());
            hen3 = int.Parse(Console.ReadLine());
            hen4 = int.Parse(Console.ReadLine());

            int num1 = 0, num2 = 3;
            num1 = num2++;


            



            int henSum = hen1 + hen2 + hen3 + hen4;
            int dozens = henSum / 12;
            Console.WriteLine("Eggs:" + henSum + " Dozens:"+ dozens + " Remainder:"+ henSum%12);
            Console.WriteLine(num1);




        }
    }
}
