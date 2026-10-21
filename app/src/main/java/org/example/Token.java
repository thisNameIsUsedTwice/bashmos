package org.example;

public class Token {
  private TokenType type;
  private String value;

  public Token(TokenType type, String value) {
    this.type = type;
    this.value = value;
  }

  public Token() {
    this.type = TokenType.PLACEHOLDER;
    this.value = "";
  }

  public String toString() {
    return this.type + this.value;
  }

  public void setTokenType(TokenType type) {
    this.type = type;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public TokenType getTokenType() {
    return type;
  }

  public String getValue() {
    return value;
  }
}
