package lecture.chapter7;

public class TravelAgency {

  public static void main(String[] args) {

    Hotel oneHotel = new Hotel(150);
    Bus flixBus = new Bus(30);
    Bus dbBus = new Bus(50);

    oneHotel.clean();

    IO.println("Freie Zimmer in Hotel One: " + oneHotel.freeSlots());

    Bookable[] bookableObjects = new Bookable[4];
    // Narrowing Cast --> SIchtbarkeit auf Bookable eingeschränkt
    bookableObjects[0] = oneHotel;
    bookableObjects[1] = dbBus;
    bookableObjects[2] = flixBus;
    bookableObjects[3] = new Hotel(200);

    for(Bookable bookableObject : bookableObjects) {
      IO.println("Freie Plätze: " + bookableObject.freeSlots());
      bookableObject.bookSlots(2);
      IO.println("Freie Plätze: " + bookableObject.freeSlots());
    }


  }
}
