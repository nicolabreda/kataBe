package teamMM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Step3 {
  public static void main(String[] args) {

    String valoreEffettivo = "";
    valoreEffettivo = hexToBin("620080001611562C8802118E34");
    Long version = 0L;
    System.out.println(valoreEffettivo);
    Long exit = 0L;
    int help = 0;
    while (help != 4) {
      String versione = valoreEffettivo.substring(0, 3);
      version += step1Ex(Collections.singletonList(versione)).get(0);
      String pacchetto = valoreEffettivo.substring(3, 6);

      if (pacchetto.equalsIgnoreCase("100")) {
        if(valoreEffettivo.length()<exit) {
          help = 4;
          ex3(valoreEffettivo);
        }
        char c = valoreEffettivo.charAt(6);

        if (valoreEffettivo.charAt(6) == '1') {
          String bit11 = valoreEffettivo.substring(7, 18);
          exit = step1Ex(Collections.singletonList(bit11)).get(0);
          valoreEffettivo = valoreEffettivo.substring(18);
        }else {
          String bit11 = valoreEffettivo.substring(7, 22);
          exit = step1Ex(Collections.singletonList(bit11)).get(0);
          valoreEffettivo = valoreEffettivo.substring(22);
        }
      } else {
        char c = valoreEffettivo.charAt(6);

        if (valoreEffettivo.charAt(6) == '1') {
          String bit11 = valoreEffettivo.substring(7, 18);
          exit = step1Ex(Collections.singletonList(bit11)).get(0);
          valoreEffettivo = valoreEffettivo.substring(18);
        }else {
          String bit11 = valoreEffettivo.substring(7, 22);
          exit = step1Ex(Collections.singletonList(bit11)).get(0);
          valoreEffettivo = valoreEffettivo.substring(22);
        }
      }
    }
    System.out.println(version);
  }

  private static void ex3(String input) {
    String s = input;
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