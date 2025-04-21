using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab72
{
    internal class DemoCarLoan2
    {

        static void Main(string[] args)
        {


            GeneralLoan loan = new GeneralLoan();
            CarLoan cLoan = new CarLoan();

            loan.LoanNumber = 2239;
            loan.LastName = "Mitchell";
            loan.LoanAmount = 2000.00;

            cLoan.LoanNumber = 3358;
            cLoan.LastName = "Jansen";
            cLoan.LoanAmount = 4000.00;
            cLoan.Make = "Ford";
            cLoan.Year = 2001;

            Console.WriteLine("Loan #{0} for {1} is for {2} ", loan.LoanNumber, loan.LastName, loan.LoanAmount.ToString("C2"));
            Console.WriteLine("Loan #{0} for {1} is for {2}", cLoan.LoanNumber, cLoan.LastName, cLoan.LoanAmount.ToString("C2"));
            Console.WriteLine(" Loan #{0} is for a {1} {2}", cLoan.LoanNumber, cLoan.Year, cLoan.Make);
        }
    }
}
