using System;

namespace CandyCalc
{
    class Program
    {
        static void Main(string[] args)
        {

            

            Console.WriteLine("Enter the price of the candy");
            int price = int.Parse(Console.ReadLine());

            Console.WriteLine("Enter your available balance");
            int bal = int.Parse(Console.ReadLine());

            int candyAmount = bal / price;
            //string output = string.Format("{0:N2}%", candyAmount);
            //Console.WriteLine("You can buy:" + string.Format("{0:N}", candyAmount));
            Console.WriteLine("You can buy:" + candyAmount);
        }
    }
}
