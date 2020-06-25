package assertions.staticimportvsaccess;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AssertJStaticTest {


    @Test
    public void staticAccessVsStaticImport() {
        Assertions.assertThat(true).isTrue();
        assertThat(false).isFalse();
    }
}
