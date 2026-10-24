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
          if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
            t.setValue("" + c);
            t.setTokenType(TokenType.OPERATOR);
            output.add(t);
            index++;
          } else if (c == '(' || c == ')') {
            t.setValue("" + c);
            t.setTokenType(TokenType.PARENTHESIS);
            output.add(t);
            index++;
          }
          decimel = 0;
          previous = false;
        }
      }
    }

    return output;
  }

  public static double evaluate(String equation) {
    // Input an equation with just numbers and opreations, get an answer
    return evaluate(parse(equation));
  }

  public static double evaluate(ArrayList<Token> tokens) {

    ArrayList<Token> temp = new ArrayList<>(tokens);

    for (int i = 0; i < temp.size(); i++) {
      Token t = temp.get(i);
      if (t.getValue().equals("(")) {
        boolean closed = false;
        int j = i + 1;
        int numOfPar = 0;
        while (!closed) {
          Token t2 = temp.get(j);
          if (t2.getValue().equals(")")) {
            if (numOfPar > 0) {
              numOfPar--;
              j++;
            } else
              closed = true;
          } else {
            if (t2.getValue().equals("("))
              numOfPar++;
            j++;
          }
        }
        ArrayList<Token> sub = new ArrayList<>(temp.subList(i + 1, j));

        temp.subList(i, j + 1).clear();
        Token tok = new Token(TokenType.NUMBER, "" + evaluate(sub));
        temp.add(i, tok);
      }
    }

    for (int i = 1; i < temp.size() - 1; i++) {
      Token t = temp.get(i);
      if (t.getValue().equals("^")) {
        double exp = Math.pow(Double.parseDouble(temp.get(i - 1).getValue()),
            Double.parseDouble(temp.get(i + 1).getValue()));
        temp.subList(i - 1, i + 2).clear();
        Token tok = new Token(TokenType.NUMBER, "" + exp);
        temp.add(i - 1, tok);
      }
    }

    for (int i = 1; i < temp.size() - 1; i++) {
      Token t = temp.get(i);
      if (t.getValue().equals("*") || t.getValue().equals("/")) {
        double mult = 0;
        if (t.getValue().equals("*"))
          mult = Double.parseDouble(temp.get(i - 1).getValue()) * Double.parseDouble(temp.get(i + 1).getValue());
        else
          mult = Double.parseDouble(temp.get(i - 1).getValue()) / Double.parseDouble(temp.get(i + 1).getValue());
        temp.subList(i - 1, i + 2).clear();
        Token tok = new Token(TokenType.NUMBER, "" + mult);
        temp.add(i - 1, tok);
      }
    }

    for (int i = 1; i < temp.size() - 1; i++) {
      Token t = temp.get(i);
      if (t.getValue().equals("+") || t.getValue().equals("-")) {
        double add = 0;
        if (t.getValue().equals("+"))
          add = Double.parseDouble(temp.get(i - 1).getValue()) + Double.parseDouble(temp.get(i + 1).getValue());
        else
          add = Double.parseDouble(temp.get(i - 1).getValue()) - Double.parseDouble(temp.get(i + 1).getValue());
        temp.subList(i - 1, i + 2).clear();
        Token tok = new Token(TokenType.NUMBER, "" + add);
        temp.add(i - 1, tok);
      }
    }

    if (temp.size() == 1) {
      return Double.parseDouble(temp.get(0).getValue());
    }

    return Integer.MIN_VALUE; // something went wrong
  }

}
