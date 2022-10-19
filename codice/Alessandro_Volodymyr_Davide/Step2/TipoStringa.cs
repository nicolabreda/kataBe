using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Step1_CodeKata
{
    class TipoStringa
    {
        public int ParseTipo4(string hex)
        {
            int result = 0;
            int position = 0;
            while (true)
            {
                
                string subStr = hex.Substring(position, 5);
                result += Convert.ToInt32(subStr.Substring(1), 2);
                if (subStr[0] == '0')
                {
                    break;
                }
                position += 5;
            }
            return result;
        }

    }
}
