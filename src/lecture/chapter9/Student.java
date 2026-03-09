package lecture.chapter9;

public class Student implements Comparable<Student> {

  private int id;
  private String firstName;
  private String familyName;
  private int age;

  public Student(int id, String firstName, String familyName, int age) {
    this.id = id;
    this.firstName = firstName;
    this.familyName = familyName;
    this.age = age;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Student{" +
      "id=" + id +
      ", firstName='" + firstName + '\'' +
      ", familyName='" + familyName + '\'' +
      ", age=" + age + '\'' +
      ", name length=" + (familyName.length() + firstName.length()) +
      '}';
  }

  @Override
  public int compareTo(Student o) {
    /*
      return this.id - o.id;
     */

    if(!this.familyName.equals(o.familyName)) {
      return this.familyName.compareTo(o.familyName);
    }

    if(!this.firstName.equals(o.firstName)) {
      return this.firstName.compareTo(o.firstName);
    }

    return  this.age - o.age;
  }
}
