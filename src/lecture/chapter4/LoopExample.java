package lecture.chapter4;

public class LoopExample {

  public static void main(String[] args) {

    int count = 0;

    System.out.println("While-Schleife 0 - 9");
    // Kopfgesteuerte Schleife
    while (count < 10) {
      if(count % 2 != 0){
        count++;
        continue;
      }
      System.out.print(count++ + " - ");
    }
    System.out.println();


    System.out.println("Do-While-Schleife 0 - 9");
    // Fußgesteuerte Schleife
    count = 0;
    do {
      if(count == 6){
        System.out.println("Die böse Zahl!");
        break;
      }
      System.out.print(count++ + " - ");
    } while (count < 10);
    System.out.println();


    // Zählerschleife
    System.out.println("For-Schleife 0 - 9");
    for( int i = 0; i < 10; i++ ){
      System.out.print(i + " - ");
    }
    System.out.println();

    System.out.println("For-Schleife 0 - 9 nur gerade Zahlen");
    for(count = 0; count < 10; count = count + 2 ){
      System.out.print(count + " - ");
    }
    System.out.println();


    String[] niceWords = {"good", "awesome", "great", "wonderful"};

    System.out.println("Array mit For-Schleife: ");
    for(int i = 0; i < niceWords.length; i++){
      System.out.println(niceWords[i]);
    }

    System.out.println("Array mit For-Each-Schleife: ");
    for(String niceWord : niceWords){
      System.out.println(niceWord);
    }


    // Timmmmmmmmmmmmmay-Schleife
    count = 0;
    for(;;){
      if(count > 9){
        break;
      }
      System.out.print(count++ + " - ");
    }

    // Endlosschleife
    int valueA = 10, valueB = 10;
    while(valueA == valueB){
      //break;
    }

    System.out.println("Ende");

  }
}
