using Excel = Microsoft.Office.Interop.Excel;
namespace ClassExample

{
    internal class Program
    {
        static void Main(string[] args)
        {
            Student s1 = new Student(1, "jeff");

            string path = Environment.CurrentDirectory;

            Excel.Application exApp = new Excel.Application();
            Excel.Workbook exW = exApp.Workbooks.Open(path + @"\test.ex");
            Excel.Worksheet exS = exW.Worksheets[1];
            Excel.Range exR = exS.UsedRange;
            int rowCount = exR.Rows.Count;
            int columnCount = exR.Columns.Count;

            for (int i = 1; i<=rowCount;i++)
            {
                for(int j = 1; j<=columnCount;j++)
                {
                    Console.Write(exR.Cells[i,j].ToString());
                }
            }



            List<int> list=new List

        }
    }
}