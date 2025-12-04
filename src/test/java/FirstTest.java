import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstTest {
    public String trialCode(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "I";
        } else if (number % 5 == 0) {
            return "F";

        } else if (number % 3 == 0) {
            return "A";
        } else return "T";

    }

    @Test
    public void checkIfatNumber() {
        String actualResult = trialCode(9);
        assertEquals(actualResult, "I", "Ожидалось другое значение");
    }

    @Test
    public void checkIfatFiveNumber() {
        String actualResult = trialCode(25);
        assertEquals(actualResult, "F", "Ожидалось другое значение");
    }

    @Test
    public void checkIfatBothNumber() {
        String actualResult = trialCode(15);
        assertEquals(actualResult, "A", "Ожидалось другое значение");
    }

    @Test
    public void checkIfatNoneNumber() {
        String actualResult = trialCode(19);
        assertEquals(actualResult, "T", "Ожидалось другое значение");
    }
}
