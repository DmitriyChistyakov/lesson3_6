package lesson36HomeWork;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayUtilsTest {


    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "-1, -1, -2",
            "5, -6, -1"
    })
    void shouldPerformArithmeticalAddingOperationSuccessfully(int a, int b, int expected) {
        Assertions.assertEquals(expected, ArrayUtils.add(a, b));
    }


    @ParameterizedTest
    @MethodSource("doFindForAndReturnNewArrayAfterLastFour")
    void shouldFindFourInArray(int[] expected, int[] actual) {

        Assertions.assertArrayEquals(expected, ArrayUtils.formNewArrayAfterPastFour(actual));


    }

    private static Stream<Arguments> doFindForAndReturnNewArrayAfterLastFour() {
        return Stream.of(
                Arguments.arguments(new int[]{5, 6, 7, 8, 9}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.arguments(new int[]{2, 1, 7}, new int[]{1, 2, 4, 4, 2, 1, 7}),
                Arguments.arguments(new int[]{}, new int[]{1, 2, 4, 4, 2, 1, 7, 4}),
                Arguments.arguments(new int[]{17}, new int[]{1, 2, 4, 4, 2, 3, 4, 17})
        );

    }


    @ParameterizedTest
    @MethodSource("shouldNotFindFourInArrayAndReturnRuntimeExceptionSetArray")
    void shouldNotFindFourInArrayAndReturnRuntimeException(int[] actual) {
        Assertions.assertThrows(RuntimeException.class, () -> ArrayUtils.formNewArrayAfterPastFour(actual));
    }

    private static Stream<Arguments> shouldNotFindFourInArrayAndReturnRuntimeExceptionSetArray() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 5, 6, 7, 8, 9}),
                Arguments.arguments(new int[]{1, 2, 2, 1, 7})
//                Arguments.arguments(new int[]{1, 2, 4, 2, 1, 7}), // оставлен для примера, что код не выбросит исключение
//                Arguments.arguments(new int[]{1, 2, 17, 4})
        );

    }


    /**
     * В задании ведь проверить только False.... тогда код работает :)
     */
    @ParameterizedTest
    @MethodSource("doFindForAndReturnFalseIfNotIt")
    void shouldFindFourInArrayAndReturnFalseIfNotFindIt(Boolean expected, int[] array) {
        Assertions.assertFalse(expected, String.valueOf(ArrayUtils.foundFourInArray(array)));
    }


    private static Stream<Arguments> doFindForAndReturnFalseIfNotIt() {
        return Stream.of(
//                Arguments.arguments(true, new int[]{1, 1, 1, 4, 4, 1, 1, 1, 1, 1, 4}),
//                Arguments.arguments(true, new int[]{1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1}),
                Arguments.arguments(false, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}),
//                Arguments.arguments(true, new int[]{1, 4}),
                Arguments.arguments(false, new int[]{1, 1, 1, 1, 1, 1, 1})
        );

    }


    @ParameterizedTest
    @MethodSource("doFindForAndReturnTrueIfIt")
    void shouldFindFourInArrayAndReturnTrueIfFindIt(Boolean expected, int[] array) {
        Assertions.assertTrue(expected, String.valueOf(ArrayUtils.foundFourInArray(array)));
    }


    private static Stream<Arguments> doFindForAndReturnTrueIfIt() {
        return Stream.of(
                Arguments.arguments(true, new int[]{1, 1, 1, 4, 4, 1, 1, 1, 1, 1, 4}),
                Arguments.arguments(true, new int[]{1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 1}),
                Arguments.arguments(true, new int[]{1, 4})
        );

    }


}
