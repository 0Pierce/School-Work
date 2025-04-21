using System;

/*Write a program that prompts the user for the number
of siblings his has. The program should display a
message, “I also have 4 siblings” (assuming that the
user enters 4)*/


namespace Siblings
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter the amount of siblings you have");
            string siblings = Console.ReadLine();


            Console.WriteLine("I also have " + siblings + " siblings");

                

            }
                
           
    }
}
