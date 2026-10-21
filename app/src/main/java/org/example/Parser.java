package org.example;

import java.util.ArrayList;

public class Parser {

  // current implementation should output an arraylist of just the numbers
  public static ArrayList<Double> parse(String equation) {
    // Takes in string, outputs a 1D arraylist with operations sequentially (idk if
    // this will work as intented)
    // If positive, means number. If negative:
    // -(1 - 7) plus, minus, multiply, divide, exponent, left and right parenthesis
    // -(8 - 33) variables, 24 letters besides e and i, plus theta and phi
    // -(34) subscript operation (for variables)
    // -(35 - 46) 6 trig formulas and their inverses

    ArrayList<Double> output = new ArrayList<>();

    boolean previous = false;
    int decimel = 0;
    int index = 0;

    for (int i = 0; i < equation.length(); i++) {
      char c = equation.charAt(i);
      if (Character.isDigit(c)) {
        if (previous == true && decimel == 0) {
          output.set(index - 1, output.get(index - 1) * 10 + Character.getNumericValue(c));
        } else if (decimel > 0) {
          output.set(index - 1, output.get(index - 1) + Character.getNumericValue(c) * Math.pow(10, -decimel));
          decimel++;
        } else {
          output.add((double) Character.getNumericValue(c));
          index++;
        }
        previous = true;
      } else {
        if (c == '.') {
          decimel = 1;
        } else {
          decimel = 0;
        }
        previous = false;
      }
    }

    return output;

    /*
     * if (Character.isDigit(c)) {
     * output = parse(equation, index + 1);
     * if (Character.isDigit(next)) {
     * output.set(0, output.get(0) + Character.getNumericValue(c));
     * } else {
     * output.add(0, (double) Character.getNumericValue(c));
     * return output;
     * }
     * }
     */

  }
}
