using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection.Metadata.Ecma335;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace Astronaut
{
    internal class Astronaut
    {

        private static int count = 0;
        private static int max = 5;

        public string name;
        public string nationality;

        public string Name
        {
            get;
           
        }

        public string Nationality
        {
            get;
            
        }

        private Astronaut(string name, string nationality)
        {
            this.Name = name;
            this.Nationality = nationality;
            count++;
        }

        public static Astronaut CreateAstronaut(string name, string nationality)
        {
            if(count < max)
            {
                Astronaut newAstronaut = new Astronaut(name, nationality);
                return newAstronaut;
            }
            else
            {
                return null;
            }
        }


        public override string ToString()
        {
            return $"Astronaut's Name: {Name} - Nationality: {Nationality}";
        }


    }
}
