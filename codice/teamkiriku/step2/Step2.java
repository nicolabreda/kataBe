package step2;


import step1.Converter;

import java.util.*;

public class Step2 {

    public static void main (String [] args){

        String input = "304";
        List<String> stringhe = Arrays.asList("304", "9227", "D25130","F31FE66F790C", "52D084A5BA6E69", "725C8E3F8BCF319FB68");
        List<String> risultati= getCode(stringhe);


        String versione;
        String tipo;
        String valore = "";


        List<String> results = new ArrayList<>();
        for(String s : risultati){

            versione = s.substring(0,3);
            tipo = s.substring(3,6);


            if(tipo.equals("100")){
                String base = s.substring(6,s.length());
                valore = "";

                for(int i = 0; i<base.length(); i+=5) {
                    if (base.charAt(i) == '1') {
                        valore += base.substring(i + 1, i + 5);
                    }
                    if (base.charAt(i) == '0') {
                        valore += base.substring(i + 1, i + 5);
                        break;
                    }
                }
                System.out.println("VERSIONE : " + Long.parseLong(versione,2) + "- TIPO: " + Long.parseLong(tipo,2) + "- VALORE: " + Long.parseLong(valore,2));


            }


        }

        List<Long> prova = Converter.converter(results);

        for(Long s : prova){
            System.out.println("RISULTATOOOO:  " + s);
        }

    }

    public static List<String >getCode(List<String> stringhe){
        List<String> risultati = new ArrayList<>();
        String risultato ="";
        Map<String, String> mappa = Mappa.getMap();
        for(String stringa : stringhe){
            risultato = "";
            for( int i=0; i<stringa.length(); i++ ){
                String carattere = "" + stringa.charAt(i);

                risultato += mappa.get(carattere);



            }
            risultati.add(risultato);

        }

        return risultati;
    }
}
