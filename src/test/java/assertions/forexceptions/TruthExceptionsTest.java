package assertions.forexceptions;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class TruthExceptionsTest {

    @Test
    public void assertingExceptions(){

        // Google Truth does not have built in ways of exceptions
        // the recommendation is to use try/catch or the mechanism
        // provided by your Test Runner e.g. Junit 4 or Junit 5
        // pick one,

        try{
            throw new RuntimeException("catch me");
        }catch(RuntimeException e){
            assertThat(e).hasMessageThat().isEqualTo("catch me");
        }

        // and see the JUnit 4 or JUnit 5 examples
    }

    @Test
    public void genericApproachForAssertingExceptions(){

        try{
            // run code that throws exception
            if(true) {
                throw new RuntimeException("catch me");
            }

            // fail if exception was not thrown
            Truth.assert_().withMessage("expected exception not thrown").fail();


        }catch(RuntimeException e){

            // assert on the exception details if required
            assertThat(e.getMessage()).contains("catch me");
            assertThat(e).hasMessageThat().contains("catch me");
        }
    }
}
