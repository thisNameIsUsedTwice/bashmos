package org.example;

import java.util.ArrayList;

public class Parser {

  private static ArrayList<Double> parse(String equation, int index) {
    // Takes in string, outputs a 1D arraylist with operations sequentially (idk if
    // this will work as intented)
    // If positive, means number. If negative:
    // -(1 - 7) plus, minus, multiply, divide, exponent, left and right parenthesis
    // -(8 - 33) variables, 24 letters besides e and i, plus theta and phi
    // -(34) subscript operation (for variables)
    // -(35 - 46) 6 trig formulas and their inverses

    // I was messing around with recursion, I don't think I'll keep it. This is just
    // a temporary expirement. Also, I might barely use the parser anyway because
    // the UI would work slightly different with real time input
    ArrayList<Double> output = new ArrayList<>();

    char c = equation.charAt(index);
    char next = equation.charAt(index + 1);
    if (Character.isDigit(c)) {
      output = parse(equation, index + 1);
      if (Character.isDigit(next)) {
        output.set(0, output.get(0) + Character.getNumericValue(c));
      } else {
        output.add(0, (double) Character.getNumericValue(c));
        return output;
      }
    }

    return output;
  }

  public static double[] parse(String equation) {
    return parse(equation);
  }
}
