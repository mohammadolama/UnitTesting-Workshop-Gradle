package FirstSteps;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    static Calculator c;
    static ArrayList<Integer> list;
    @BeforeEach
    void setUp() {
        System.out.println("Run before each test");
        list = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        System.out.println("run after each tests");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Run before all tests!");
        c = new Calculator();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Run after all tests");
    }

    @ParameterizedTest
    @DisplayName("Normal division")
    @MethodSource("normalSource")
    public void testDivision_NormalDivison_ExpectNormalBehavior(int a , int b , int expected) {

        // run / test
        int d = c.division(a, b);


        // assert

        assertEquals(expected, d);

    }

    private static Stream<Arguments> normalSource(){
        return Stream.of(
                Arguments.of(9 , 3 , 3),
                Arguments.of(10 ,2 , 5),
                Arguments.of(10 ,-2 , -5),
                Arguments.of(-10 ,-2 , 5)
        );
    }

    @ParameterizedTest
    @DisplayName("Check floor")
    @CsvSource({
            "5, 2, 2",
            "10, 5, 2",
            "-7, 3, -2"

    })
    public void testDivision_NormalDivision_ExpectFloor(int a , int b , int expected){
        int result = c.division(a , b);
        assertEquals(expected , result);
    }

    @ParameterizedTest
    @DisplayName("Division by zero")
    @CsvFileSource(resources = "/divisionByZero.csv")
    public void testDivision_DivisionByZero_ExpectException(int a){
        assertThrows(ArithmeticException.class,
                () -> c.division(a, 0),
                "Unexpected Error!"
        );
    }

    @Test
    void arrayDivision() {

        // init
        int[] a = new int[]{10 , 3 , 8};
        int[] b = new int[]{2 , 1 , 10};
        int[] expected = new int[]{5 , 3 , 0};

        // test
        int[] ints = c.arrayDivision(a, b);


        // assert

        assertEquals(expected.length , ints.length);
        assertArrayEquals(expected , ints);

    }
}