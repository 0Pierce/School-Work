using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace Lab62
{
    internal class program
    {
        static List<Atom> elements = new List<Atom>();
        public static void Main(string[] args)
        {

            enterElements();
            printElements();

            serializeSaveOne();
            printSaveOne();

            serializeSave();
            printSave();

        }



        public static void enterElements()
        {
            Console.WriteLine("===Elements Added===");
            elements.Add(Atom.Parse("Hydrogen 1 0 1.0079 "));
            elements.Add(Atom.Parse("Helium 2 2 4.0026 He")); ;
            elements.Add(Atom.Parse("Lithium 3 4 6.941 Li")); ;
            elements.Add(Atom.Parse("Beryllium 4 5 9.0122 Be"));
            elements.Add(Atom.Parse("Boron 5 6 10.811 B"));
            elements.Add(Atom.Parse("Carbon 6 6 12.0107 C"));
            elements.Add(Atom.Parse("Nitrogen 7 7 14.0067 N"));
            elements.Add(Atom.Parse("Oxygen 8 8 15.9994 O"));
            elements.Add(Atom.Parse("Fluorine 9 10 18.9984 F"));
            elements.Add(Atom.Parse("Neon 10 10 20.1797 Ne"));
            elements.Add(Atom.Parse("Sodium 11 12 22.9897 Na"));
            elements.Add(Atom.Parse("Magnesium 12 12 24.305 Mg"));
            elements.Add(Atom.Parse("Aluminum 13 14 26.9815 Al"));
            elements.Add(Atom.Parse("Silicon 14 14 28.0855 Si"));

        }

        public static void printElements()
        {
            Console.WriteLine();
            Console.WriteLine("===Added Following Elements===");
            
            foreach (Atom element in elements) 
            {
                Console.WriteLine(element.ToString());
            }
        }

        //string serializedCourse = JsonSerializer.Serialize(course);

        public static void serializeSaveOne()
        {
            Console.WriteLine();
            Console.WriteLine("===Serialized One===");
            string serializedAtom = JsonSerializer.Serialize(elements[0]);
            //Console.WriteLine(serializedAtom);
            StreamWriter writer = new StreamWriter("SavedAtoms.json");

            writer.Write(serializedAtom);

            writer.Close();
        }


        public static void printSaveOne()
        {
            Console.WriteLine();
            Console.WriteLine("File contains:");
            StreamReader reader = new StreamReader("SavedAtoms.json");
            Console.WriteLine(reader.ReadLine());
            reader.Close();

        }

        public static void serializeSave()
        {
            Console.WriteLine();
            Console.WriteLine("===Serialized All===");
            string serializedAtom = JsonSerializer.Serialize(elements);
            
            StreamWriter writer = new StreamWriter("SavedAtoms.json");

            writer.Write(serializedAtom);

            writer.Close();
        }


        public static void printSave()
        {
            Console.WriteLine();
            Console.WriteLine("File contains:");
            StreamReader reader = new StreamReader("SavedAtoms.json");
            Console.WriteLine(reader.ReadLine());
            reader.Close();
        }






    }
}
