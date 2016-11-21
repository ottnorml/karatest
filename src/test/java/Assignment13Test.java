import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

/**
 * Tests the class {@link Assignment13}.
 */
public class Assignment13Test extends AbstractTimeoutKaraTest {
    /** Fails a test if the source code contains an infinite loop. */
    @Rule @SuppressFBWarnings("URF")
    public final Timeout TIME_OUT = new Timeout(20, TimeUnit.SECONDS); // NOCHECKSTYLE

    /**
     * Verifies prime numbers up to 2.
     */
    @Test
    public void shouldComputePrimesUpTo2() {
        verifyResult(2, 1);
    }

    /**
     * Verifies prime numbers up to 10.
     */
    @Test
    public void shouldComputePrimesUpTo10() {
        verifyResult(10, 4);
    }

    /**
     * Verifies prime numbers up to 10.
     */
    @Test
    public void shouldComputePrimesUpTo11() {
        verifyResult(11, 5);
    }

    /**
     * Verifies prime numbers up to 100.
     */
    @Test
    public void shouldComputePrimesUpTo100() {
        verifyResult(100, 25);
    }

    /**
     * Verifies prime numbers up to 100.
     */
    @Test
    public void shouldComputePrimesUpTo101() {
        verifyResult(101, 26);
    }

    /**
     * Verifies prime numbers up to 1000.
     */
    @Test
    public void shouldComputePrimesUpTo1000() {
        verifyResult(1_000, 168);
    }

    /**
     * Verifies prime numbers up to 10_000.
     */
    @Test
    public void shouldComputePrimesUpTo10000() {
        verifyResult(10_000, 1229);
    }

    /**
     * Verifies prime numbers up to 100_000.
     */
    @Test
    public void shouldComputePrimesUpTo100000() {
        verifyResult(100_000, 9592);
    }

    /**
     * Verifies prime numbers up to 1_000_000.
     */
    @Test
    public void shouldComputePrimesUpTo1000000() {
        verifyResult(1_000_000, 78498);
    }

    private void verifyResult(final int input, final int expectedOutput) {
        JunitKaraRunner karaRunner = new JunitKaraRunner(0, 0, Orientation.RIGHT, 9, 9);

        Tools tools = mock(Tools.class);
        when(tools.readInt(anyString())).thenReturn(input);

        runProgram(karaRunner, tools);

        verify(tools).showMessage(matches("\\D*" + expectedOutput + "\\D*"));
    }

    @Override
    protected Kara createProgram() {
        return new Assignment13();
    }
}