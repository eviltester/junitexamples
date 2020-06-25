package execution.suites;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

// I used to be able to get this work, but currently can't seem to
// mvn clean compile -DskipTests
// mvn exec:java -Dexec.mainClass="execution.suites.JUnit4TestSuiteRunner"
//
// but again, can run from IDE although that is less use than just running
// the Suite Config class directly.
public class JUnit4TestSuiteRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JUnit4TestSuiteConfig.class);

        System.out.println("Ran " + result.getRunCount() + " tests in " + result.getRunTime() + " milliseconds");

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
            failure.getException().printStackTrace();
        }

        if(!result.wasSuccessful()){
            throw new AssertionError("Test Suite Failed");
        }
    }
}
