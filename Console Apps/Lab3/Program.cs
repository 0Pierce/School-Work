using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab3
{
    class Program
    {
        static void Main(string[] args)
        {

            string[] days = new string[] { "Monday", "Tuesday", "Wednesday", "Thurday", "Friday", "Saturday", "Sunday" };
            string peaks;

            for(int d = 0; d< 7; d++)
            {
                Console.WriteLine(days[d]);
               

                //Its a bit of an eye sore, but its the simplest and shortest way I thought of
                for (int h = 0; h < 24; h++)
                {

                    
                        switch (h)
                        {

                        
                            case (0):
 
                               
                                Console.WriteLine("12 am: Off-Peak");
                                break;

                            case (1):
                                Console.WriteLine("1 am: Off-Peak");
                                break;

                            case (2):
                                Console.WriteLine("2 am: Off-Peak");
                                break;
                            case (3):
                                Console.WriteLine("3 am: Off-Peak");
                                break;
                            case (4):
                                Console.WriteLine("4 am: Off-Peak");
                                break;
                            case (5):
                                Console.WriteLine("5 am: Off-Peak");
                                break;
                            case (6):
                                Console.WriteLine("6 am: Off-Peak");
                                break;
                            case (7):
                                Console.WriteLine("7 am: Off-Peak");
                                break;
                            case (8):
                            if (d <= 4)
                            {
                                peaks = "Mid-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"8 am: {peaks}");
                                break;

                            case (9):
                            if (d <= 4)
                            {
                                peaks = "Mid-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"9 am: {peaks}");
                                break;

                            case (10):
                            if (d <= 4)
                            {
                                peaks = "Mid-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"10 am: {peaks}");
                                break;

                            case (11):
                            if (d <= 4)
                            {
                                peaks = "Mid-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"11 am: {peaks}");
                                break;

                            case (12):
                            if (d <= 4)
                            {
                                peaks = "On-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"12 pm: {peaks}");
                                break;

                            case (13):
                            if (d <= 4)
                            {
                                peaks = "On-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"1 pm: {peaks}");
                                break;

                            case (14):
                            if (d <= 4)
                            {
                                peaks = "On-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"2 pm: {peaks}");
                                break;

                            case (15):
                            if (d <= 4)
                            {
                                peaks = "On-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"3 pm: {peaks}");
                                break;

                            case (16):
                            if (d <= 4)
                            {
                                peaks = "On-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"4 pm: {peaks}");
                                break;

                            case (17):
                            if (d <= 4)
                            {
                                peaks = "On-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"4 pm: {peaks}");
                                break;

                            case (18):
                            if (d <= 4)
                            {
                                peaks = "Mid-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"6 pm: {peaks}");
                                break;

                            case (19):
                            if (d <= 4)
                            {
                                peaks = "Mid-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"7 pm: {peaks}");
                                break;

                            case (20):
                            if (d <= 4)
                            {
                                peaks = "Off-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"8 pm: {peaks}");
                                break;

                            case (21):
                            if (d <= 4)
                            {
                                peaks = "Off-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"9 pm: {peaks}");
                                break;

                            case (22):
                            if (d <= 4)
                            {
                                peaks = "Off-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"10 pm: {peaks}");
                                break;

                            case (23):
                            if (d <= 4)
                            {
                                peaks = "Off-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"11 pm: {peaks}");
                                break;

                            case (24):
                            if (d <= 4)
                            {
                                peaks = "Off-Peak";
                            }
                            else
                            {
                                peaks = "Off-Peak";

                            }
                            Console.WriteLine($"12 pm: {peaks}");
                                break;

                        }


                        
                    

                    
                
                }


            }

        }

    }

   
}
