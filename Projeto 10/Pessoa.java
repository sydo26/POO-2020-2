public class Pessoa {
  private String name;
  private int age;
  private boolean student;

  public Pessoa(String name, int age, boolean student) {
    this.name = name;
    this.age = age;
    this.student = student;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public boolean isStudent() {
    return student;
  }

  @Override
  public String toString() {
    return (new StringBuilder()).append("[").append(this.getName()).append(", ").append(this.getAge()).append(", ")
        .append(this.isStudent() ? "sim" : "nao").append("]").toString();
  }
}
