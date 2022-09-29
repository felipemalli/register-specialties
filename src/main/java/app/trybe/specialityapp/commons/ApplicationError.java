package app.trybe.specialityapp.commons;

import javax.ws.rs.core.Response.Status;

/**
 * ApplicationError class.
 */
public class ApplicationError extends RuntimeException {
  private Status status;
  private String message;

  /**
   * ApplicationError constructor.
   */
  public ApplicationError(Status status, String message) {
    super(message);
    this.status = status;
    this.message = message;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setError(String message) {
    this.message = message;
  }
}