package assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Junit5AssertionsTest {

    // examples of JUnit 5 Assertions.

    @Test
    public void assertions(){

        // assert that a condition is true
        Assertions.assertTrue(true);

        // assert that condition is false
        Assertions.assertFalse(false);

        // equality true assertion can take range of parameter types
        Assertions.assertEquals(true, true);

        // equality false assertion can take range of parameter types
        Assertions.assertNotEquals(true, false);

        // assert object instance is not null
        Assertions.assertNotNull(new Integer(4));

        // assert that an object instance is null
        Integer noInstance=null;
        Assertions.assertNull(noInstance);

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

        // assert that two object instances have the same 'contents'
        // `assertEquals` checks 'contents' `assertSame` is object identity
        List listSameOne = new ArrayList();
        listOne.addAll(aList);
        List listSameTwo = new ArrayList();
        listTwo.addAll(aList);
        Assertions.assertEquals(listSameOne, listSameTwo);

        // asserting on arrays has a special `assertArrayEquals`
        // do not `assertEquals` on array
        int[] array1 = {1,2,3};
        int[] array2 = {1,2,3};
        Assertions.assertArrayEquals(array1, array2);
        Assertions.assertNotEquals(array1,array2);
        Assertions.assertNotSame(array1, array2);

        // test exceptions with assertThrows
        Exception e = Assertions.assertThrows(RuntimeException.class, () -> {
            throw new RuntimeException("catch me");
        });
        Assertions.assertEquals("catch me", e.getMessage());

        //Assertions.assertAll();
        //Assertions.assertDoesNotThrow();
        //Assertions.assertIterableEquals();
        //Assertions.assertLinesMatch();
        //Assertions.assertTimeout();
        //Assertions.assertTimeoutPreemptively();
    }

}
