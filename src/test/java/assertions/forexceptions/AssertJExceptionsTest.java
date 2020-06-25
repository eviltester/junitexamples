package assertions.forexceptions;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertJExceptionsTest {

    @Test
    public void assertingExceptions(){

        // AssertJ has a lot of different ways of handling exceptions
        // pick one
        Assertions.assertThatCode(() -> {
            throw new RuntimeException("catch me");
        }).isInstanceOf(RuntimeException.class).
                hasMessage("catch me");

        Assertions.assertThatThrownBy(() -> {
            throw new RuntimeException("catch me");
        }).isInstanceOf(RuntimeException.class).
                hasMessage("catch me");

        Assertions.assertThatExceptionOfType(
                RuntimeException.class).isThrownBy(() -> {
            throw new RuntimeException("catch me");
        }).isInstanceOf(RuntimeException.class).
                withMessage("catch me");
    }

    @Test
    public void genericApproachForAssertingExceptions(){

        try{
            // run code that throws exception
            if(true) {
                throw new RuntimeException("catch me");
            }

            // fail if exception was not thrown
            Assertions.fail("expected exception not thrown");

        }catch(RuntimeException e){

            // assert on the exception details if required
            Assertions.assertThat(e.getMessage()).contains("catch me");
        }
    }


}
