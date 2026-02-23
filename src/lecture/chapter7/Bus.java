package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlotsException;

public class Bus implements Bookable, FreeSlotsAskable {

  // Belegt = true; Frei = false
  boolean[] seats;

  public Bus(int seatCount) {
    seats = new boolean[seatCount];
    for(int i = 0; i < seatCount; i++) {
      seats[i] = false;
    }
  }

  public void drive(){
    IO.println("Der Bus fährt und fährt und fährt");
  }

  @Override
  public int freeSlots() {
    int freeSlots = 0;
    for(boolean seat : seats) {
      if(!seat) {
        freeSlots++;
      }
    }
    return freeSlots;
  }

  @Override
  public boolean bookSlots(int slots) throws NotEnoughFreeSlotsException {
    if(this.freeSlots() < slots) {
      throw new NotEnoughFreeSlotsException(slots, freeSlots());
    }

    for(int i = 0; i < slots; i++) {
      if(!seats[i]) {
        seats[i] = true;
      }
    }
    return true;
  }
}
