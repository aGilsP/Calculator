/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.andre.bean;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import org.andre.interceptor.Logging;

@Stateless
public class CalculatorBean implements Calculator {

  @Override
  @Interceptors(Logging.class)
  public int add(int a,int b) {
    return a + b;
  }

  @Override
  @Interceptors(Logging.class)
  public int subtract(int a, int b){
    return a - b;
  }

  @Override
  public int multiply(int a, int b) {
    return a * b;
  }

  @Override
  public int divide(int a, int b) {
    return a / b;
  }

  @Override
  public int remainder( int a, int b) {
    return a % b;
  }
}