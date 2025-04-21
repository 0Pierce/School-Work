namespace Lab72
{
    internal class DemoCarLoan
    {
        static void Main(string[] args)
        {
            

            GeneralLoan loan= new GeneralLoan();
            CarLoan cLoan = new CarLoan();

            loan.LoanNumber = 2239;
            loan.LastName = "Mitchell";
            loan.LoanAmount = 7000.00;

            cLoan.LoanNumber = 3358;
            cLoan.LastName = "Jansen";
            cLoan.LoanAmount = 20000.00;
            cLoan.Make = "Ford";
            cLoan.Year = 2012;

            Console.WriteLine("Loan #{0} for {1} is for {2} ", loan.LoanNumber, loan.LastName, loan.LoanAmount.ToString("C2"));
            Console.WriteLine("Loan #{0} for {1} is for {2}", cLoan.LoanNumber, cLoan.LastName, cLoan.LoanAmount.ToString("C2"));
            Console.WriteLine(" Loan #{0} is for a {1} {2}", cLoan.LoanNumber, cLoan.Year, cLoan.Make);
        }
    }
}