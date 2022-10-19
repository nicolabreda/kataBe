using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Step1_CodeKata
{
    class StrParser
    {

        public int ParseBinaryLine(string binary)
        {
            
            int tipologia = Convert.ToInt32(binary.Substring(3, 3), 2);
            switch (tipologia)
            {
                case 4:
                    TipoStringa tipoStr = new TipoStringa();
                    return tipoStr.ParseTipo4(binary.Substring(6));
                    break;
                default:
                    return -1;

            }

        }
    }
}
