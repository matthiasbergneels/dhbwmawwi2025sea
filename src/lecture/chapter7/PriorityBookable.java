package lecture.chapter7;

public interface PriorityBookable extends Bookable {

  byte PRIO_1 = 1;
  byte PRIO_2 = 2;
  byte PRIO_3 = 3;

  boolean priorityBooking(byte priority, int slots);

}
