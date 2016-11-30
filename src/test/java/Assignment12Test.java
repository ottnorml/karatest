import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Verifies that the solution for homework assignment 12 works as expected.
 *
 * @author Ullrich Hafner
 */
public class Assignment12Test extends AbstractKaraTest {
    /**
     * Verifies that Kara does not change anything if the world is full of leaves.
     */
    @Test
    public void shouldDoNothingIfFilled() {
        for (int i = -8; i < 8; i++) {
            verify(new String[]{
                            "........",
                            "........",
                            "........",
                            "........",
                    },
                    new String[]{
                            "........",
                            "........",
                            "........",
                            "........",
                    },
                    i);

        }
    }

    /**
     * Verifies that Kara does not change anything if the world is full of leaves.
     */
    @Test
    public void shouldDoNothingIfEmpty() {
        for (int i = -8; i < 8; i++) {
            verify(new String[]{
                            "        ",
                            "        ",
                            "        ",
                            "        ",
                    },
                    new String[]{
                            "        ",
                            "        ",
                            "        ",
                            "        ",
                    },
                    i);
        }

    }

    /**
     * Verifies that Kara can shift by the specified amount.
     */
    @Test
    public void shouldShiftBySeven() {
        int[] shifts = {7, 7 + 8, -1, -1 - 8};
        String[] start = {
                "      ..",
                ".    ...",
                "..  ....",
                "........",
        };
        String[] expected = {
                ".      .",
                "..    ..",
                "...  ...",
                "........",
        };
        verify(shifts, start, expected);
    }

    private void verify(final int[] shifts, final String[] start, final String[] expected) {
        for (int shift : shifts) {
            verify(start, expected, shift);
        }
    }

    /**
     * Verifies that Kara can shift by the specified amount.
     */
    @Test
    public void shouldShiftByOne() {
        int[] shifts = {1, 1 + 8, -7, -7 - 8};
        String[] start = {
                "..      ",
                "...    .",
                "....  ..",
                "........",
        };
        String[] expected = {
                ".      .",
                "..    ..",
                "...  ...",
                "........",
        };
        verify(shifts, start, expected);
    }

    /**
     * Verifies that Kara can shift by the specified amount.
     */
    @Test
    public void shouldShiftByFour() {
        verify(
                new String[]{
                        "    ....",
                        "    .  .",
                        "    .  .",
                        "    ....",
                },
                new String[]{
                        "....    ",
                        ".  .    ",
                        ".  .    ",
                        "....    ",
                },
                4);
        verify(
                new String[]{
                        "    ....",
                        "    .  .",
                        "    .  .",
                        "    ....",
                },
                new String[]{
                        "....    ",
                        ".  .    ",
                        ".  .    ",
                        "....    ",
                },
                4 + 8);
    }

    /**
     * Verifies that Kara can shift by the specified amount.
     */
    @Test
    public void shouldShiftByZero() {
        verify(
                new String[]{
                        "    ....",
                        "    .  .",
                        "    .  .",
                        "    ....",
                },
                new String[]{
                        "    ....",
                        "    .  .",
                        "    .  .",
                        "    ....",
                },
                0);
        verify(
                new String[]{
                        "    ....",
                        "    .  .",
                        "    .  .",
                        "    ....",
                },
                new String[]{
                        "    ....",
                        "    .  .",
                        "    .  .",
                        "    ....",
                },
                0 + 8);
    }

    private void verify(final String[] start, final String[] expected, final int shift) {
        JunitKaraRunner karaRunner = new JunitKaraRunner(0, 0, Orientation.RIGHT, start);

        Tools tools = mock(Tools.class);
        when(tools.readInt(anyString())).thenReturn(shift);

        runProgram(karaRunner, tools);

        Assert.assertEquals("Die Welten sind nicht korrekt beim Shift von " + shift,
                new JunitKaraRunner(0, 0, Orientation.RIGHT, expected), karaRunner);
    }

    @Override
    protected Kara createProgram() {
        return new Assignment12();
    }
}
