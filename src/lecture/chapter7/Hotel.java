package lecture.chapter7;

public class Hotel implements Bookable {

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
}
