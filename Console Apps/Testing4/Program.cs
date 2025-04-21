using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Testing4
{
    class Program
    {

        public DateTime time { get; }

        
        static void Main(string[] args)
        {
            int[] nums = { 1, -2, -3, 5 };
            var posNums = from n in nums
                          orderby n descending
                          select n * 4 / 2;
            Console.Write("The values in nums: ");
            foreach (int i in posNums) Console.Write(i + " ");


        }
    }
}
