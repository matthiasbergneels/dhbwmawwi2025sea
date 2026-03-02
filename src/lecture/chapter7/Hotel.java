package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlotsException;

import java.io.Serializable;

public class Hotel implements PriorityBookable, Serializable, Comparable {

  private int roomCount;
  private int bookedRoomCount;

  public Hotel(int roomCount) {
    this.roomCount = roomCount;
    bookedRoomCount = 0;
  }

  public void clean(){
    IO.println("Cleaning hotel...");
  }

  @Override
  public int freeSlots() {
    return roomCount - bookedRoomCount;
  }

  @Override
  public boolean bookSlots(int slots) throws NotEnoughFreeSlotsException{

    /*
    if(slots == 151) {
      throw new NullPointerException("Not enough free slots");
    }

     */

    if(freeSlots() < slots) {
      var notEnoughFreeSlotsException = new NotEnoughFreeSlotsException(slots, freeSlots());
      throw notEnoughFreeSlotsException;
    }

    bookedRoomCount += slots;

    return true;
  }

  @Override
  public int compareTo(Object o) {
    return 0;
  }

  @Override
  public boolean priorityBooking(byte priority, int slots) {
    return false;
  }
}
