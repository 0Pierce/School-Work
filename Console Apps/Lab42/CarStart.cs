namespace Lab42
{
    internal class CarStart
    {
        static void Main(string[] args)
        {
            

            Car car1 = new Car("Mazda", 10);
            Car car2 = new Car("Honda", 4);
            Console.WriteLine();
            Console.WriteLine("Before increment: ");
            Console.WriteLine($"The model is: {car1.Model} | The KmPerLitre is: {car1.KmPerL}");
            Console.WriteLine($"The model is: {car2.Model} | The KmPerLitre is: {car2.KmPerL}");
            Console.WriteLine();
            car1++;
            car2++;
            Console.WriteLine("After increment: ");
            Console.WriteLine($"The model is: {car1.Model} | The KmPerLitre is: {car1.KmPerL}");
            Console.WriteLine($"The model is: {car2.Model} | The KmPerLitre is: {car2.KmPerL}");

        }
    }
}