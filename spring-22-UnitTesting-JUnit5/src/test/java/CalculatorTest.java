import org.junit.jupiter.api.*;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    //example of using @BeforeAll(must be static):
    @BeforeAll
    static void setUpAll() {
        System.out.println("BeforeAll is executed.");
    }

    //example of using @AfterAll(must be static):
    @AfterAll
    static void tearDownAll() {
        System.out.println("AfterAll is executed.");
    }


    //example of using @BeforeEach:
    @BeforeEach
    void setUpEach() {
        System.out.println("BeforeEach is executed.");
    }

    //example of using @AfterEach:
    @AfterEach
    void tearDownEach() {
        System.out.println("AfterEach is executed.");
    }


    @Test
    @DisplayName("MyMethod")//we can give another name for the method in the execution result
    void add() {
        //example of using assertEquals:
        System.out.println("Add method");
        int actual = Calculator.add(2, 3);
        assertEquals(5, actual, "Test failed.");
    }

    @Test
    void add2() {
        System.out.println("Add2 method");
        //example of using assertThrows:

//        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(3, 2));
//        assertThrows(AccessDeniedException.class, () -> Calculator.add2(3, 2));
        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(2, 3));
    }

    @Test
    void testCase1() {
//        System.out.println("Test Case 1");
//        example of failing the method
        fail("Not implemented yet.");
    }

    @Test
    void testCase2() {
        System.out.println("Test Case 2");
        //example of using assertTrue:
        assertEquals("add", Calculator.operator);
        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void testCase3() {
        System.out.println("Test Case 3");
        //example of using assertArrayEquals:
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 3, 2}, "Arrays are not same.");

    }

    @Test
    void testCase4() {
        System.out.println("Test Case 4");
        //example of using assertNull and notNullString:
        String nullString = null;
        String notNullString = "Cydeo";

        assertNull(nullString);
        assertNotNull(notNullString);

//        assertNull(notNullString);
        assertNotNull(nullString);
    }

    @Test
    void testCase5() {

        System.out.println("Test Case 5");
        //example of using assertSame and assertNotSame:
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1, c2);
        assertNotSame(c1, c3);


    }
}