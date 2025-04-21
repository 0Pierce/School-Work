using System;
using System.Collections.Generic;
using System.Text;

namespace Testing
{
    class Class1
    {

        public static void main(String[] args)
        {
			//Input
			Console.WriteLine("Enter 3 numbers");
			Console.WriteLine("Class1");

			int num1 = int.Parse(Console.ReadLine());
			int num2 = int.Parse(Console.ReadLine());
			int num3 = int.Parse(Console.ReadLine());

			//Processing
			int sum = num1 + num2 + num3;
			int final = sum / 3;

			//Output
			Console.WriteLine("Your average is " + final);
		}
    }
}
