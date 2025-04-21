using System;

namespace Lab52
{
    internal class Program
    {
        static void Main(string[] args)
        {

            DivisionNoHandling();

            DivisionWithExceptionHandling();

            DivisionWithExceptionHandlingMoreInfo();

            try
            {
                DivisionWithExceptionHandlingThrow();
            }
            catch (Exception e)
            {
                Console.WriteLine("Caught an exception: {0}", e.Message);
            }


        }

        static int Division(int top, int bottom) => top / bottom;

        
        static void DivisionNoHandling()
        {
            //call the Division method with argument 1 and 0
                Division(1,0);
            //this will terminate your application
        }

        static void DivisionWithExceptionHandling()
        {
            //call the Division method with argument 1 and 0
            try
            {
                Division(1, 0);
            } catch(DivideByZeroException e)
            {
                
            }
            
            //You will catch the exception and do nothing
            //Your application should not crash
        }

        static void DivisionWithExceptionHandlingMoreInfo()
        {
            //call the Division method with argument 1 and 0
            try
            {
                Division(1, 0);
            }catch(DivideByZeroException e) {

                Console.WriteLine($"Exception {e.Message}");
            }
            
            //You will catch the exception and print the associated message
            //your application should not crash
        }

        static void DivisionWithExceptionHandlingThrow()
        {
            //call the Division method with argument 1 and 0
            try
            {
                Division(1, 0);
            }
            catch (DivideByZeroException e)
            {

                Console.WriteLine($"Exception {e.Message}");

                throw new Exception("New exception thrown from DivisionWithExceptionHandlingThrow");

            }
            //You will catch the exception and print the associated message
            //You should create and throw a new exception
            //your application will crash
        }

        static void GeneratingException()
        {

            throw new Exception("New exception thrown from GeneratingException");
            //You should create and throw a new exception
            //your application will crash
        }

        static void HandlingRandomException()
        {
            //You should call the method below and catch all the possible exceptions individually and display a sensible output
            try
            {
                GeneratingRandomException(); 
            }
            catch (IndexOutOfRangeException)
            {
                Console.WriteLine("Caught an IndexOutOfRangeException");
            }
            catch (NullReferenceException)
            {
                Console.WriteLine("Caught a NullReferenceException");
            }
            catch (InvalidOperationException)
            {
                Console.WriteLine("Caught an InvalidOperationException");
            }
            catch (ArithmeticException)
            {
                Console.WriteLine("Caught an ArithmeticException");
            }
            catch (FormatException)
            {
                Console.WriteLine("Caught a FormatException");
            }
            catch (InvalidCastException)
            {
                Console.WriteLine("Caught an InvalidCastException");
            }
            catch (OutOfMemoryException)
            {
                Console.WriteLine("Caught an OutOfMemoryException");
            }
            //your application will not crash
        }
        static void GeneratingRandomException()
        {
            int exceptionType = new Random().Next() % 6;
            switch (exceptionType)
            {
                case 0:
                    throw new IndexOutOfRangeException();
                case 1:
                    throw new NullReferenceException();
                case 2:
                    throw new InvalidOperationException();
                case 3:
                    throw new ArithmeticException();
                case 4:
                    throw new FormatException();
                case 5:
                    throw new InvalidCastException();
                case 6:
                    throw new OutOfMemoryException();
            }
        }






    }
}