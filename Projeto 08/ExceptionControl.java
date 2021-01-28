@SuppressWarnings("serial")
public class ExceptionControl extends Exception {
  public ExceptionControl(String message) {
    super(message);
  }

  @Override
  public void printStackTrace() {
    System.out.println("fail: " + getMessage());
  }

}
