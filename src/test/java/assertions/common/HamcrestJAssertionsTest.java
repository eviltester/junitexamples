package assertions.common;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class HamcrestJAssertionsTest {

    /*
     Basic examples of Hamcrest assertion usage.

     Since AssertJ has a top level `assertThat`
     factory method.

     It seems to make code more fluent to statically
     import the method `assertThat`

     e.g. `assertThat` rather than `MatcherAssert.assertThat`

     It is possible to write `MatcherAssert.assertThat` but
     the code doesn't flow for readability as well.

     Hamcrest does not use method chaining for fluency, so you
     have to also statically import `is` and various other classes
     which means you have to remember more, but the code has more
     spaces and reads more like English language sentences.

     You can save your memory by statically importing the core
     matchers and code completion helps more:

     ~~~~~~~~
     import static org.hamcrest.CoreMatchers.*;
     ~~~~~~~~

     */

    @Test
    public void assertingTrueAndFalse() {
        // assert that a condition is true
        assertThat(true, is(equalTo(true)));

        // assert that condition is false
        // Note: the 'is' is syntactic sugar and aids
        // readability but is not actually required
        assertThat(false, equalTo(false));
    }

    @Test
    public void assertingWithAMessage(){
        assertThat("true should be true",
                true, is(equalTo(true)));
    }

    @Test
    public void assertingValueEquality() {
        // equality true assertion can take range of parameter types
        assertThat(true, is(equalTo(true)));

        // equality false assertion can take range of parameter types
        assertThat(true, is(not(equalTo(false))));


        List aList = new ArrayList();
        aList.add("Bob");
        aList.add("Connie");

        // assert that two object instances have the same 'contents'
        // `assertEquals` checks 'contents' `assertSame` is object identity
        List listOne = new ArrayList();
        listOne.addAll(aList);
        List listTwo = new ArrayList();
        listTwo.addAll(aList);
        assertThat(listOne, is(equalTo(listTwo)));


        // asserting on arrays has a special `assertArrayEquals`
        // do not `assertEquals` on array
        int[] array1 = {1,2,3};
        int[] array2 = {1,2,3};
        assertThat(array1, is(equalTo(array2)));
        assertThat(array1, is(not(sameInstance(array2))));
    }

    @Test
    public void assertingNull() {
        // assert object instance is not null
        assertThat(new Integer(4), is(notNullValue()));
        assertThat(new Integer(4), is(not(equalTo(null))));
        assertThat(new Integer(4), is(not(nullValue())));

        // assert that an object instance is null
        Integer noInstance=null;
        assertThat(noInstance, is(equalTo(null)));
        assertThat(noInstance, is(nullValue()));
    }

    @Test
    public void assertingInstanceEquality() {
        List aList = new ArrayList();
        aList.add("Bob");
        aList.add("Connie");

        // assert that two object instances refer to the exact same object
        List myFirstList = new ArrayList();
        myFirstList.addAll(aList);
        List mySecondList = myFirstList;
        assertThat(myFirstList, is(sameInstance(mySecondList)));

        // assert that two object instances refer to different objects
        List listOne = new ArrayList();
        listOne.addAll(aList);
        List listTwo = new ArrayList();
        listTwo.addAll(aList);
        assertThat(listOne, is(not(sameInstance(listTwo))));
    }


    @Test
    public void failingATest() {
        try{

            // Hamcrest does not provide a 'fail' mechanism
            // you would normally use the Test Runner Framework
            // Some people use matchers that are guaranteed to fail,
            // e.g. true, equalTo(false)
            // with a message
            assertThat("`fail` causes a test to fail",anything(), is(not(anything())));

        }catch(AssertionError e){

            assertThat(e.getMessage(), containsString("`fail` causes a test to fail"));
        }
    }

    /*
        So much more to cover for Hamcrest

        It is a fluent interface but I find it less easy to
        explore than AssertJ or Truth.

        So the documenation is essential:

        http://hamcrest.org/JavaHamcrest

        Why use it? Because the failure messages can be very
        readable without adding any descriptions.

     */
}
