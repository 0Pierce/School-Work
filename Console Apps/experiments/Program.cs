using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*Four experiments are performed, each consisting of six test results. The results for each experiment are given
below. Write a program using a nested loop to compute and display the average of the test results for each
experiment.
 */



namespace experiments
{
    class Program
    {
        static void Main(string[] args)
        {
            for(int i = 1; i <=4; i++)
            {
                double result=0;
                for(int c = 0; c < 6; c++)
                {
                    Console.WriteLine("Enter the result");
                    result += double.Parse(Console.ReadLine());


                }

                Console.WriteLine($"{1} experiment results average:{result / 6}");

            }

        }
    }
}
