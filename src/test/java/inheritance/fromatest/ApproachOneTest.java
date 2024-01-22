package inheritance.fromatest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ApproachOneTest {

    /*
        Most examples for inheritence in testing are the use of a Base test class
        for common BeforeAll and AfterAll functions

        Another very useful approach is to have a set of @Test methods
        that you want to apply to multiple type of objects e.g.

        - run the same tests locally and on dev
        - run the same tests on different database types
        - run the same tests on a system with slightly different configuration

        In this example I have two objects that implement the same interface
        and they are supposed to do the same thing. But they take different
        approaches to the implementation.

        By extending this class and overriding the `getObjectUnderTest` method
        I can write one set of tests and apply them to the different approaches.
     */
    public MyTextData getObjectUnderTest(){
        return new TextDataApproachOne();
    }

    @Test
    public void canRemoveSpaces(){

        MyTextData td = getObjectUnderTest();

        Assert.assertEquals("therearenospaceshere",
            td.removeSpacesFrom("there are no spaces here"));
    }
}
