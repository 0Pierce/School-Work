using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

//Pierce Pokorny Assingment 1

/*Adult ticket cost $3.75 and child ticket cost $2.25. Write a program to prompt the user for the
amount of adult and child ticket that she needs. The program will display a user-friendly
message of the number of tickets brought as well as the total cost. (Use the "C" format-string
for currency). */


namespace Assignment1
{
    class Program
    {
        static void Main(string[] args)
        {
            //Prompt
            Console.WriteLine("Enter the amount of adults, then the amount of children");

            //Input
            //Inputs the amount of kids and adults

            

            int adults = int.Parse(Console.ReadLine());
            int kids = int.Parse(Console.ReadLine());


            


            double dCost, kCost;
            //Processing
            //Calculates the final cost and the cost for adults and kids
            double cost = (dCost = adults * 3.75) + (kCost = kids * 2.25);

            //Output
            //Outputs the amount of tickets needed for adults and kids and their total.
            //Also as a bonus displays how much adult and kids tickets cost seperately.
            Console.WriteLine($"You have bought {adults} adult tickets and {kids} child tickets | In total {adults+kids} tickets were bought");
            Console.WriteLine($"The cost for the adults is: {dCost.ToString("C")} and the cost for the kids is {kCost.ToString("C")} | The final cost is {cost.ToString("C")}");


        }
    }
}
