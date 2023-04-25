package FirstSteps;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatedTestClass {

    static Calculator c;

    @BeforeAll
    static void beforeAll() {
        c = new Calculator();
    }

    @RepeatedTest(3)
    @DisplayName("Normal division")
    public void testDivision_NormalDivison_ExpectNormalBehavior(RepetitionInfo info) {
        // init
        int a = 10;
        int b = 2;
        int expected = 5;

        // run / test
        int d = c.division(a, b);


        // assert

        assertEquals(expected, d);
        assertEquals(info.getCurrentRepetition() , c.numberOfCalculations);

    }

}
