import org.junit.Test;

/**
 * Verifies that the solution for homework assignment 5 works as expected.
 *
 * @author Ullrich Hafner
 */
public class Assignment5Test extends AbstractTimeoutKaraTest {
    /**
     * Verifies that a frame of size 2x2 is correctly drawn.
     */
    @Test
    public void shouldDraw2x2Frame() {
        verifyWorld(2, 2,
                new String[]{
                        "..",
                        "..",
                }
        );
    }

    /**
     * Verifies that a frame of size 3x3 is correctly drawn.
     */
    @Test
    public void shouldDraw3x3Frame() {
        verifyWorld(3, 3,
                new String[]{
                        "...",
                        ". .",
                        "...",
                }
        );
    }

    /**
     * Verifies that a frame of size 4x7 is correctly drawn.
     */
    @Test
    public void shouldDraw4x7Frame() {
        verifyWorld(4, 7,
                new String[]{
                        ".......",
                        ".     .",
                        ".     .",
                        ".......",
                }
        );
    }

    protected Kara createProgram() {
        return new Assignment5();
    }
}

