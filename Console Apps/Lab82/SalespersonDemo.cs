namespace Lab82
{
    internal class SalespersonDemo
    {
        static void Main(string[] args)
        {
            
            RealEstateSalesPerson agent = new RealEstateSalesPerson("Shrek", "Swampson", 0.03);
            
            GirlScout scout = new GirlScout("Shrekana", "Swampson");

            agent.SalesSpeech();
            agent.MakeSale(50000);
            agent.MakeSale(30000);
            agent.MakeSale(12000);
            Console.WriteLine("Total value sold: " + agent.valueSold.ToString("C"));
            Console.WriteLine("Total commission earned: " + agent.tCommi.ToString("C"));

            scout.SalesSpeech();
            scout.MakeSale(90);
            scout.MakeSale(10);
            scout.MakeSale(20);
            
            Console.WriteLine("Total boxes sold: " + scout.boxesSold);
        }
    }
}