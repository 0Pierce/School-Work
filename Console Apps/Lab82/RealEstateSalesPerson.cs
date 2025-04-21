using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab82
{
    internal class RealEstateSalesPerson : Salesperson, ISellable
    {

        //Fields
        public double valueSold ;
        public double tCommi ;
        private double commissionR;





        //Properties
        public double value {

            get
            {
                return valueSold;
            }

            set
            {
                valueSold = value;
            }
        
        
        }

        public double commission
        {
            get
            {
                return tCommi;
            }
            set
            {
                tCommi = value;
            }
        }

        public RealEstateSalesPerson(string firstName, string lastName, double commissionR) : base(firstName, lastName)
        {
            valueSold = 0;
            tCommi = 0;
            this.commissionR = commissionR;
        }



        public void SalesSpeech()
        {
            Console.WriteLine("I will sell you a really cool house, trust me");
            
        }


        public void MakeSale(int hValue)
        {
            valueSold += hValue;
            tCommi += (hValue * commissionR);
            
        }



    }
}
