package lecture.chapter6;

public class MyLittleFarm {

  public static void main(String[] args) {

    Animal myAnimal = new Animal(10.0f, 15.5f, "Jannes");

    myAnimal.breath();
    myAnimal.eat();
    myAnimal.move();
    //myAnimal.bark();


    Dog myDog = new Dog(76, 70, "Bello", "Schäferhund");

    myDog.breath();
    myDog.eat();
    myDog.eat(0.5f);
    myDog.move();
    myDog.bark();

    Bird myBird = new Bird(10, 9, "Tweety", true);

    myBird.breath();
    myBird.eat();
    //myBird.eat(5.5f);
    myBird.move();
    myBird.tweet();
    //myBird.bark();


  }
}
