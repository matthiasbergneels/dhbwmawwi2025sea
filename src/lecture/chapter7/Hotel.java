package lecture.chapter7;

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
  public boolean bookSlots(int slots) {
    if(freeSlots() < slots) {
      return false;
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
