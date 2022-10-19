package step1;

import java.util.ArrayList;
import java.util.List;

public class Converter {


    public static List<Long> converter(List<String> binarie) {
        Long risultato = null;
        List<Long> risultati = new ArrayList<>();

        for (int i = 0; i < binarie.size(); i++) {
           risultati.add(Long.parseLong(binarie.get(i), 2))  ;

        }

        return risultati;
    }


}

