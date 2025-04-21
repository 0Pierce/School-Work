
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpProgr
{
    internal class PetStart
    {

        static void Main(string[] args)
        {

           

            Pet p1 = new Pet("Jeff", 5, "Wolf");
            Pet p2 = new Pet("Bob", 3, "Hound");
            Pet p3 = new Pet("Dave", 8, "Shepard");
            Pet p4 = new Pet("Steve", 12, "Retriever");

            List<Pet> pets = new List<Pet>();

            pets.Add(p1);
            pets.Add(p2);
            pets.Add(p3);
            pets.Add(p4);

            pets[0].Train();
            pets[1].SetOwner("Geof");
            pets[2].Train();
            pets[2].SetOwner("Stafan");
            pets[3].SetOwner("Stafan");


            foreach (Pet p in pets)
            {
                Console.WriteLine(p.ToString());
            }

            Console.WriteLine("Enter a Owners Name: ");
            string owner = Console.ReadLine();

            foreach (Pet pe in pets)
            {
                if (pe.Owner == owner)
                {
                    Console.WriteLine(pe.ToString());

                }
            }

        }
    }
}
