package assertions.softassertions;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.error.AssertJMultipleFailuresError;
import org.junit.jupiter.api.Test;

public class AssertJSoftAssertionsTest {

    /*
        AssertJ's SoftAssertions allows the assertion
        conditions to be checked during the test, with
        the result of the assertion being stored, but
        not stopping the test if it fails.

        And a final call to assertAll triggers a test
        failure if any of the assertions had failed.

        With all of the failures being reported.
     */
    @Test
    public void assertAll(){

        String testData = "This Is Test Data";

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(testData).startsWith("T");
        softly.assertThat(testData).endsWith("a");
        softly.assertThat(testData).contains("D");

        softly.assertAll();
    }

    @Test
    public void assertAllFailing(){

        try {

            String testData = "This Is Test Data";

            SoftAssertions softly = new SoftAssertions();

            softly.assertThat(testData).startsWith("Z").
                    withFailMessage("does not start with z");
            softly.assertThat(testData).endsWith("p").
                    withFailMessage("does not end with p");
            softly.assertThat(testData).contains("q").
                    withFailMessage("does not contain q");

            softly.assertAll();

        }catch(AssertJMultipleFailuresError e){
            e.printStackTrace();
        }

    }
}
