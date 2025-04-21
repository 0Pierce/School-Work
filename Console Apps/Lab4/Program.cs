using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab4
{
    class Program
    {
        static void Main(string[] args)
        {
            
            

            Console.WriteLine($"The Commissioned earned is: {commission(sales()):C}");
        }


        public static int sales()
        {
            Console.WriteLine("Enter the dollar value of your sales");
            int sales = int.Parse(Console.ReadLine());



            return sales;
        }


        public static int commission(int made)
        {

            if(made <= 999)
            {
                return (int)(made * 0.03);
            }
            else if(made >=1000 && made <= 2999)
            {
                return (int)(made * 0.04);
            }
            else if(made >= 3000)
            {
                return (int)(made * 0.05);
            }
            else
            {
                return 0;
            }
            
            
        }




    }
}
