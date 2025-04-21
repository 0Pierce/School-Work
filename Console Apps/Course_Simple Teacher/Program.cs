using System.Text.Json;

namespace CourseSimple_SEC406
{
    internal class Program
    {
        static void Main(string[] args)
        {
            List<Course> myCourses = new List<Course>();

            myCourses.Add(new Course("COMP123",
                "Advanced C# Programming",
                "Programming II",
                "COMP100",
                2));

            myCourses.Add(new Course("COMP100",
                "Starting on C#",
                "Programming I",
                "",
                1));

            myCourses.Add(new Course("COMP229",
                "All about Web Programming",
                "Web Application Development",
                "COMP123",
                3));

            myCourses.Add(new Course("COMP303",
                "Not sure",
                "Programming III",
                "COMP123",
                3));

            myCourses.Add(new Course("COMP404",
                "Not found",
                "Programming IV",
                "COMP303",
                4));

            SaveCourses("ListOfCourses.json", myCourses);

            List<Course> mySavedCourses = ReadCourses("ListOfCourses.json");

            foreach(Course course in mySavedCourses)
                Console.WriteLine(course.Name);
        }

        public static void SaveCourses(string fileName,
            List<Course> listOfCourses)
        {
            StreamWriter writer = new StreamWriter(fileName);

            foreach (Course course in listOfCourses)
            {
                string serializedCourse = JsonSerializer.Serialize(course);
                
                writer.WriteLine(serializedCourse);
            }

            writer.Close();

        }

        public static List<Course> ReadCourses(string fileName)
        {
            List<Course> list = new List<Course>();

            StreamReader reader = new StreamReader(fileName);
            
            string line = reader.ReadLine();

            while (line != null)
            {
                Course course = JsonSerializer.Deserialize<Course>(line);

                list.Add(course);

                line = reader.ReadLine();
            }

            reader.Close();

            return list;
        }
    }
}