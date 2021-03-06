
package org.andre.rest;

import org.andre.bean.NameStorageBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author mkuchtiak
 */
@Stateless
@Path("/greeting")
public class HelloWorldResource {

  @EJB
  private NameStorageBean nameStorage;

  /**
   * Retrieves representation of an instance of helloworld.HelloWorldResource
   *
   * @return an instance of java.lang.String
   */
  @GET
  @Produces(MediaType.TEXT_XML)
  public String getGreeting() {
    return "<html><body><h1>Hello " + nameStorage.getName()+"!</h1></body></html>";
  }

  /**
   * PUT method for updating an instance of HelloWorldResource
   *
   * @param content representation for the resource
   * @return an HTTP response with content of the updated or created resource.
   */
  @PUT
  @Consumes("text/plain")
  public void setName(String content) {
    nameStorage.setName(content);
  }

}
