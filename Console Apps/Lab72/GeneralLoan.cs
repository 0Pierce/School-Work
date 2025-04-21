using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab72
{
    internal class GeneralLoan
    {

        public const double MINIMUM_LOAN = 5000;

        public int LoanNumber { get; set; }
        public string LastName { get; set; }


        protected double loanAmount;
        public double LoanAmount {
            set
            {
                if (value < MINIMUM_LOAN)
                    loanAmount = MINIMUM_LOAN;
                else
                    loanAmount = value;
            }

            get
            {
                return loanAmount;
            }
        
        }

        public GeneralLoan(int num, string name, double amount)
        {
            LoanNumber= num;
            LastName= name;
            LoanAmount= amount;

        }

        

    }
}
