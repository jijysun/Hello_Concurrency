package Concurrency_Project.Hello_Concurrency.common.apiPayload.exception.handler;

public class UserHandler extends RuntimeException {
  public UserHandler(String message) {
    super(message);
  }
}
