using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*Last year at the CNE, the Halls family bought 100 ride tokens. 
 * If the Polar Express, the Ferris Wheel, the HighDrop and the WaterFall costs 15, 10, 12 and 9 tokens respectively per person, 
 * how many tickets will remain at the end of the day?*/


namespace Testing3
{
    class Program
    {
        static void Main(string[] args)
        {

            int count = 0;

            Console.WriteLine("Enter your family size: ");
            int famAmount = int.Parse(Console.ReadLine());

            Console.WriteLine("Enter the amount of tokens you have: ");
            int tokens = int.Parse(Console.ReadLine());

            do
            {
                //Hardcoded token prices for each ride
                int polar = 15, wheel = 10, highDrop = 12, waterfall = 9;





                //User inputs
               

                Console.WriteLine("PolarExpress, FerrisWheel, HighDrop, WaterFall");
                Console.WriteLine("Which ride do you want to go on: ");
                string ride = Console.ReadLine();

                Console.WriteLine("How many times do you want to go on this ride?:");
                int amount = int.Parse(Console.ReadLine());

                if (amount > 0)
                {
                    if (ride.Equals("PolarExpress", StringComparison.InvariantCultureIgnoreCase))
                    {
                        tokens = tokens - famAmount*(polar * amount);


                    }

                    if (ride.Equals("FerrisWheel", StringComparison.InvariantCultureIgnoreCase))
                    {
                        tokens = tokens - famAmount *( wheel * amount);
                    }

                    if (ride.Equals("HighDrop", StringComparison.InvariantCultureIgnoreCase))
                    {
                        tokens = tokens - famAmount * (highDrop * amount);
                    }

                    if (ride.Equals("WaterFall", StringComparison.InvariantCultureIgnoreCase))
                    {
                        tokens = tokens - famAmount * (waterfall * amount);
                    }

                    if(tokens > 0)
                    {
                        Console.WriteLine("You will have:" + tokens + " tokens remaining");
                       
                    }
                    else
                    {
                        Console.WriteLine("You do not have enough tokens for this ride");
                    }

                    Console.WriteLine("Do you want to go again? enter 1 if yes, 0 if no");
                    count = int.Parse(Console.ReadLine());


                }
                else
                {
                    Console.WriteLine("Value must be or greater than 1");
                    Console.ReadLine();
                    Environment.Exit(1);
                }




            } while(count == 1);

            Console.WriteLine("Thank you for your visit, goodbye!");

           


        }
    }
}
