package parameterized.junit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
    It is possible to add extra dependencies with JUnit 4 to improve parameterized
    tests. To bring it closer to JUnit 5 functionality
    e.g. reading CSV, different test data for different tests in the class

    - http://pragmatists.github.io/JUnitParams/
    - https://github.com/Pragmatists/junitparams

    (above not updated since 2017)

 */

@RunWith(Parameterized.class)
public class ParameterizedJunit4ExampleTest {

    private final int getversion;
    private final int checkversion;

    //without the 'name' we just see an 'index' for the test run
    // name was added in version 4.11
    //@Parameterized.Parameters
    @Parameterized.Parameters(name = "using combo getversion {0} and check version {1}")
     public static Collection<Object[]> versionCombos() {

        // this method can read from files etc,
        // so long as it returns a Collection of Object arrays

        List<Object[]> args = new ArrayList<>();

        for(int getversion=1; getversion<= 5; getversion++){
            for(int version=11; version<= 15; version++){
                args.add(new Object[]{getversion, version});
            }
        }
        return args;
    }

    public ParameterizedJunit4ExampleTest(int getversion, int checkversion){
        this.getversion = getversion;
        this.checkversion=checkversion;
    }

    @Test
    public void canPassInMultipleParamsToTest(){
        System.out.println(
                String.format(
                        "running test with param getversion = %d and checkversion = %d"
                        , getversion, checkversion));

        Assert.assertTrue(getversion >= 1 && getversion <= 5);
        Assert.assertTrue(checkversion >= 11 && checkversion <= 15);
    }

    // if I add any more tests then they will be run with the
    // same getversion and checkversion values because data is
    // injected using the constructor, and not the test method
}
