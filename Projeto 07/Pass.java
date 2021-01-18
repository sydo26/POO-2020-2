public class Pass {
  private String name;
  private int age;
  private boolean isPref;

  public Pass(String id, int age) {
    this.name = id;
    this.age = age;
    this.isPref = this.age >= 60;
  }

  public String toString() {
    return this.name + ":" + (this.age == -1 ? "?" : this.age);
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public boolean isPref() {
    return isPref;
  }
}
