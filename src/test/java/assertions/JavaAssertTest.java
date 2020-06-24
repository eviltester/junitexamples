package assertions;

import org.junit.jupiter.api.Test;

public class JavaAssertTest {

    /*
        `assert`ions can be enabled or disabled at run time, so might be found in production code
        rather than tests. By default they are disabled at run time.

        to enable:

        - `-enableassertions`, or `-ea`

        to disable:

        - `-disableassertions`, or `-da`

        they can be enabled or disabled on a package by package level

        e.g. `java -ea:com.eviltester.buggycode -jar buggyapp.jar`

     */
    @Test
    public void inbuiltAssertExampleTrue(){
        assert true;
    }

    @Test
    public void inbuiltAssertExampleFalse(){
        try{

            assert false;

        }catch(AssertionError e){
            // when the assert condition evaluates to false
            // then an assertion error is thrown
        }
    }

    @Test
    public void inbuiltAssertExampleWithMessageFalse(){
        try{

            boolean aBooleanCondition = false;

            assert aBooleanCondition : "Message to include in Error";

        }catch(AssertionError e){
            // when the assert condition evaluates to false
            // then an assertion error is thrown where the message
            // is the String we added above

            assert e.getMessage().equals("Message to include in Error") :
                    "Message should have been set in the assertion";
        }
    }
}
