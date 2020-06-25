package assertions.staticimportvsaccess;

import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class TruthStaticTest {

    @Test
    public void staticAccessVsStaticImport() {
        Truth.assertThat(true).isTrue();
        assertThat(false).isFalse();
    }
}
