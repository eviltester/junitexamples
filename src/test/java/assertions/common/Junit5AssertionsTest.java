package assertions.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Junit5AssertionsTest {

    // examples of JUnit 5 Assertions.

    @Test
    public void assertingWithAMessage(){
        Assertions.assertTrue(true, "Messages are last argument in JUnit 5");
    }

    @Test
    public void assertingTrueAndFalse() {
        // assert that a condition is true
        Assertions.assertTrue(true);

        // assert that condition is false
        Assertions.assertFalse(false);
    }

    @Test
    public void assertingValueEquality() {
        // equality true assertion can take range of parameter types
        Assertions.assertEquals(true, true);

        // equality false assertion can take range of parameter types
        Assertions.assertNotEquals(true, false);

        List aList = new ArrayList();
        aList.add("Bob");
        aList.add("Connie");

        // assert that two object instances have the same 'contents'
        // `assertEquals` checks 'contents' `assertSame` is object identity
        List listOne = new ArrayList();
        listOne.addAll(aList);
        List listTwo = new ArrayList();
        listTwo.addAll(aList);
        Assertions.assertEquals(listOne, listTwo);

        // asserting on arrays has a special `assertArrayEquals`
        // do not `assertEquals` on array
        int[] array1 = {1,2,3};
        int[] array2 = {1,2,3};
        Assertions.assertArrayEquals(array1, array2);
        Assertions.assertNotEquals(array1,array2);
        Assertions.assertNotSame(array1, array2);
    }

    @Test
    public void assertingNull() {
        // assert object instance is not null
        Assertions.assertNotNull(new Integer(4));

        // assert that an object instance is null
        Integer noInstance=null;
        Assertions.assertNull(noInstance);

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
        Assertions.assertSame(myFirstList, mySecondList);

        // assert that two object instances refer to different objects
        List listOne = new ArrayList();
        listOne.addAll(aList);
        List listTwo = new ArrayList();
        listTwo.addAll(aList);
        Assertions.assertNotSame(listOne, listTwo);
    }


    @Test
    public void failingATest() {
        Assertions.assertThrows(AssertionError.class, () -> {

            Assertions.fail(); // causes a test to fail

        });
    }

    /*

        Assertions.assertIterableEquals();
        Assertions.assertLinesMatch();
        Assertions.assertTimeout();
        Assertions.assertTimeoutPreemptively();

     */

}
