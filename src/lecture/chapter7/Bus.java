package lecture.chapter7;

public class Bus implements Bookable{

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
  public boolean bookSlots(int slots) {
    if(this.freeSlots() < slots) {
      return false;
    }

    for(int i = 0; i < slots; i++) {
      if(!seats[i]) {
        seats[i] = true;
      }
    }
    return true;
  }
}
