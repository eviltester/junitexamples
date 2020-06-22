package compare4and5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class JUnit5Test {

    @Test
    public void aTestMethodAssertingTrue(){
        Assertions.assertTrue(true);
    }

    @Test
    public void aTestMethodAssertingEquals(){
        String expected = "bob";
        Assertions.assertEquals(expected, "bob");
    }

    @Test
    public void aTestMethodAssertingWithMessage(){
        String expected = "bob";
        Assertions.assertEquals(expected, "bob", "Because we always expect bob");
    }

    @Disabled("because if this ran it would fail")
    @Test
    public void anIgnoredDisabledTest(){
        Assertions.assertFalse(true);
    }

}


