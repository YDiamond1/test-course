import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;


public class Laba1 {
    public static double func_arccos(double x){
        return Math.acos(x);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/arccos_params_passed.csv", numLinesToSkip = 1)
    public void test_for_arccos_passed(double x, double expected){
        assertEquals(func_arccos(x), expected);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/arccos_params_failed.csv", numLinesToSkip = 1)
    public void test_for_arccos_failed(double x, double expected){
        assertNotEquals(func_arccos(x), expected);
    }
}
