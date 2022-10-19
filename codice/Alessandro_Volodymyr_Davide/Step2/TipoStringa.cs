using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Step1_CodeKata
{
    class TipoStringa
    {
        public long ParseTipo4(string hex)
        {
            //int result = 0;
            int position = 0;
            string output = "";
            while (true)
            {
                
                string subStr = hex.Substring(position, 5);
                string numAsStr = subStr.Substring(1);
                output += numAsStr;
                //result += Convert.ToInt32(numAsStr, 2);
                if (subStr[0] == '0')
                {
                    break;
                }
                position += 5;
            }
            return Convert.ToInt64(output, 2);
        }

    }
}
