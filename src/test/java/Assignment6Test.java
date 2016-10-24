import org.junit.Test;

/**
 * Verifies that the solution for homework assignment 6 works as expected.
 *
 * @author Ullrich Hafner
 */
public class Assignment6Test extends AbstractTimeoutKaraTest {
    /**
     * Verifies that Kara eats all leaves in a world with no trees.
     */
    @Test
    public void shouldEatAllNoTrees() {
        verifyWorld(
                new String[]{
                        "....",
                        "....",
                        "...."
                },
                new String[]{
                        "    ",
                        "    ",
                        "    "
                });
    }
    /**
     * Verifies that Kara eats all leaves if there is a tree in the bottom right corner.
     */
    @Test
    public void shouldEatAllWithBottomRightTree() {
        verifyWorld(
                new String[]{
                        "....",
                        ".#..",
                        "...#"
                },
                new String[]{
                        "    ",
                        " #  ",
                        "   #"
                });
    }

    /**
     * Verifies that Kara eats all leaves if there is a tree in the top right corner.
     */
    @Test
    public void shouldEatAllWithTopRightTree() {
        verifyWorld(
                new String[]{
                        "...#",
                        ".#..",
                        "...."
                },
                new String[]{
                        "   #",
                        " #  ",
                        "    "
                });
    }

    /**
     * Verifies that Kara eats all leaves if there is a tree in the bottom left corner.
     */
    @Test
    public void shouldEatAllWithBottomLeftTree() {
        verifyWorld(
                new String[]{
                        "....",
                        "..#.",
                        "#..."
                },
                new String[]{
                        "    ",
                        "  # ",
                        "#   "
                });
    }

    /**
     * Verifies that Kara eats all leaves even if there is a tree right in front of Kara.
     */
    @Test
    public void shouldEatAllWithTreeRightInFrontOfKara() {
        verifyWorld(
                new String[]{
                        ".#..",
                        "...#",
                        "...."
                },
                new String[]{
                        " #  ",
                        "   #",
                        "    "
                });
    }

    /**
     * Verifies that Kara eats all leaves even if there is a tree below Kara.
     */
    @Test
    public void shouldEatAllWithTreeBelowKara() {
        verifyWorld(
                new String[]{
                        "....",
                        "#...",
                        "...."
                },
                new String[]{
                        "    ",
                        "#   ",
                        "    "
                });
    }

    /**
     * Verifies that Kara eats all leaves in the smallest possible world that contains a tree.
     */
    @Test
    public void shouldEatAllInMinimumWorld() {
        verifyWorld(
                new String[]{
                        "...",
                        ".#.",
                        "..."
                },
                new String[]{
                        "   ",
                        " # ",
                        "   "
                });
    }

    /**
     * Verifies that Kara eats all leaves in a large world with several trees.
     */
    @Test
    public void shouldEatAllInLargeWorld() {
        verifyWorld(
                new String[]{
                        ".........",
                        ".#.#.#.#.",
                        ".........",
                        ".#.#.#.#.",
                        ".........",
                        ".#.#.#.#.",
                        ".........",
                        ".#.#.#.#.",
                        ".........",
                },
                new String[]{
                        "         ",
                        " # # # # ",
                        "         ",
                        " # # # # ",
                        "         ",
                        " # # # # ",
                        "         ",
                        " # # # # ",
                        "         ",
                });
    }

    /**
     * Verifies that Kara eats all leaves in a large world with several trees.
     */
    @Test
    public void shouldEatAllInAnotherLargeWorld() {
        verifyWorld(
                new String[]{
                        "..#...#..",
                        "#...#....",
                        "..#...#..",
                        "#...#....",
                        "..#...#..",
                        "#...#....",
                        "..#...#..",
                        "#...#....",
                },
                new String[]{
                        "  #   #  ",
                        "#   #    ",
                        "  #   #  ",
                        "#   #    ",
                        "  #   #  ",
                        "#   #    ",
                        "  #   #  ",
                        "#   #    ",
                });
    }

    /**
     * Verifies that Kara eats all leaves in a large world with several trees.
     */
    @Test
    public void shouldEatAllInYetAnotherLargeWorld() {
        verifyWorld(
                new String[]{
                        "..#...#..",
                        "#...#....",
                        "......#..",
                        "..#......",
                        "#...#....",
                        "..#...#..",
                        "....#...#",
                },
                new String[]{
                        "  #   #  ",
                        "#   #    ",
                        "      #  ",
                        "  #      ",
                        "#   #    ",
                        "  #   #  ",
                        "    #   #",
                });
    }

    @Override
    protected Kara createProgram() {
        return new Assignment6();
    }
}

