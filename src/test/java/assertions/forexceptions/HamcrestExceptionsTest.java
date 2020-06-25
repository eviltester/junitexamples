package assertions.forexceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestExceptionsTest {

    @Test
    public void assertingExceptions(){

        // Hamcrest does not have built in ways of asserting on exceptions
        // the recommendation is to use try/catch or the mechanism
        // provided by your Test Runner e.g. Junit 4 or Junit 5
        // pick one,

        try{
            throw new RuntimeException("catch me");
        }catch(RuntimeException e){
            assertThat(e.getMessage(), equalTo("catch me"));
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

            // fail if exception was not thrown, using JUnit 5
            Assertions.fail("expected exception not thrown");


        }catch(RuntimeException e){

            // assert on the exception details if required
            assertThat(e.getMessage(), containsString("catch me"));
        }
    }
}
