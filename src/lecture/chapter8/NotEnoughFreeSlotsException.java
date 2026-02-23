package lecture.chapter8;

public class NotEnoughFreeSlotsException extends Exception {

  private int remainingSlots;

  public NotEnoughFreeSlotsException(int bookedSlots, int remainingSlots) {
    super("Not enough free slots to book: tried to book " + bookedSlots + " but only " + remainingSlots + " remaining");
    this.remainingSlots = remainingSlots;
  }
}
