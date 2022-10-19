package com.codkata.kata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Step3 {
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

  double versionResult = 0;

  @RequestMapping(path = "/step3", method = RequestMethod.GET)
  public String esercizio() {
    versionResult = 0;

    String hex1Binary = calculateBinary("620080001611562C8802118E34");
    calculateAllVersions(hex1Binary);
    return versionResult + "";
  }

  private void calculateAllVersions(String binary) {
    if (!isValid(binary)) {
      return;
    }
    double version = calculateDecimal(binary.substring(0, 3));
    versionResult += version;

    double idPackage = calculateDecimal(binary.substring(3, 6));
    String strippedBinary = binary.substring(6);
    if (idPackage != 4) {
      double idLunghezza = calculateDecimal(strippedBinary.substring(0, 1));
      strippedBinary = strippedBinary.substring(1);
      if (idLunghezza == 0) {
        String totalPackageLengthBinary = strippedBinary.substring(0, 15);
        Double packageLength = calculateDecimal(totalPackageLengthBinary);
        calculateAllVersions(strippedBinary.substring(15));
      } else if (idLunghezza == 1) {
        String subpackageNumber = strippedBinary.substring(0, 11);
        Double packageLength = calculateDecimal(subpackageNumber);
        calculateAllVersions(strippedBinary.substring(11));
      }
    }

    calculateAllVersions(strippedBinary.substring(calculateEndOfGroup(strippedBinary)));
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

  private int calculateEndOfGroup(String string) {
    while (string.length() >= 5) {
      String group = string.substring(1, 5);
      String hexChar = hexTable.get(group);
      try {
        Double.parseDouble(hexChar);
      } catch (Exception e) {
        break;
      }
      if (string.length() <= 5) {
        break;
      }
      string = string.substring(5);
    }
    return string.length() - 1;
  }

  boolean isValid(String binary) {
    if (binary.length() <= 6) {
      return false;
    }
    return true;
  }
}
