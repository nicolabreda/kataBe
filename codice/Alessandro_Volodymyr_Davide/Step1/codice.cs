using System;

namespace Step1_CodeKata
{
    class Program
    {
        static void Main(string[] args)
        {

            foreach (string line in System.IO.File.ReadLines("binary.txt"))
            {
                long numero = Convert.ToInt64(line, 2);

                System.IO.File.AppendAllText("output.txt", numero.ToString() + Environment.NewLine);
            }
        }
    }
}
