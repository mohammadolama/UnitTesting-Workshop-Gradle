package FirstSteps;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {

    @Test
    @Order(4)
    public void testA(){
        System.out.println("This is test A");
    }

    @Test
    @Order(1)
    public void testC(){
        System.out.println("This is test C");
    }

    @Test
    @Order(3)
    public void testB(){
        System.out.println("This is test B");
    }

    @Test
    @Order(2)
    public void testD(){
        System.out.println("This is test D");
    }

    @Test
    public void secondTest() {
        System.out.println("This is test 2");
    }

    @Test
    @Order(0)
    public void thirdTest() {
        System.out.println("This is test 3");
    }

    @Test
    public void firstTest() {
        System.out.println("This is test 1");
    }
}
