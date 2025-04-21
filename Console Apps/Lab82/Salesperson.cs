using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace Lab82
{
    abstract internal class Salesperson
    {

        public string fName;
        public string lName;


        public Salesperson(string fName, string lName)
        {
            this.fName = fName;
            this.lName = lName;

        }

        public void printName()
        {
            Console.WriteLine($"{fName} - {lName}");
            
        }
    }
}
