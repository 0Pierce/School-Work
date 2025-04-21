namespace FileDemo
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");

            String filename = "path";

            writeFile();
            readFile(filename);

          

         
        }

        public static void writeFile()
        {
            string filename = "My-file.txt";

            StreamWriter writer = new StreamWriter(filename);


            writer.Write("Uga");
            writer.Write("buga");

            writer.Close();
        }

        public static void readFile(String filename)
        {
            StreamReader reader = new StreamReader(filename);

            string line = reader.ReadLine();

            while (line != null)
            {
                Console.WriteLine(line);
                line = reader.ReadLine();

            }

            reader.Close();
        }
    }
}