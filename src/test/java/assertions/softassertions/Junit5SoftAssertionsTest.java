package assertions.softassertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.MultipleFailuresError;

public class Junit5SoftAssertionsTest {

    /*

    We could argue about if JUnit 5 supports 'soft' assertions or not
    because it doesn't allow code to be run between assertions.

    But, Junit 5 `assertAll` assertion allows us to group a bunch of
    assertions together, and will check them all, even if some of them
    fail.

    i.e. it does not fail the test on the first failure

    If any of the conditions fail then they are all reported, and the
    test fails with a MultipleFailuresError.

    So it allows a batch of 'soft' assertions.

     */

    @Test
    public void assertAll(){

        String testData = "This Is Test Data";

        Assertions.assertAll("this is a grouping name for the conditions",
                () -> Assertions.assertTrue(testData.startsWith("T")),
                () -> Assertions.assertTrue(testData.endsWith("a")),
                () -> Assertions.assertTrue(testData.contains("D"))
                );
    }

    @Test
    public void assertAllFailing(){

        try {

            String testData = "This Is Test Data";

            Assertions.assertAll("All assertions checked",
                    () -> Assertions.assertTrue(testData.startsWith("Z"),
                            "does not start with z"),
                    () -> Assertions.assertTrue(testData.endsWith("p"),
                            "does not end with p"),
                    () -> Assertions.assertTrue(testData.contains("q"),
                            "does not contain q")
            );

        }catch(MultipleFailuresError e){
            e.printStackTrace();
        }

    }
}


