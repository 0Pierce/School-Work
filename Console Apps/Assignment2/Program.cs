using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace Assignment2
{
    class Program
    {
        static void Main(string[] args)
        {

            //All of the methods can be solved using an arrayList, however, I wanted to show I could pass arguements as it was specifically asked in the 2nd method.

            int input;
            do
            {

                DisplayMenu();
                input = int.Parse(Console.ReadLine());
                if(input != 3 && input != 4 && input != 5)
                {
                    Console.WriteLine("Invalid Input");
                }

                switch (input)
                {
                    case 3:
                        Console.WriteLine("The sum is: "+CalcSum());
                        break;
                    case 4:
                        Console.WriteLine("How many numbers do you want to input?");
                        int amount = int.Parse(Console.ReadLine());
                        Console.WriteLine("The sum is: " + CalcSumSquare(amount));

                        break;
                    case 5:
                        Console.WriteLine("The sum is: " + CalcSumCubes());
                        break;
                }


            } while (input != 0);
            Console.WriteLine("Thank you for using my sum calculator");

        }

        public static void DisplayMenu()
        {
            Console.WriteLine("");
            Console.WriteLine("Calculation Menu");
            Console.WriteLine("3) Calculate Sum");
            Console.WriteLine("4) Calculate Sum of Squares");
            Console.WriteLine("5) Calculate Sum of Cubes");
            Console.WriteLine("0) To exit");

        }


        //3
        //Does not have arguement as it uses a numList thus it does not need to know the amount of values entered
        //making it dynamic
        public static int CalcSum()
        {

            Console.WriteLine("CALCULATE SUM");
            int tempint;

            Console.WriteLine("Enter numbers, write 0 if you wish to exit");

            ArrayList numList = new ArrayList();

            do
            {
                //Adding a extra prompt for clarity
                Console.WriteLine("Enter a numbar");
                tempint = int.Parse(Console.ReadLine());
                numList.Add(tempint);
                
               

            } while (tempint != 0);

            //Console.WriteLine("The sum is: " + numList.Cast<int>().Sum());
            return numList.Cast<int>().Sum();
            
        }

        //4
        //Propmts the user in the main for the amount of numbers they want to square
        public static int CalcSumSquare(int count)
        {
            Console.WriteLine("CALCULATE SQUARE SUM");
            Console.WriteLine("Enter the numbers below");
            int tempint;
            ArrayList numList = new ArrayList();
            
            for (int i = 0; i < count; i++)
            {
                //Adding a extra prompt for clarity
                Console.WriteLine("Enter a numbar");
                tempint = int.Parse(Console.ReadLine());
                numList.Add(tempint * tempint);

            }

            return numList.Cast<int>().Sum();


        }


        //Pretty much the exact same as question #1. There is no specified number of times it will run
        public static int CalcSumCubes()
        {
            Console.WriteLine("CALCULATE CUBE SUM");
            Console.WriteLine("Enter the numbers below & enter 0 to exit");
            int tempint;
            ArrayList numList = new ArrayList();

            do
            {
                //Adding a extra prompt for clarity
                Console.WriteLine("Enter a numbar");
                tempint = int.Parse(Console.ReadLine());
                numList.Add(tempint * tempint * tempint);

            } while (tempint != 0);

            return numList.Cast<int>().Sum();

        }

    }
}
