package assertions.forexceptions;

import org.junit.Assert;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

public class JUnit4ExceptionsTest {

    @Test
    public void assertingExceptions(){

        // v 4.13 of JUnit 4 adds the assertThrows found in JUnit 5
        // which takes a lambda
        // test exceptions with assertThrows or the expected argument on @Test annotation
        Exception e = Assert.assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("catch me");
        });
        Assert.assertEquals("catch me", e.getMessage());

        // or ThrowableRunnable
        Exception e2 = Assert.assertThrows(RuntimeException.class,
                new ThrowingRunnable() {
                    @Override
                    public void run() throws Throwable {
                        throw new RuntimeException("catch me too");
                    }
                });
        Assert.assertEquals("catch me too", e2.getMessage());
    }

    @Test
    public void genericApproachForAssertingExceptions(){

        try{
            // run code that throws exception
            if(true) {
                throw new RuntimeException("catch me");
            }

            // fail if exception was not thrown
            Assert.fail("expected exception not thrown");

        }catch(RuntimeException e){

            // assert on the exception details if required
            Assert.assertTrue(e.getMessage().contains("catch me"));
        }
    }

    // JUnit4 offers a test annotation
    // that other abstraction layers do not
    @Test(expected = RuntimeException.class)
    public void assertUsingAnnotation(){
        throw new RuntimeException("catch me");
    }

    /*
        JUnit @Rule for exception testing was deprecated in v 4.13

        https://github.com/junit-team/junit4/wiki/Exception-testing#expectedexception-rule

        @Rule
        public ExpectedException expected = ExpectedException.none();

        @Test
        public void failsWithException(){

            expected.expect(RuntimeException.class);
            expected.expectMessage("catch me");
            throw new RuntimeException("catch me");
        }

     */

}
