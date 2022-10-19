using System;
using System.Linq;

namespace Step1_CodeKata
{
    class Program
    {

        static void Main(string[] args)
        {
            foreach (string line in System.IO.File.ReadLines("hex.txt"))
            {

                string binary = String.Join(String.Empty, line.Select(c => Convert.ToString(Convert.ToUInt32(c.ToString(), 16), 2).PadLeft(4, '0')));

                StrParser parser = new StrParser();
                long num = parser.ParseBinaryLine(binary);

                int version = Convert.ToInt32(binary.Substring(0, 3), 2);


                System.IO.File.AppendAllText("output.txt", $"Versione: {version}, Numero: {num}" + Environment.NewLine);

            }

        }
    }
}
