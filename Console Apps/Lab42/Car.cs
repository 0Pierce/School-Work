using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace Lab42
{
    internal class Car
    {

        


        public string Model
        { get; set; }


        public double KmPerL
        { get; set; }



        public Car(string model, double kmPerL) {
        
        
            this.KmPerL = kmPerL;
            this.Model = model;
            
        
        }
        

        public Car(string model)
        {
            this.Model = model;
            KmPerL = 15;
        }

        public static Car operator ++(Car car)
        {
            car.KmPerL++;
            return car;
        }

        
















    }
}
