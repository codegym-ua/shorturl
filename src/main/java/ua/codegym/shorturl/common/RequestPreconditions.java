package ua.codegym.shorturl.common;

public final class RequestPreconditions {

  public static <T> T checkNotNull(T obj, String message) {
    if (obj == null) {
      throw new RequestValidationException(message);
    }
    return obj;
  }

}
