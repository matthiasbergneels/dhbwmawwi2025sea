package lecture.chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortExample {

  public static void main(String[] args) {

    List<Student> students = new ArrayList<>();

    // 5x Alter 25: Klaus Mueller, Anna Becker, Lisa Wagner, Lena Brauer, Tom Hansen
    // 3x gleiche Namenslänge (10 Zeichen): Anna Becker (4+6), Lisa Wagner (4+6), Lena Brauer (4+6)
    // 2x Duplikate: Gabi Schmitt (1001) und Klaus Mueller (1002)
    students.add(new Student(1001, "Gabi", "Schmitt", 22));     // len=11, age=22
    students.add(new Student(1002, "Klaus", "Mueller", 25));    // len=12, age=25
    students.add(new Student(1003, "Anna", "Becker", 25));      // len=10, age=25
    students.add(new Student(1004, "Lisa", "Wagner", 25));      // len=10, age=25
    students.add(new Student(1005, "Lena", "Brauer", 25));      // len=10, age=25
    students.add(new Student(1006, "Tom", "Hansen", 25));       // len=9,  age=25
    students.add(new Student(1007, "Max", "Mustermann", 30));   // len=13, age=30
    students.add(new Student(1008, "Ben", "Kurz", 28));         // len=7,  age=28
    students.add(new Student(1001, "Gabi", "Schmitt", 22));     // Duplikat von 1001
    students.add(new Student(1002, "Klaus", "Mueller", 25));    // Duplikat von 1002

    System.out.println("Anzahl Studierende: " + students.size());

    System.out.println("Unsortiert:");
    for(Student student : students) {
      System.out.println(student);
    }

    Collections.sort(students);
    System.out.println("Students - Natürliche Ordnung:");
    for(Student student : students) {
      System.out.println(student);
    }

    Collections.sort(students, new SortStudentByNameLength());
    System.out.println("Students - by Namelength:");
    for(Student student : students) {
      System.out.println(student);
    }

    // Sortierung mit Comparator durch Lambda Funktion
    Collections.sort(students, (o1, o2) -> {return o1.getAge() - o2.getAge();});
    System.out.println("Students - by Age:");
    for(Student student : students) {
      System.out.println(student);
    }



  }
}
