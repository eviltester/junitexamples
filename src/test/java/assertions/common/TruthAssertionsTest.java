package assertions.common;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class TruthAssertionsTest {

    /*
     Basic examples of Google Truth assertion usage.

     Like AssertJ, Truth also has a top level `assertThat`
     factory method.

     And a `assertWithMessage` for changing the method written out.

     Both of these wrap `Truth.assert_()`

     For general fluent code statically import the method `assertThat`

     e.g. `assertThat` rather than `Assertions.assertThat`

     It is possible to write `Truth.assertThat` but
     the code doesn't flow for readability as well.

     Useful to compare Truth code with AssertJ code.

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
        assertWithMessage("Messages are added as first arg in Truth").
                that(true).isTrue();

        Truth.assert_().withMessage("Messages are fluently with base chaining method").
                that(true).isTrue();
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
        assertThat(array1).isNotSameInstanceAs(array2);
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
        assertThat(myFirstList).isSameInstanceAs(mySecondList);

        // assert that two object instances refer to different objects
        List listOne = new ArrayList();
        listOne.addAll(aList);
        List listTwo = new ArrayList();
        listTwo.addAll(aList);
        assertThat(listOne).isNotSameInstanceAs(listTwo);
    }



    @Test
    public void failingATest() {
        try {

            Truth.assert_().fail();

        }catch(AssertionError e){
            /*
                NOTE: this hints at another way to use Truth
             */
        };
    }

    /*
        So much more to cover for Truth.

        Has a slightly less expansive interface than AssertJ and designed
        to handle lower versions of Java e.g. as found on some Android
        devices.

        May prove simpler to use, but since it is a fluent interface
        is fairly easy to explore.

        Using an external assertion library might make it easier to switch between
        JUnit 4, Junit 5 or TestNG or any other test runner framework you want to use.
     */
}
