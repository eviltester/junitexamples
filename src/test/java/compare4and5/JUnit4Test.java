package compare4and5;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class JUnit4Test {

    /*
        Basic difference between JUnit 4 and JUnit 5

        Marking Tests as Ignored:

        - Junit 4 uses @Ignore
        - Junit 5 uses @Disabled

        Assertions are statically accessed from:

        - JUnit 4 uses `Assert.`
        - Junit 5 uses `Assertions.`

        Assertion message position differs:

        - JUnit 4 assertion messages are the first argument
        - JUnit 5 assertion messages are the last argument

        TODO: @Before, @BeforeClass, @After, @AfterClass
     */

    @Test
    public void aTestMethodAssertingTrue(){
        Assert.assertTrue(true);
    }

    @Test
    public void aTestMethodAssertingEquals(){
        String expected = "bob";
        Assert.assertEquals(expected, "bob");
    }

    @Test
    public void aTestMethodAssertingWithMessage(){
        String expected = "bob";
        Assert.assertEquals("Because we always expect bob", expected, "bob");
    }

    @Ignore("because if this ran it would fail")
    @Test
    public void anIgnoredDisabledTest(){
        Assert.assertFalse(true);
    }
}
