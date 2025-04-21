using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab72
{


    //Bit of a weird lab, wasnt sure if I should keep the previous demo classes or not
    //So Just in case I kept them. Project wont run since there are multiple entry points

    internal class DemoCarLoan3
    {
        static void Main(string[] args)
        {


            GeneralLoan loan = new GeneralLoan(333, "Hanson", 7000.00);
            CarLoan cLoan = new CarLoan(444, "Carlisle", 30000.00, 2011, "BMW");

            

            Console.WriteLine("Loan #{0} for {1} is for {2} ", loan.LoanNumber, loan.LastName, loan.LoanAmount.ToString("C2"));
            Console.WriteLine("Loan #{0} for {1} is for {2}", cLoan.LoanNumber, cLoan.LastName, cLoan.LoanAmount.ToString("C2"));
            Console.WriteLine(" Loan #{0} is for a {1} {2}", cLoan.LoanNumber, cLoan.Year, cLoan.Make);
        }



    }
}
