import org.junit.Test;

/**
 * Verifies that the solution for homework assignment 7 works as expected.
 *
 * @author Ullrich Hafner
 */
public class Assignment7Test extends AbstractTimeoutKaraTest {
    /**
     * Verifies that Kara walks through the labyrinth from top left corner to bottom right corner.
     */
    @Test
    public void shouldMoveFromTopLeftToBottomRight() {
        verifyWorld(
                new String[]{
                        "#####",
                        "  # #",
                        "#   #",
                        "# # .",
                        "#####",
                },
                1, 0, Orientation.RIGHT,
                new String[]{
                        "#####",
                        "  # #",
                        "#   #",
                        "# # .",
                        "#####",
                },
                3, 4, Orientation.RIGHT);
    }

    /**
     * Verifies that Kara walks through the labyrinth from bottom right corner to top left corner.
     */
    @Test
    public void shouldMoveFromBottomLeftToTopRight() {
        verifyWorld(
                new String[]{
                        "#####",
                        "# # .",
                        "#   #",
                        "  # #",
                        "#####",
                },
                3, 0, Orientation.RIGHT,
                new String[]{
                        "#####",
                        "# # .",
                        "#   #",
                        "  # #",
                        "#####",
                },
                1, 4, Orientation.RIGHT);
    }

   /**
     * Verifies that Kara walks through straight forward if possible.
     */
    @Test
    public void shouldMoveStraightForward() {
        verifyWorld(
                new String[]{
                        "#####",
                        "# # #",
                        "    .",
                        "# # #",
                        "#####",
                },
                2, 0, Orientation.RIGHT,
                new String[]{
                        "#####",
                        "# # #",
                        "    .",
                        "# # #",
                        "#####",
                },
                2, 4, Orientation.RIGHT);
    }

   /**
     * Verifies that Kara walks through a large labyrinth.
     */
    @Test
    public void shouldCrossLargeLabyrinth() {
        verifyWorld(
                new String[]{
                        "#####################",
                        "  #   # # #   # # # #",
                        "# # # # #   #   #   #",
                        "# # # # # # # # # # #",
                        "# # #   # # # #   # #",
                        "#   # #   # # # # # .",
                        "#####################"
                },
                1, 0, Orientation.RIGHT,
                new String[]{
                        "#####################",
                        "  #   # # #   # # # #",
                        "# # # # #   #   #   #",
                        "# # # # # # # # # # #",
                        "# # #   # # # #   # #",
                        "#   # #   # # # # # .",
                        "#####################"
                },
                5, 20, Orientation.RIGHT);
    }

    @Override
    protected Kara createProgram() {
        return new Assignment7();
    }
}

