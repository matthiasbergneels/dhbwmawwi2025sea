package lecture.chapter9;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

  public static void main(String[] args) {

    Set<String> cities = new TreeSet<>();

    cities.add("New York");
    cities.add("Berlin");
    cities.add("berlin");
    cities.add("Paris");
    cities.add("paris");
    cities.add("Rome");
    cities.add("New York");
    cities.add("Buxtehude");

    System.out.println("Anzahl Städte: " +  cities.size());
    for(String city : cities) {
      System.out.println(city);
    }

    cities.remove("Berlin");

    System.out.println("Anzahl Städte: " +  cities.size());


    System.out.println("===== Students =========");

    Set<Student> students = new TreeSet<>();

    students.add(new Student(4711, "Gabi", "Schmitt", 22));
    students.add(new Student(5821, "Klaus", "Zeus", 29));
    students.add(new Student(6161, "Fritz", "Humbold", 23));

    System.out.println("Anzahl Studierende: " + students.size());

    for(Student student : students) {
      System.out.println(student);
    }

    Set<Student> studentsByNameLength = new TreeSet<>(new  SortStudentByNameLength());

    studentsByNameLength.addAll(students);

    System.out.println("Sorted by Namelength: " + studentsByNameLength.size());
    for(Student student : studentsByNameLength) {
      System.out.println(student);
    }

    Set<Student> studentsByAge = new TreeSet(new  SortStudentByAge());
    studentsByAge.addAll(students);

    System.out.println("Sorted by Age: " + studentsByAge.size());
    for(Student student : studentsByAge) {
      System.out.println(student);
    }
  }
}
