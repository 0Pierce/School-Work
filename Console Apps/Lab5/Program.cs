using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab5
{
    class Program
    {


        //Take in value here
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to the conversion program");
            string ans;
            do
            {
                Menu();
                ans = Console.ReadLine();

                switch (ans.ToLower())
                {

                    case "a":
                        OptionA();
                        break;
                    case "b":
                        OptionB();
                        break;

                }








                if(ans.ToLower() != "a" & ans.ToLower() != "b" & ans.ToLower() != "x")
                {
                    Console.WriteLine("Invalid input, try again");
                }

            } while (ans.ToLower() != "x");

            Console.WriteLine("You have exited");
            
            

        }

        public static void Menu()
        {
            Console.WriteLine("");
            Console.WriteLine("=============MENU===============");
            Console.WriteLine("A - Convert Pounds to Kilograms");
            Console.WriteLine("B - Convert Miles to Kilometers");
            Console.WriteLine("X - Exit the aplication");
            Console.WriteLine("=============MENU===============");



        }

        public static void OptionA()
        {
            Console.WriteLine("OPTION A");
            Console.WriteLine("==========");
            for(int i = 200; i >=50; i -=5)
            {
              
                Console.WriteLine($"{i} pounds = {PoundsToKilo(i):f2}");


            }

            
           

        }

        //returns
        public static double PoundsToKilo(double pounds)
        {


                
                
                return pounds / 2.205;

        }

        public static void OptionB()
        {

            double km;

            Console.WriteLine("OPTION B");
            Console.WriteLine("==========");

            for (int i = 10; i <= 100; i += 10)
            {

               
                MilesToKm(i, out km);

                Console.WriteLine($"{i} miles = {km} Km");
                
            }

            

        }

        //uses out
        public static void MilesToKm(double Miles, out double km)
        {


            km = Miles * 1.609;
            

        }



    }

}
