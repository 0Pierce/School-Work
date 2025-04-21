using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*Write a program that prompts the user for two
integers. The program will display the result of
summing and finding the difference. (If the user enters
8 and 3, the display should be 8 + 3 = 11 and 8 – 3 = 5).*/



namespace TwoIntegers
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter two integers");
            int num1 = int.Parse(Console.ReadLine());
            int num2 = int.Parse(Console.ReadLine());

            int sum = num1 + num2;
            int difference = num1 - num2;

            Console.WriteLine("The sum is: "+ sum + " The difference is: "+ difference);

        }
    }
}
