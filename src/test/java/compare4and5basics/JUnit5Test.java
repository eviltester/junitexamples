package compare4and5basics;

import org.junit.jupiter.api.*;
import java.io.IOException;


/**
Read about the basic differences between JUnit 4 and 5:

@see <a href="https://github.com/eviltester/junitexamples/tree/master/src/test/java/compare4and5basics">https://github.com/eviltester/junitexamples/tree/master/src/test/java/compare4and5basics</a>
*/
// Can use @TestInstance(Lifecycle.PER_CLASS) if we want @BeforeAll and @AfterAll methods to NOT be static
// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JUnit5Test {

    @BeforeAll
    public static void runsBeforeEverything(){
        System.out.println("Running a Test Class");
    }

    @BeforeEach
    public void runsBeforeEveryMethod(){
        System.out.println("Running a Test Method");
    }

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

    @Test
    public void shouldThrowAnCheckedException(){
        Exception exception = Assertions.assertThrows(IOException.class, () -> {
            throw new IOException("We interrupt this test to throw an checked exception");
        });

        // can continue to do more assertions on the exception
        System.out.println(exception.getMessage());
        Assertions.assertEquals("We interrupt this test to throw an checked exception",
                                exception.getMessage());
    }

    @Test
    public void shouldThrowAnRuntimeException(){
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            throw new NullPointerException("We interrupt this test to throw an runtime exception");
        });

        // can continue to do more assertions on the exception
        System.out.println(exception.getMessage());
        Assertions.assertEquals("We interrupt this test to throw an runtime exception",
                exception.getMessage());
    }

    @AfterEach
    public void runsAfterEveryMethod(){
        System.out.println("Finished Running a Test Method");
    }

    @AfterAll
    public static void runsAfterEverything(){
        System.out.println("Finished Running a Test Class");
    }

}


