package example.entity;


public class Person {

  private String firstName;
  private String lastName;
  private Integer age;
  private String job;

  public Person() {
  }

  public Person(String firstName, String lastName, Integer age, String job) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.job = job;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
