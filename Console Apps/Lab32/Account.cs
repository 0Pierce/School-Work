using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Text;
using System.Threading.Tasks;

namespace Lab32
{
    internal class Account
    {

        private const int TRANSIT_NUMBER = 314;
        
        private static int nextAccNum = 10000;
        readonly string number;
        private double balance;
        private List<string> names = new List<string>();

        public double Balance
        {
            get
            {
                return balance;

            }
            private set
            {
                
                balance = value;
            }
        }

        public List<string> Names
        {
            get
            {
                
                return names;
            }
            private set
            {
                
                names = value;
                

            }
        }


        //Constructor
        public Account(string name, string number, double balance)
        {

            this.number = number;
            this.Balance= balance;
            
            Names.Add(name);
            
            
        
        }

        public static Account CreateAccount(string name, double balance)
        {

            string accNum = ($"AC {TRANSIT_NUMBER}-{nextAccNum}");
            nextAccNum++;
            
            Account account = new Account(name, accNum, balance);

            return account;
        }


        public void AddName(string name)
        {
            Names.Add(name);

        }

        public void Deposit(double amount)
        {
            Balance = Balance+amount;
        }

        public void Withdraw(double amount)
        {
            Balance = Balance -amount;
        }

        public override string ToString()
        {
           
          
            return $"[{number}] {string.Join(",", Names)} {Balance.ToString("C")}";
           
            
        }




    }
}
