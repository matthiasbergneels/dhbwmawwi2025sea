package lecture.chapter3;

public class ArrayExamples {

  public static void main(String[] args) {

    int a, b, c, d, e, f, g;

    // Arrays = field variables
    int[] numbersList= new int[5];

    numbersList[0] = 1;
    numbersList[1] = 56;
    numbersList[2] = 78;
    numbersList[3] = 123;
    numbersList[4] = 456;

    System.out.println("Wert an Index 2: " + numbersList[2]);

    char[] halloArray = {'H', 97, 'l', 'l', 'o'};
    System.out.println(halloArray[0]);
    System.out.println(halloArray[1]);
    System.out.println(halloArray[2]);
    System.out.println(halloArray[3]);
    System.out.println(halloArray[4]);


    // multi dimensional - tictactoe

    char[][] tictactoe = new char[3][3];
    tictactoe[1][1] = 'X';
    tictactoe[0][2] = 'O';

    System.out.println("Feld 1-1: " + tictactoe[1][1]);
    System.out.println("Feld 0-2: " + tictactoe[0][2]);

    // multi dimensional - book

    // Dimesnions: chapters - sentences - words
    // Define book with 5 chapters
    String[][][] book = new String[5][][];

    // define first chapter with 20 sentences
    book[0] = new String[20][];

    // define first chapter - first sentence - with 5 words
    book[0][0] = new String[5];

    // define words
    book[0][0][0] = "Hallo";
    book[0][0][1] = "meine";
    book[0][0][2] = "aller";
    book[0][0][3] = "liebsten";
    book[0][0][4] = "Lesenden";

    // define first chapter - second sentence - with 10 words
    book[0][1] = new String[10];

    // define words
    book[0][1][0] = "Dieses";
    book[0][1][1] = "Buch";
    book[0][1][2] = "widme";
    book[0][1][3] = "ich";
    book[0][1][4] = "dem";
    book[0][1][5] = "geliebten";
    book[0][1][6] = "Genitiv";
    book[0][1][7] = "da";
    book[0][1][8] = "da";
    //...

    System.out.println("Anzahl Kapitel im Buch: " + book.length);
    System.out.println("Anzahl der Sätze im ersten Kapitel: " +  book[0].length);
    System.out.println("Anzahl der Wörter im ersten Satz des ersten Kapitels: " + book[0][0].length);
    System.out.println("Anzahl der Wörter im zweiten Satz des ersten Kapitels: " + book[0][1].length);


    System.out.println(book[0][1][6]);

    String[][][] shortBook = {{{"Hallo", "liebe", "Lesenden"},{"Diese", "Buch", "ist", "super"}}, {{"Hallo", "liebe", "Lesenden"},{"Diese", "Buch", "ist", "super"}}};

    System.out.println(shortBook[1][1][3]);

  }
}
