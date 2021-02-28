import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

class ACosTest {

    @ParameterizedTest
    @CsvFileSource(resources = ["/arccos_params_passed.csv"], numLinesToSkip = 1)
    fun test_for_arccos_passed(x: Double, expected: Double) {
        Assertions.assertEquals( expected,Fun.acos(x), Fun.precision)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/arccos_params_failed.csv"], numLinesToSkip = 1)
    fun test_for_arccos_failed(x: Double, expected: Double) {
        Assertions.assertNotEquals( expected, Fun.acos(x), Fun.precision)
    }


}
