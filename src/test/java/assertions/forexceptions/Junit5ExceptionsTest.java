package assertions.forexceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Junit5ExceptionsTest {

    @Test
    public void assertingExceptions(){
        // test exceptions with assertThrows
        Exception e = Assertions.assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("catch me");
        });
        Assertions.assertEquals("catch me", e.getMessage());
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
            Assertions.assertTrue(e.getMessage().contains("catch me"));
        }
    }

    /*
        JUnit 5 also has:

        Assertions.assertAll();
        Assertions.assertDoesNotThrow();

     */
}
