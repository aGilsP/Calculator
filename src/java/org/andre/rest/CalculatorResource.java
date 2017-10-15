
package org.andre.rest;

import org.andre.bean.Calculator;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mkuchtiak
 */
@Stateless
@Path("/calculator")
public class CalculatorResource {

  @EJB
  private Calculator calculator;

  @GET
  @Path("/add/{i}/{j}")
  @Produces(MediaType.TEXT_HTML)
  public String add(@PathParam("i")int i, @PathParam("j") int j) {
    return "<html><body><h1>added " + calculator.add(i,j)+"!</h1></body></html>";
  }
  
  @GET
  @Path("/subtract/{i}/{j}")
  @Produces(MediaType.TEXT_HTML)
  public String subtract(@PathParam("i")int i, @PathParam("j") int j) {
    return "<html><body><h1>subtracted " + calculator.subtract(i,j)+"!</h1></body></html>";
  }
  
  @GET
  @Path("/multiply/{i}/{j}")
  @Produces(MediaType.TEXT_HTML)
  public String multiply(@PathParam("i")int i, @PathParam("j") int j) {
    return "<html><body><h1>multiplied " + calculator.multiply(i,j)+"!</h1></body></html>";
  }
  
  @GET
  @Path("/divide/{i}/{j}")
  @Produces(MediaType.TEXT_HTML)
  public String divide(@PathParam("i")int i, @PathParam("j") int j) {
    return "<html><body><h1>divided " + calculator.divide(i,j)+"!</h1></body></html>";
  }
  
  @GET
  @Path("/remainder/{i}/{j}")
  @Produces(MediaType.TEXT_HTML)
  public String remainder(@PathParam("i")int i, @PathParam("j") int j) {
    return "<html><body><h1>remaining " + calculator.remainder(i,j)+"!</h1></body></html>";
  }
}
