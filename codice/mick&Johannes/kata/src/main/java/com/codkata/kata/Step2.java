package com.codkata.kata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Step2 {
  static Map<String, String> hexTable = new HashMap<String, String>();

  private static List<String> strings =
      List.of("304", "9227", "D25130", "F31FE66F790C", "52D084A5BA6E6", "725C8E3F8BCF319FB68");

  static {
    hexTable.put("0", "0000");
    hexTable.put("1", "0001");
    hexTable.put("2", "0010");
    hexTable.put("3", "0011");
    hexTable.put("4", "0100");
    hexTable.put("5", "0101");
    hexTable.put("6", "0110");
    hexTable.put("7", "0111");
    hexTable.put("8", "1000");
    hexTable.put("9", "1001");
    hexTable.put("A", "1010");
    hexTable.put("B", "1011");
    hexTable.put("C", "1100");
    hexTable.put("D", "1101");
    hexTable.put("E", "1110");
    hexTable.put("F", "1111");
  }

  @RequestMapping(path = "/step2", method = RequestMethod.GET)
  public String esercizio() {

    String hex1 = "304";

    String hex1Binary = calculateBinary(hex1);
    double version = calculateDecimal(hex1Binary.substring(0, 3));
    double id = calculateDecimal(hex1Binary.substring(3, 6));
    String numberBinary = calculateDecimalGroups(hex1Binary.substring(6));
    double numberDecimal = calculateDecimal(numberBinary);
    return "Versione: " + version + "; ID:" + id + "; Number: " + numberDecimal + ";";
  }

  String calculateBinary(String hex) {
    char[] chars = hex.toCharArray();
    String res = "";
    for (int i = 0; i < chars.length; i++) {
      String binaryValue = hexTable.get(chars[i] + "");
      res += binaryValue;
    }

    return res;
  }

  private double calculateDecimal(String string) {
    char[] chars = string.toCharArray();
    double res = 0;
    for (int i = 0; i < chars.length; i++) {
      int charAsInt = Integer.parseInt(chars[i] + "");
      int power = chars.length - i - 1;
      res += charAsInt * Math.pow(2, power);
    }
    return res;
  }

  private String calculateDecimalGroups(String string) {
    String finalRes = "";
    while (string.length() > 5) {
      String group = string.substring(1, 5);
      finalRes += group;
      if (string.length() <= 5) {
        break;
      }
      string = string.substring(5);
    }
    return finalRes;
  }
}
