import javax.swing.*;

void main(){

  boolean isRaining = true;

  if (isRaining) {
    IO.println("Der Boden wird nass!");
    IO.println("Ich muss nicht gießen!");
  } else {
    IO.println("Ich lasse den Regenschirm zuhause");
  }

  int valueA = 100;
  int valueB = 100;

  if(valueA > valueB) {
    IO.println(valueA + " ist größer " + valueB);
  } else {
    IO.println(valueB + " ist größer oder gleich " + valueA);
  }

  if(valueA > valueB) {
    IO.println(valueA + " ist größer " + valueB);
  } else if (valueA == valueB) {
    IO.println(valueA + " ist gleich " +  valueB);
  } else {
    IO.println(valueB + " ist größer " + valueA);
  }


  int currentSpeed = 25;

  if(currentSpeed > 70 && currentSpeed < 100) {
    IO.println(currentSpeed + " jetzt wirds kriminell!");
  } else if(currentSpeed > 30 && currentSpeed <= 50) {
    IO.println(currentSpeed + " ist im Ort noch ok");
  } else if(currentSpeed > 50 && currentSpeed <= 70) {
    IO.println(currentSpeed + " das ist nicht ok");
  } else if(currentSpeed <= 30) {
    IO.println(currentSpeed + " ist eine angemessene Geschwindigkeit");
  } else {
    IO.println(currentSpeed + " ist assozial im Ort!");
  }


  IO.println("Ende!");
}