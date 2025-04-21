using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab82
{
    internal class GirlScout : Salesperson, ISellable
    {

        public int boxesSold;

        public GirlScout(string firstName, string lastName)
       : base(firstName, lastName)
        {
            
        }


        public int boxes {

            get
            {
                return boxesSold;
            }

            set { 
            
                boxesSold = value;
            
            } 
        
        
        }

        public void SalesSpeech()
        {
            Console.WriteLine();
            Console.WriteLine("buy my cookies or else.");
            
        }


        public void MakeSale(int boxes)
        {
            boxesSold += boxes;
            
           
        }


    }
}
