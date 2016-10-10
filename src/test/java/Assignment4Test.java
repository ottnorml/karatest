import org.junit.Test;

/**
 * Verifies that the solution for homework assignment 4 works as expected.
 *
 * @author Ullrich Hafner
 */
public class Assignment4Test extends Assignment1Test {
    /**
     * Checks that Kara does not change a world already containing 'HM'.
     */
    @Test
    public void shouldNotChangeAnything() {
        verifyWorld(createExpectedWorld(), createExpectedWorld());
    }

    /**
     * Checks that Kara draws the acronym 'HM' into an world containing the inverted picture of 'HM'.
     */
    @Test
    public void shouldToggleInvertedWorld() {
        verifyWorld(new String[]{
                " ... . ... ",
                " ... .  .  ",
                "     . . . ",
                " ... . ... ",
                " ... . ... ",
        }, createExpectedWorld());
    }

    /**
     * Checks that Kara draws the acronym 'HM' into a world containing only leaves.
     */
    @Test
    public void shouldRemoveFromFilledWorld() {
        verifyWorld(new String[]{
                "...........",
                "...........",
                "...........",
                "...........",
                "...........",
        }, createExpectedWorld());
    }

    @Override
    protected Kara createProgram() {
        return new Assignment4();
    }
}

