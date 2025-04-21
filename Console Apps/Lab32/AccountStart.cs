using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab32
{
    internal class Accounttart
    {


        static void Main(string[] args)
        {
            List<Account> accounts = new List<Account>();
            Random rand = new Random();

            accounts.Add(Account.CreateAccount("Narendra", rand.Next(50, 500)));
            accounts.Add(Account.CreateAccount("Ilia", rand.Next(50, 500)));
            accounts.Add(Account.CreateAccount("Yin", rand.Next(50, 500)));
            accounts.Add(Account.CreateAccount("Arben", rand.Next(50, 500)));
            accounts.Add(Account.CreateAccount("Patrick", rand.Next(50, 500)));
            accounts.Add(Account.CreateAccount("Joanne", rand.Next(50, 500)));
            accounts.Add(Account.CreateAccount("Nicoleta", rand.Next(50, 500)));
            accounts.Add(Account.CreateAccount("Mohammed", rand.Next(50, 500)));
            accounts.Add(Account.CreateAccount("Hao", rand.Next(50, 500)));
            accounts.Add(Account.CreateAccount("Mayy", rand.Next(50, 500)));

            Console.WriteLine("\nAll accounts");
            foreach (Account x in accounts)
            {
                
                Console.WriteLine(x);
            }

            foreach (Account account in accounts)
            {
                account.Deposit(rand.Next(4, 8) * 10);
            }

            Console.WriteLine("\nAfter deposit ");
            foreach (Account account in accounts)
            {
                Console.WriteLine(account);
            }

            foreach (Account account in accounts)
            {
                account.Withdraw(rand.Next(2, 5) * 10);
                if (account.Balance > 300)
                    account.AddName("(Hacked)");
            }

            Console.WriteLine("\nAfter withdrawal");
            foreach (Account account in accounts)
            {
                Console.WriteLine(account);
            }




        }







    }
}
