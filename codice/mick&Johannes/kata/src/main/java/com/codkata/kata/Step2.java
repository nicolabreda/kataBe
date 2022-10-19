package com.codkata.kata;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Step2 {

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public double esercizio() {

    String numberOne = "11";
    String numberTwo = "100101100011";
    String numberThree = "100101001001001100011";
    String numberFour = "100101001001001010010010001000001000100010100011";

    return calculateNumber(numberFour);
  }
}
