package lecture.chapter9;

import java.util.Objects;

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


  @Override
  public boolean equals(Object obj) {
    if(this == obj) {
      return true;
    }
    if(obj == null) {
      return false;
    }
    if(this.getClass() != obj.getClass()) {
      return false;
    }

    Student student = (Student) obj;
    /* --> ensure consistency to compareTo
    if(this.id != student.id) {
      return false;
    }
     */

    if(!this.firstName.equals(student.firstName)) {
      return false;
    }
    if(!this.familyName.equals(student.familyName)) {
      return false;
    }
    return this.age == student.age;
  }


  /* --> IntelliJ Default implementation of equals
  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    Student student = (Student) o;
    return age == student.age && Objects.equals(firstName, student.firstName) && Objects.equals(familyName, student.familyName);
  }

   */

  @Override
  public int hashCode() {

    return this.age ^ this.familyName.hashCode() ^ this.firstName.hashCode();

    /*
    int result = 31 * Objects.hashCode(firstName);
    result = 17 * result + Objects.hashCode(familyName);
    result = 31 * result + age;
    return result;

     */
  }
}
