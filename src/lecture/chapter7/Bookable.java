package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlotsException;

public interface Bookable {

  int freeSlots();
  boolean bookSlots(int slots) throws NotEnoughFreeSlotsException;

  default boolean reserveSlots(int slots){
    return false;
  }

}
