package lecture.chapter6;

public class MyLittleFarm {

  public static void main(String[] args) {

    /* --> Animal ist abstract
    Animal myAnimal = new Animal(10.0f, 15.5f, "Karsten");

    myAnimal.breath();
    myAnimal.eat();
    myAnimal.move();
    //myAnimal.bark();
    IO.println(myAnimal.toString());
     */


    Dog myDog = new Dog(76, 70, "Bello", "Schäferhund");

    myDog.breath();
    myDog.eat();
    myDog.eat(0.5f);
    myDog.move();
    myDog.bark();
    IO.println(myDog.toString());

    Bird myBird = new Bird(10, 9, "Tweety", true);

    myBird.breath();
    myBird.eat();
    //myBird.eat(5.5f);
    myBird.move();
    myBird.tweet();
    //myBird.bark();

    IO.println(myBird);

    // Narrowing Cast --> einschränken der Sichbarkeit für das tatsächliche Objekt
    Animal currentAnimal = myDog;

    currentAnimal.move();
    //currentAnimal.bark();

    currentAnimal = myBird;

    currentAnimal.move();

    // Widening Cast --> erweitern der Sichtbarkeit für das tatsächliche Objekt
    Bird currentBird = (Bird)currentAnimal;
    currentBird.move();
    currentBird.tweet();

    /*
    Object currentObject = currentBird;
    Animal currentAnimal2 = (Animal)currentObject;
    Bird currentBird2 = (Bird)currentAnimal2;
     */

    // Dog currentDog = (Dog)currentAnimal; --> Class Cast Exception


    Animal[] animalStable = new Animal[4];

    animalStable[0] = myDog;
    animalStable[1] = myBird;
    animalStable[2] = new Dog(50, 30, "Hasso", "Dogge");
    animalStable[3] = new Bird(6, 4, "Roadrunner", false);

    IO.println("Keep alive routine für Bauer:");
    for(Animal keepAliveAnimal : animalStable) {
      IO.println("Keep alive: " + keepAliveAnimal.getDescription());
      keepAliveAnimal.move();
      keepAliveAnimal.breath();
      keepAliveAnimal.eat();

      if(keepAliveAnimal instanceof Dog) {
        Dog keepAliveDog = (Dog)keepAliveAnimal;
        keepAliveDog.bark();
      } else {
        IO.println(keepAliveAnimal.getDescription() + " ist kein Hund!");
      }

      if(keepAliveAnimal instanceof Fish keepAliveFish) {
        //keepAliveFish.bubble();
      }

    }


    // Alternative ohne Polymorphie

    Dog[] dogStable = new Dog[4];
    Bird[] birdStable = new Bird[4];
    Fish[] fishStable = new Fish[4];

    for(Dog keepAliveDog : dogStable) {
      keepAliveDog.move();
      keepAliveDog.breath();
      keepAliveDog.eat();

      keepAliveDog.bark();
    }

    for(Bird keepAliveBird : birdStable) {
      keepAliveBird.move();
      keepAliveBird.breath();
      keepAliveBird.eat();
    }

    for(Fish keepAliveFish : fishStable) {
      keepAliveFish.move();
      keepAliveFish.breath();
      keepAliveFish.eat();
    }

  }
}
