package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlotsException;

public class TravelAgency {

  public static void main(String[] args)  {

    Hotel oneHotel = new Hotel(150);
    Bus flixBus = new Bus(30);
    Bus dbBus = new Bus(50);

    oneHotel.clean();

    IO.println("Freie Zimmer in Hotel One: " + oneHotel.freeSlots());

    Bookable[] bookableObjects = new Bookable[4];
    // Narrowing Cast --> Sichtbarkeit auf Bookable eingeschränkt
    bookableObjects[0] = oneHotel;
    bookableObjects[1] = dbBus;
    bookableObjects[2] = flixBus;
    bookableObjects[3] = new Hotel(100);

    for(Bookable bookableObject : bookableObjects) {
      IO.println("Freie Plätze: " + bookableObject.freeSlots());

      boolean successfullBooking = false;

      try {

        successfullBooking = bookableObject.bookSlots(155);
        IO.println("Freie Plätze: " + bookableObject.freeSlots());
        if(!successfullBooking && bookableObject instanceof PriorityBookable prioBookableObject) {
          prioBookableObject.priorityBooking(PriorityBookable.PRIO_1, 2);
        }

      }catch(NotEnoughFreeSlotsException notEnoughFreeSlotsException){
        IO.println("Buchen fehlgeschlagen - Meldung: " + notEnoughFreeSlotsException.getMessage());
        //notEnoughFreeSlotsException.printStackTrace();
      }catch(Exception exception){ // Catch All
        IO.println("hier ist etwas grundsätzlich schief gegangen: " + exception.getMessage());
        return;
      }finally {
        IO.println("Finally läuft IMMER! - hier bitte alle nebötigten Ressourcen wieder aufräumen");
      }

    }

    IO.println("Jetzt ist die Travel Agency geschlossen!");

  }
}
