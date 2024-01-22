package inheritance.fromanabstracttest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public abstract class AllTheBehaviours {

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

        By making the base test abstract, it will not be instantiated
        normally or run when the tests are run

        Each test class will override the `getObjectUnderTest` method
        and inherit all the @Test methods so they only have to be run once.

        In IntelliJ if I try to run this test it will instead prompt me to run
        either or all of the Test classes that extend this.

        Similarly when I run this using `mvn test` the `AllTheBehaviours` will not run
        but the `Test` classes which extend it will.
     */
    public MyTextData getObjectUnderTest(){
        return null;
    }

    @Test
    public void canRemoveSpaces(){

        MyTextData td = getObjectUnderTest();

        Assert.assertEquals("therearenospaceshere",
            td.removeSpacesFrom("there are no spaces here"));
    }
}
