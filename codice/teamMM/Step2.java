package teamMM;

import java.util.ArrayList;
import java.util.List;

public class Step2 {
  public static void main(String[] args) {


    String s = hexToBin("304");
    //List<String> input = new ArrayList<>();
    //List<String> versioneList = new ArrayList<>();
    String pacchetto = s.substring(0, 3);
    String versione = s.substring(3, 6);
    String risultato = "";
    String finale = "";
    List<String> risultati = new ArrayList<>();
    if (versione.equalsIgnoreCase("100")) {
      String base = s.substring(6, s.length());
      finale = "versione : 4 ";
      for (int i = 0; i < base.length(); i += 5) {
        if (base.charAt(i) == '1') {
          risultato += base.substring(i + 1, i + 5);
        }
        if (base.charAt(i) == '0') {
          risultato += base.substring(i + 1, i + 5);
          break;
        }

      }

    }
    risultati.add(risultato);
    List<Long> longs = step1Ex(risultati);
    for (Long l:longs) {
      System.out.println(finale + "valore numerico: " + l);
    }


    System.out.println("risultato: " + risultato);
    System.out.println(s);
    System.out.println(pacchetto);
    System.out.println(versione);


  }

  private static String hexToBin(String hex) {
    hex = hex.replaceAll("0", "0000");
    hex = hex.replaceAll("1", "0001");
    hex = hex.replaceAll("2", "0010");
    hex = hex.replaceAll("3", "0011");
    hex = hex.replaceAll("4", "0100");
    hex = hex.replaceAll("5", "0101");
    hex = hex.replaceAll("6", "0110");
    hex = hex.replaceAll("7", "0111");
    hex = hex.replaceAll("8", "1000");
    hex = hex.replaceAll("9", "1001");
    hex = hex.replaceAll("A", "1010");
    hex = hex.replaceAll("B", "1011");
    hex = hex.replaceAll("C", "1100");
    hex = hex.replaceAll("D", "1101");
    hex = hex.replaceAll("E", "1110");
    hex = hex.replaceAll("F", "1111");
    return hex;
  }

  private static List<Long> step1Ex(List<String> texts) {
    List<Long> longs = new ArrayList<>();
    for (String string : texts) {
      longs.add(Long.parseLong(string, 2));
    }
    return longs;
  }
}