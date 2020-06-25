package assertions.staticimportvsaccess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Junit5StaticTest {

    @Test
    public void staticAccessVsStaticImport() {

        Assertions.assertTrue(true);

        assertTrue(true);
    }
}
