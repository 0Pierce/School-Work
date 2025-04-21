using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AccountsApp
{
    internal class SavingsAcc : Account
    {
        private const double TRANS_FEE = 6.25;

        public double Interest { get; set; }


        public SavingsAcc(int number, string name, double balance, double interest) : base (number, name, balance)
        {
            Interest = interest;
        }

        public override void Deposit(double amount)
        {
            Balance += amount - TRANS_FEE;
        }

        public override void Withdraw(double amount)
        {
            if(Balance - amount - TRANS_FEE> 0)
            {
                Balance -= amount + TRANS_FEE;
            }
        }

    }
}
