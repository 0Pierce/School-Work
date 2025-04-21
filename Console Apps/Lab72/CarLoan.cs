using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab72
{
    internal class CarLoan : GeneralLoan
    {

        private const int EARLIEST_YEAR = 2006;
        private const int LOWEST_INVALID_NUM = 1000;

        private int year;

        public string Make { get; set; }
        public int Year {
            set
            {
                if (value < EARLIEST_YEAR)
                {
                    year = value;
                    loanAmount = 0;
                }
                else
                    year = value;

            }

            get
            {
                return year;
            }
        
        
        }


        public CarLoan(int num, string name, double amount, int year, string make) : base(num, name, amount)
        {
            Year = year;
            Make = make;
        }


        


        public new int LoanNumber
        {
            get
            {
                return base.LoanNumber;
            }

            set
            {
                if(value < LOWEST_INVALID_NUM)
                    base.LoanNumber = value;
                else
                    base.LoanNumber = value % LOWEST_INVALID_NUM;
            }
        }

    }
}
