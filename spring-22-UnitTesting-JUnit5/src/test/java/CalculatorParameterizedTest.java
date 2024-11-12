import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {

    //example of @ValueSource(single/array of parameters)
    @ParameterizedTest //(it means the test accepts parameters)
    @ValueSource(strings = {"Java", "JS", "TS"})
    void testCase1(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }


    @ParameterizedTest
    @ValueSource(ints = {3,6,9})
    void testCase1(int num) {
        Assertions.assertEquals(0, num % 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
//    @EmptySource //passes single empty argument to the test // ""
//    @NullSource //passes single null argument to the test
    @NullAndEmptySource ///passes both single empty and null argument
    void testCase3(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }


    @ParameterizedTest
    @MethodSource("stringProvider")// the test receives data from specified method
     // If the method is in different class -> ClassName#stringProvider
    void testCase4(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }

    static String[] stringProvider() {
        return new String[]{"Java", "JS", "TS"};
    }

    //example of using @CsvSource data for the test
    @ParameterizedTest
    @CsvSource({
            "10, 20, 30",
            "20, 20, 40",
            "30, 20, 100"
    })
    void testCase5(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }

    //example of using @CsvFileSource to get the data from a csv file in resources package
    //numLinesToSkip tells to skip num lines in the csv file
    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }






}
