package coverageexample;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoverageJUnit5Test {

    @Test
    public void coverageTestLessThan(){
        Assertions.assertEquals(-1, new CoverMeWithJUnit5Tests(10,20).evaluate(9));
    }

    @Test
    public void coverageTestMoreThan(){
        Assertions.assertEquals(1, new CoverMeWithJUnit5Tests(10,20).evaluate(21));
    }

    @Test
    public void coverageTestMid(){
        Assertions.assertEquals(0, new CoverMeWithJUnit5Tests(10,20).evaluate(11));
    }

    @Test
    public void coverageTestLowerLimit(){
        Assertions.assertEquals(10, new CoverMeWithJUnit5Tests(10,20).evaluate(10));
    }

    @Test
    public void coverageTestUpperLimit(){
        Assertions.assertEquals(20, new CoverMeWithJUnit5Tests(10,20).evaluate(20));
    }

    @Test
    public void negativityGivesException(){
        final IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CoverMeWithJUnit5Tests(10, 20).evaluate(-1);
                }
        );

        Assertions.assertEquals("No negativity please", exception.getMessage());
    }
}
