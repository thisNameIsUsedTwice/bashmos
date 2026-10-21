package org.example;

import java.util.ArrayList;

public class Parser {

  // current implementation should output an arraylist of just the numbers
  public static ArrayList<Token> parse(String equation) {
    // Takes in string, outputs a 1D arraylist with numbers and operations
    // sequentially (idk if this will work as intented)

    ArrayList<Token> output = new ArrayList<>();

    boolean previous = false;
    int decimel = 0;
    int index = 0;

    for (int i = 0; i < equation.length(); i++) {
      Token t = new Token();
      char c = equation.charAt(i);
      if (Character.isDigit(c)) {
        t.setTokenType(TokenType.NUMBER);
        if (previous == true && decimel == 0) {
          t.setValue("" + (Double.parseDouble(output.get(index - 1).getValue()) * 10 + Character.getNumericValue(c)));
          output.set(index - 1, t);
        } else if (previous == true && decimel > 0) {
          t.setValue("" + (Double.parseDouble(output.get(index - 1).getValue())
              + Character.getNumericValue(c) * Math.pow(10, -decimel)));
          output.set(index - 1, t);
          decimel++;
        } else {
          t.setValue("" + c);
          output.add(t);
          index++;
        }
        previous = true;
      } else {
        if (c == '.') {
          decimel = 1;
          previous = true;
        } else {
          decimel = 0;
          previous = false;
        }
      }
    }

    return output;
  }

}
