using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace namesA
{
    class Program
    {
        static void Main(string[] args)
        {

            string[] names = "Dean Bart Luke Olaf Tess Sara Vida Sean Rita Hana Arya CurtEden Fred Gina West Jack Kate Zuri Dave Toni Ruth Vera Brad Theo Xena Mark Neal Nick".Split();
            string[] temp = names;

            Array.Reverse(temp);
            foreach (string i in temp)
            {
                Console.Write(i + " ");
            }

            Console.WriteLine(" ");
            Console.WriteLine(" ");
            Array.Sort(temp);
            foreach (string i in temp)
            {
                Console.Write(i + " ");
            }


            Array.BinarySearch(temp, "Nick");
            



        }
    }
}
