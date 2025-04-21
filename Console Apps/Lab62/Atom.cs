using System.Runtime.CompilerServices;
using System.Security.Cryptography.X509Certificates;

namespace Lab62
{
    internal class Atom
    {


        public string Name { get; set; }
        public string Symbol { get; set; }
        public int Proton { get; set; }
        public int Neutron { get; set; }
        public double Weight { get; set; }

      


        public Atom()
        {
            
        }

        public Atom(string name, int proton, int neutron, double weight, string symbol)
        {
            Name = name;
            Symbol = symbol;
            Proton = proton;
            Neutron = neutron;
            Weight = weight;
            

        }
        

        public static Atom Parse(string line)
        {
            string[] Atom = new string[5];
            try
            {
                Atom = line.Split(null);
                
                //Also in a real world sense this will help determine the problem immedietly IE: Not enough elements in array or empty characters
                //Makes sure the lenght is 5 - Very simple and low level check which isnt sufficient on its own
                if(Atom.Length < 5 )
                {
                    throw new Exception("Invalid Entry: Missing variable");
                
                }

                //Additional check makes sure there are no blank spaces
                for(int i = 0; i < Atom.Length; i++)
                {
                    if (String.IsNullOrWhiteSpace(Atom[i]))
                    {
                        throw new Exception("Invalid Entry: Blank detected ");
                    }
                }

            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message + "Error");
            }

            
            
            Atom atom = new Atom(Atom[0], int.Parse(Atom[1]), int.Parse(Atom[2]), double.Parse(Atom[3]), Atom[4]);
            return atom;
        }

        public override string ToString()
        {
            
            return $"Name: {Name} Protons: {Proton} Neutrons: {Neutron} Weight: {Weight} Symbol: {Symbol}";
        }


        




    }
}