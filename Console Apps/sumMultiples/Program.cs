using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sumMultiples
{
    class Program
    {
        static void Main(string[] args)
        {

            UInt32 num = 1000002;
            UInt64 sum = 0;
            while (num < 2000000)
            {
                sum += num;
                num += 3;

            }
            Console.WriteLine("Sum is {0}", sum);
        }
    }
}
