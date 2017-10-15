/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.andre.interceptor;

import java.util.function.BiFunction;
import java.util.logging.Logger;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import org.andre.bean.Calculator.Operation;

/**
 *
 * @author gillesandre
 */
public class Logging {

  // ======================================
// =             Attributes             =
// ======================================
//@Inject
  protected Logger logger = Logger.getLogger(Logging.class.getSimpleName());

  // ======================================
  // =           Public Methods           =
  // ======================================
  @AroundConstruct
  private void init(InvocationContext ic) throws Exception {
    logger.info("Entering constructor");
    logger.info("Entering constructor");
    try {
      ic.proceed();
    } finally {
      logger.info("Exiting constructor");
      logger.info("Exiting constructor");
    }
  }

  @AroundInvoke
  public Object logMethod(InvocationContext ic) throws Exception {
    logger.entering(ic.getTarget().toString(), ic.getMethod().getName());

    try {
      Object obj = ic.proceed();
      logger.info(">>> "
        + " - " + ic.getMethod().getName() + " : " + listParameters.apply(ic.getParameters(), Operation.valueOf(ic.getMethod().getName())) + " = " + obj);
      return obj;
    } finally {
      //logger.info("<<< "
      //+ ic.getTarget().toString() 
      //  + " - " + ic.getMethod().getName());
      logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
    }
  }

  protected BiFunction<Object[], Operation, String> listParameters = (p, o) -> {
    StringBuilder s = new StringBuilder();
    s.append(p[0]).append(o.getSymbol()).append(p[1]);
    return s.toString();
  };
}
