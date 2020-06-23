package coverageexample;

import org.junit.Assert;
import org.junit.Test;


public class CoverageJUnit4Test {

    @Test
    public void coverageTestLessThan(){
        Assert.assertEquals(-1, new CoverMeWithJUnit4Tests(10,20).evaluate(9));
    }

    @Test
    public void coverageTestMoreThan(){
        Assert.assertEquals(1, new CoverMeWithJUnit4Tests(10,20).evaluate(21));
    }

    @Test
    public void coverageTestMid(){
        Assert.assertEquals(0, new CoverMeWithJUnit4Tests(10,20).evaluate(11));
    }

    @Test
    public void coverageTestLowerLimit(){
        Assert.assertEquals(10, new CoverMeWithJUnit4Tests(10,20).evaluate(10));
    }

    @Test
    public void coverageTestUpperLimit(){
        Assert.assertEquals(20, new CoverMeWithJUnit4Tests(10,20).evaluate(20));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativityGivesException(){
        new CoverMeWithJUnit4Tests(10,20).evaluate(-1);
    }
}
