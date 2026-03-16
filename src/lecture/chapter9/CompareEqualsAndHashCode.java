package lecture.chapter9;

public class CompareEqualsAndHashCode {

  public static void main(String[] args) {

    Student s1 = new Student(4711, "Gabi", "Schmitt", 25);
    Student s2 = new Student(5812, "Klaus", "Mayer", 21);
    Student s3 = new Student(4711, "Gabi", "Schmitt", 25);
    Student s4 = s1;

    System.out.println("compareTo - Vergleich:");
    System.out.println("S1 compareTo S2: " + s1.compareTo(s2));
    System.out.println("S1 compareTo S3: " + s1.compareTo(s3));
    System.out.println("S1 compareTo S4: " + s1.compareTo(s4));


    System.out.println("equals - Vergleich:");
    System.out.println("S1 equals S2: " + s1.equals(s2));
    System.out.println("S1 equals S3: " + s1.equals(s3));
    System.out.println("S1 equals S4: " + s1.equals(s4));
    System.out.println("S1 equals Karsten: " + s1.equals("Karsten"));

    System.out.println("== - Vergleich:");
    System.out.println("S1 == S2: " + (s1 == s2));
    System.out.println("S1 == S3: " + (s1 == s3));
    System.out.println("S1 == S4: " + (s1 == s4));

    System.out.println("hashCode():");
    System.out.println("S1: " + s1.hashCode());
    System.out.println("S2: " + s2.hashCode());
    System.out.println("S3: " + s3.hashCode());
    System.out.println("S4: " + s4.hashCode());

    String text1 = "Hallo";
    String text2 = "Blau";
    String text3 = new String("Hallo");
    String text4 = text1;

    System.out.println("compareTo - Vergleich:");
    System.out.println("S1 compareTo S2: " + text1.compareTo(text2));
    System.out.println("S1 compareTo S3: " + text1.compareTo(text3));
    System.out.println("S1 compareTo S4: " + text1.compareTo(text4));

    System.out.println("equals - Vergleich:");
    System.out.println("S1 equals S2: " + text1.equals(text2));
    System.out.println("S1 equals S3: " + text1.equals(text3));
    System.out.println("S1 equals S4: " + text1.equals(text4));

  }
}
