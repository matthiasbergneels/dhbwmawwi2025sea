package lecture.chapter7;

import lecture.chapter8.NotEnoughFreeSlotsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

  @Test
  void bookSlotsLeadingToException() {

    // Arrange
    Hotel hotelUnderTest = new Hotel(150);
    boolean exceptionWasCaught = false;

    // Act
    try {
      hotelUnderTest.bookSlots(hotelUnderTest.freeSlots() + 1);
    } catch (NotEnoughFreeSlotsException e) {
      exceptionWasCaught = true;
    }

    // Assert
    Assertions.assertTrue(exceptionWasCaught);

  }

  @Test
  void bookSlotsLeadingToExceptionAssertThrows() {
    // Arrange
    Hotel hotelUnderTest = new Hotel(150);

    assertThrows(NotEnoughFreeSlotsException.class, new HotelTestExecutableImplementation(hotelUnderTest));
  }

  @Test
  void bookSlotsLeadingToExceptionAssertThrowsWithLambdaFunction() {

    // Arrange
    Hotel hotelUnderTest = new Hotel(150);

    // Act & Assert
    NotEnoughFreeSlotsException e = assertThrows(NotEnoughFreeSlotsException.class, () -> {
      hotelUnderTest.bookSlots(hotelUnderTest.freeSlots()+1);
    });

    assertEquals(hotelUnderTest.freeSlots(), e.getRemainingSlots());
  }

  @Test
  void bookSlotsLeadingNotToExceptionAssertThrowsWithLambdaFunction() {

    // Arrange
    Hotel hotelUnderTest = new Hotel(150);

    // Act & Assert
    assertDoesNotThrow(() -> {
      hotelUnderTest.bookSlots(hotelUnderTest.freeSlots());
    });
  }


}