using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection.Metadata.Ecma335;
using System.Text;
using System.Threading.Tasks;
using Excel = Microsoft.Office.Interop.Excel;

namespace ClassExample
{
    internal class Student
    {
        private int id;
        private string name;


        //public Student()
        //{


        //}
        public Student(int id, string name)
        {
            this.id = id;
            this.name = name;
            Console.WriteLine($"{id} {name}");
        }

        //public int getId() { return id; }
        //public void setId(int id) { this.id = id; }
        public int ID { set; get; }
    }
}
