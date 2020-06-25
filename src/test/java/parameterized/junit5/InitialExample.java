package parameterized.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InitialExample {

    // https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests

    // initial code based on my other projects

    @ParameterizedTest
    // @ValueSource allows us to pass in an array of values e.g. strings, ints, longs, floats, etc.
    // but we can only pass in one argument to the test method
    @ValueSource(strings = {"bob", "connie", "including", "announcement"})
    void wordLengthMustBeMultipleOfThree(String word) {
        Assertions.assertEquals(0, word.length()%3,
                word + " should be length multiple of 3");
    }

    // strings, ints, longs, floats, etc.
    @DisplayName("Word Length Needs To Be a Multiple of Three")
    @ParameterizedTest(name = "checking word {0}")
    @ValueSource(strings = {"bob", "connie", "including", "announcement"})
    void wordLengthMustReallyBeMultipleOfThree(String word) {
        Assertions.assertEquals(0, word.length()%3,
                word + " should be length multiple of 3");
    }

    // @EnumSource, names =, EnumSource.Mode.

    // @CsvSource allows multiple arguments to test method with defined delimiter
    // @CsvFileSource allows csv files


    static IntStream canPassInParamsToTestFromDefaultMethod() {
        return IntStream.rangeClosed(-5, 5);
    }

    @ParameterizedTest(name = "using version {0}")
    @MethodSource   // default to method named same as test method
    public void canPassInParamsToTestFromDefaultMethod(int version){

        System.out.println("running test with param version = " + version);
        Assertions.assertTrue(version >= -5 && version <= 5);

    }


    static IntStream versions() {
        return IntStream.rangeClosed(1, 10);
    }


    @ParameterizedTest(name = "using version {0} \"?v={0}\"")
    @MethodSource("versions") // where is the data coming from
    public void canPassInParamsToTest(int version){

        System.out.println("running test with param version = " + version);
        Assertions.assertTrue(version >= 1 && version <= 10);

    }

    static Stream versionCombos() {
        List<Arguments> args = new ArrayList<>();

        for(int getversion=1; getversion<= 5; getversion++){
            for(int version=11; version<= 15; version++){
                args.add(Arguments.of(getversion, version));
            }
        }
        return args.stream();
    }

    @ParameterizedTest(name = "using combo getversion {0} and check version {1}")
    @MethodSource("versionCombos")
    public void canPassInMultipleParamsToTest(int getversion, int checkversion){
        System.out.println(
                String.format(
                        "running test with param getversion = %d and checkversion = %d"
                        , getversion, checkversion));

        Assertions.assertTrue(getversion >= 1 && getversion <= 5);
        Assertions.assertTrue(checkversion >= 11 && checkversion <= 15);
    }



    /*

        Can't imagine ever using @NullSource or @EmptySource I think I would hard code null in the test
     */
}
