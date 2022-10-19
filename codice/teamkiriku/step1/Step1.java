package step1;

import java.util.Arrays;
import java.util.List;

public class Step1{

    public static void main (String[] args){

        List<String> binarie= Arrays.asList("11", "100101100011", "100101001001001100011", "100101001001001010010010001000001000100010100011");
        List<Long> risultati = Converter.converter(binarie);

        for (int i = 0; i<risultati.size(); i++){
            System.out.println(risultati.get(i));
        }





    }
}