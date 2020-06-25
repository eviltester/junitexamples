package execution.suites;

import assertions.common.Junit4AssertTest;
import assertions.forexceptions.JUnit4ExceptionsTest;
import assertions.staticimportvsaccess.JUnit4StaticTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**

 The suite can be run from the IDE.

 running from maven with:

 ~~~~~~~~
 mvn test -Dtest=JUnit4TestSuiteConfig
 ~~~~~~~~

 No longer seems to work for me.

 Works fine on maven-surefire-plugin 2.14.1
 but does not work on version 3.0.0-M4

 May require additional surefire configuration.

 https://maven.apache.org/surefire/maven-surefire-plugin/examples/junit.html

 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        Junit4AssertTest.class,
        JUnit4ExceptionsTest.class,
        JUnit4StaticTest.class
})
public class JUnit4TestSuiteConfig {
}
