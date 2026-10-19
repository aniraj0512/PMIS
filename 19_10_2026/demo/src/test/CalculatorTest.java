import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    @Test
    void addsTwoNumbers() {
        Calculator calc = new Calculator();

        int result = calc.add(2, 3);

        assertEquals(5, result); // Checks whether 2 + 3 = 5
    }

    @Test
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        assertThrows(
            IllegalArgumentException.class,
            () -> calc.divide(10, 0)
        );
    }
}