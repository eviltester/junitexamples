package assertions.staticimportvsaccess;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class HamcrestStaticTest {

    @Test
    public void staticAccessVsStaticImport() {

        MatcherAssert.assertThat(true, CoreMatchers.equalTo(true));

        assertThat(true, equalTo(true));
    }
}
