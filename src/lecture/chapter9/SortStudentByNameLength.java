package lecture.chapter9;

import java.util.Comparator;

public class SortStudentByNameLength implements Comparator<Student> {
  public int compare(Student o1, Student o2) {
    return (o1.getFirstName().length() + o1.getFamilyName().length()) - (o2.getFirstName().length() + o2.getFamilyName().length());
  }
}
