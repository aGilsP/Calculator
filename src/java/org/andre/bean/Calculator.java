package org.andre.bean;

import javax.ejb.Remote;

@Remote
public interface Calculator {

  public enum Operation {
    add(" + "),
    subtract(" - "),
    multiply(" x "),
    divide(" / "),
    remainder(" % ");

    private final String symbol;

    Operation(String o) {
      symbol = o;
    }

    public String getSymbol() {
      return symbol;
    }
  };

  public int add(int i, int j);

  public int subtract(int i, int j);

  public int multiply(int i, int j);

  public int divide(int i, int j);

  public int remainder(int i, int j);
}
