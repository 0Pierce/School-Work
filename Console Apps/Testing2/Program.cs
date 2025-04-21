using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/* Write a program that prompts the user for a number (that may be a fraction). 
 * The program reads in the input and print the following: the input as a double,
 * the input as an int and finally the input as a char
 * if the input is 6.79 then the output will be 65.79, 65, and A
 */



namespace Testing2
{

    class Program
    {
        static void Main(string[] args)
        {


            Console.WriteLine("Enter a number");
            /*INPUT*/
            double input = double.Parse(Console.ReadLine());

            /*Processing (Math, converstions etc)*/
            int input1 = (int)input;
            char input2 = (char)input;

            /*OUTPUT*/
            Console.WriteLine($"{input} , {input1} , {input2} ");

            Console.WriteLine(input +" " + input1 + " " + input2 );
          




        }
    }
}
