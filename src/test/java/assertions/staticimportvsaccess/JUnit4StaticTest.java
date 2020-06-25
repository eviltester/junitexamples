package assertions.staticimportvsaccess;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JUnit4StaticTest {

    @Test
    public void staticAccessVsStaticImport() {

        Assert.assertTrue(true);

        assertTrue(true);
    }
}
