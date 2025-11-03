package lecture.chapter3;

public class ReferenceVsSimpleDataTypes {

  public static void main(String[] args) {

    int myFirstNumber = 42;
    int mySecondNumber = 555;

    System.out.println(myFirstNumber);
    System.out.println(mySecondNumber);

    mySecondNumber = myFirstNumber;

    System.out.println(myFirstNumber);
    System.out.println(mySecondNumber);

    myFirstNumber = 13;

    System.out.println(myFirstNumber);
    System.out.println(mySecondNumber);


    String[] goodTeacherGrade = {"Der", "Dozent", "ist", "toll"};
    String[] badTeacherGrade;

    badTeacherGrade = goodTeacherGrade;

    System.out.println(goodTeacherGrade[3]);
    System.out.println(badTeacherGrade[3]);

    badTeacherGrade[3] = "scheiße!";

    System.out.println(goodTeacherGrade[3]);
    System.out.println(badTeacherGrade[3]);


    // "copy"
    badTeacherGrade = new String[4];

    badTeacherGrade[0] = goodTeacherGrade[0];
    badTeacherGrade[1] = goodTeacherGrade[1];
    badTeacherGrade[2] = goodTeacherGrade[2];
    badTeacherGrade[3] = goodTeacherGrade[3];

    goodTeacherGrade[3] = "toll!";

    System.out.println(goodTeacherGrade[3]);
    System.out.println(badTeacherGrade[3]);
  }
}
