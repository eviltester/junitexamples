package assertions.common;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class AssertJAssertionsTest {

    /*
     Basic examples of AssertJ assertion usage.

     Since AssertJ has a top level `assertThat`
     factory method (and some others).

     It seems to make code more fluent to statically
     import the method `assertThat`

     e.g. `assertThat` rather than `Assertions.assertThat`

     It is possible to write `Assertions.assertThat` but
     the code doesn't flow for readability as well.

     Other, less used assertions, might be easier to use
     with `Assertions.` then using code completion to
     create the assertion.
     */

    @Test
    public void assertingTrueAndFalse() {
        // assert that a condition is true
        assertThat(true).isTrue();

        // assert that condition is false
        assertThat(false).isFalse();
    }

    @Test
    public void assertingWithAMessage(){
        assertThat(true).
                isTrue().
                withFailMessage("Messages are added fluently in AssertJ");
    }

    @Test
    public void assertingValueEquality() {
        // equality true assertion can take range of parameter types
        assertThat(true).isEqualTo(true);

        // equality false assertion can take range of parameter types
        assertThat(true).isNotEqualTo(false);


        List aList = new ArrayList();
        aList.add("Bob");
        aList.add("Connie");

        // assert that two object instances have the same 'contents'
        // `assertEquals` checks 'contents' `assertSame` is object identity
        List listOne = new ArrayList();
        listOne.addAll(aList);
        List listTwo = new ArrayList();
        listTwo.addAll(aList);
        assertThat(listOne).isEqualTo(listTwo);


        // asserting on arrays has a special `assertArrayEquals`
        // do not `assertEquals` on array
        int[] array1 = {1,2,3};
        int[] array2 = {1,2,3};
        assertThat(array1).isEqualTo(array2);
        assertThat(array1).isNotSameAs(array2);
    }

    @Test
    public void assertingNull() {
        // assert object instance is not null
        assertThat(new Integer(4)).isNotNull();

        // assert that an object instance is null
        Integer noInstance=null;
        assertThat(noInstance).isNull();
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
        assertThat(myFirstList).isSameAs(mySecondList);

        // assert that two object instances refer to different objects
        List listOne = new ArrayList();
        listOne.addAll(aList);
        List listTwo = new ArrayList();
        listTwo.addAll(aList);
        assertThat(listOne).isNotSameAs(listTwo);
    }


    @Test
    public void failingATest() {
        Assertions.assertThatCode(() -> {

            Assertions.fail("`fail` causes a test to fail");

        }).isInstanceOf(AssertionError.class);
    }

    /*
        So much more to cover for AssertJ

        But since it is a fluent interface is fairly easy to explore.

        `Assertions.` then see what top level methods there are.

        Then fluently build up the assertion until you have what you need.

        I think the fluent interface makes AssertJ easy to use, but you may not
        need the flexibility that it brings.

        Using an external assertion library might make it easier to switch between
        JUnit 4, Junit 5 or TestNG or any other test runner framework you want to use.
     */
}
