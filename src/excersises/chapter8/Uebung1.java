package excersises.chapter8;

import java.io.FileWriter;
import java.io.IOException;

public class Uebung1 {
  public static void main(String[] args)  {
    FileWriter datei = null;
    String text;

    try{
      datei = new FileWriter("ausgabe.txt");
      text = "1\n";

      for(int i = 2; i <=100; i++){
        text += i;
        text += "\n";
      }

      datei.write(text, 0, text.length());
      //datei.flush();
    }catch (IOException e){
      IO.println("Fehler bei der Verarbeitung der Datei: " + e.getMessage());
    }finally {
      try {
        datei.close();
      }catch (IOException e){
        IO.println("Fehler bei der Schließen der Datei: " + e.getMessage());
      }
    }
  }

}