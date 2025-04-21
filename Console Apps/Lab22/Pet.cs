using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharpProgr
{
    internal class Pet
    {
        string Name;
        public string Owner;
        int Age;
        string Desc;
        private bool IsHTrained;

        public Pet(string name, int age, string desc)
        {
            Name = name;
            Age = age;
            Desc = desc;
            Owner = "No one";
            IsHTrained = false;

        }

      

        public override string ToString()
        {
            return $"Name: {Name}, Age {Age}, Description: {Desc}, Owner: {Owner}, IsHouseTrained: {IsHTrained}";
        }

        public void SetOwner(string owner)
        {

            Owner = owner;
            

        }

        public void Train()
        {

            IsHTrained = true;

        }


    }
}
