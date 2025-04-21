using System;

/* a program that prompts the user for her first name, middle initial and last name.
The program will display the user name three times using the following three formats:
first name and last name
first name middle initial and last name
last name, first name and middle initial
*/

namespace Names
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter your first name");
            string firstName = Console.ReadLine();

            Console.WriteLine("Enter your middle name initial");
            string initial = Console.ReadLine();

            Console.WriteLine("Enter your last name");
            string lastName = Console.ReadLine();

            Console.WriteLine(firstName + " " +lastName);
            Console.WriteLine(firstName + " "+  initial + " " + lastName);
            Console.WriteLine(lastName + "," + firstName + " " + initial);
        }
    }
}
