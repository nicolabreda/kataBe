package com.codkata.kata;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExerciseController {

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public double binaryToInt() {

    String numberOne = "11";
    String numberTwo = "100101100011";
    String numberThree = "100101001001001100011";
    String numberFour = "100101001001001010010010001000001000100010100011";

    return calculateNumber(numberFour);
  }

  private double calculateNumber(String string) {
    char[] chars = string.toCharArray();
    double res = 0;
    for (int i = 0; i < chars.length; i++) {
      int charAsInt = Integer.parseInt(chars[i] + "");
      int power = chars.length - i - 1;
      res += charAsInt * Math.pow(2, power);
    }
    return res;
  }

  public void calculateNumber() {
    String binaryString = "1010";
    String numberOne = "11";
    String numberTwo = "100101100011";
    String numberThree = "100101001001001100011";
    String numberFour = "100101001001001010010010001000001000100010100011";
    int decimal = Integer.parseInt(binaryString, 2);
    int decimal1 = Integer.parseInt(numberOne, 2);
    int decimal2 = Integer.parseInt(numberTwo, 2);
    int decimal3 = Integer.parseInt(numberThree, 2);
    int decimal4 = Integer.parseInt(numberFour, 2);
    System.out.println(decimal);
    System.out.println(decimal1);
    System.out.println(decimal2);
    System.out.println(decimal3);
    System.out.println(decimal4);
  }
}
