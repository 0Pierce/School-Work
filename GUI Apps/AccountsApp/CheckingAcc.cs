using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AccountsApp
{
    internal class CheckingAcc : Account
    {
        private const double TRANS_FEE = 5.00;

        

        public double Limit { get; set; }

        public CheckingAcc(int number, string name, double balance, double limit) : base(number, name, balance)
        {
            limit = limit;
        }

        public override void Deposit(double amount)
        {
            Balance += amount - TRANS_FEE;
        }

        public override void Withdraw(double amount)
        {
            if(amount + TRANS_FEE< Limit)
            {
                Balance -= amount + TRANS_FEE;
            }
        }

    }
}
