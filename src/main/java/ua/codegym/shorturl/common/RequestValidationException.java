package ua.codegym.shorturl.common;

import com.sun.jersey.api.Responses;

import javax.ws.rs.WebApplicationException;

public class RequestValidationException extends WebApplicationException {

  public RequestValidationException(String message) {
    super(Responses.methodNotAllowed().entity(message)
        .type("text/plain").build());
  }
}
