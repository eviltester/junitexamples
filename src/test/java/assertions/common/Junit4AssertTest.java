package assertions.common;

import org.junit.Assert;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class Junit4AssertTest {

    // examples of JUnit 4 Assert.

    @Test
    public void assertingWithAMessage(){
        Assert.assertTrue("Messages are first argument in JUnit 4", true);
    }

    @Test
    public void assertingTrueAndFalse() {
        // assert that a condition is true
        Assert.assertTrue(true);

        // assert that condition is false
        assertFalse(false);
    }

    @Test
    public void assertingValueEquality() {

        // equality true assertion can take range of parameter types
        Assert.assertEquals(true, true);

        // equality false assertion can take range of parameter types
        Assert.assertNotEquals(true, false);

        List aList = new ArrayList();
        aList.add("Bob");
        aList.add("Connie");

        // assert that two object instances have the same 'contents'
        // `assertEquals` checks 'contents' `assertSame` is object identity
        List listOne = new ArrayList();
        listOne.addAll(aList);
        List listTwo = new ArrayList();
        listTwo.addAll(aList);
        Assert.assertEquals(listOne, listTwo);

        // asserting on arrays has a special `assertArrayEquals`
        // do not `assertEquals` on array
        int[] array1 = {1,2,3};
        int[] array2 = {1,2,3};
        Assert.assertArrayEquals(array1, array2);
        Assert.assertNotEquals(array1,array2);
        Assert.assertNotSame(array1, array2);

    }

    @Test
    public void assertingNull() {
        // assert object instance is not null
        Assert.assertNotNull(new Integer(4));

        // assert that an object instance is null
        Integer noInstance = null;
        Assert.assertNull(noInstance);
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
        Assert.assertSame(myFirstList, mySecondList);

        // assert that two object instances refer to different objects
        List listOne = new ArrayList();
        listOne.addAll(aList);
        List listTwo = new ArrayList();
        listTwo.addAll(aList);
        Assert.assertNotSame(listOne, listTwo);
    }

    @Test(expected = AssertionError.class)
    public void failingATest(){
        Assert.fail(); // causes a test to fail
    }
}
