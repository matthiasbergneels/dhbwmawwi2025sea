package lecture.chapter7;

import org.junit.jupiter.api.function.Executable;

public class HotelTestExecutableImplementation implements Executable {

  private Hotel hotelUnderTest;

  public HotelTestExecutableImplementation(Hotel hotelUnderTest) {
    this.hotelUnderTest = hotelUnderTest;
  }

  @Override
  public void execute() throws Throwable {

    hotelUnderTest.bookSlots(hotelUnderTest.freeSlots()+1);

  }
}
