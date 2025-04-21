using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AccountsApp
{
    internal abstract class Account
    {

        


        public int Number { get; set; }
        public double Balance { get; set; }
        public string Name { get; set; }




        public Account(int number, string name, double balance)
        {
            Number= number;
            Name= name;
            Balance = balance;
        }

        public abstract void Deposit(double amount);

        public abstract void Withdraw(double amount);
        

    }
}
