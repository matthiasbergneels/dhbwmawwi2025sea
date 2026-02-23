package lecture.excursion.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

  Calculator testCalc;

  @BeforeAll
  static void setUpBeforeClass(){
    IO.println("CalculatorTest BeforeAll - Arrange für alle Tests");
  }

  @AfterAll
  static void tearDownAfterClass(){
    IO.println("CalculatorTest After All - clean up für alle Tests");
  }

  @BeforeEach
  void setup(){
    IO.println("CalculatorTest BeforeEach - Arrange für die Tests");
    testCalc = new Calculator();
  }

  @AfterEach
  void tearDown(){
    IO.println("CalculatorTest AfterEach - clean up für die Tests");
    testCalc = null;
  }

  @Nested
  class AddTestCases {

    @Tag("local")
    @RepeatedTest(5)
    void add() {
      IO.println("basic add test");

      // Arrange


      // Act
      double result = testCalc.add(1, 2);

      // Assert
      Assertions.assertEquals(3, result);

    }

    @Test
    @Tag("local")
    @DisplayName("add Test with Double Literals")
    void addWithDoubleLiterals() {
      IO.println("double literls add test");

      // Arrange


      // Act
      double result = testCalc.add(55.5, 1.5);

      // Assert
      Assertions.assertEquals(57.0, result);

    }

    @Test
    @Tag("integration")
    void addWithbigNumbers() {
      IO.println("big number add test");

      // Arrange


      // Act
      double result = testCalc.add(2_000_000_000, 1.5);

      // Assert
      Assertions.assertEquals(2000000001.5, result);

    }
  }

  @Nested
  class SubtractTestCases {

    @BeforeEach
    void setUp(){
      IO.println("CalculatorTest BeforeEach - Arrange für alle Tests IN SUBTRACT");
    }

    @AfterEach
    void tearDown(){
      IO.println("CalculatorTest AfterEach - clean up für alle Tests IN SUBTRACT");
    }

    @ParameterizedTest(name="{0} minus {1} should be {2}")
    @Tag("local")
    @CsvSource({"3,2,1",
                "5,3,2",
                "-5.0,3.0,-8.0",
                "5.0,3.0,2"})
    void subtract(double numberA, double numberB,  double expectedResult) {
      IO.println("basic subtract test");
      double result = testCalc.subtract(numberA, numberB);
      Assertions.assertEquals(expectedResult, result);
    }
  }
}