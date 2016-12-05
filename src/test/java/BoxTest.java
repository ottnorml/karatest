import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link Box}.
 *
 * @author Ullrich Hafner
 */
public class BoxTest {
    private static final Pixel START = new Pixel(2, 4);

    @Test
    public void shouldCreateFilledBox() {
        Box box = new Box(START, 5, 2);
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 2; y++) {
                assertThat(box.contains(START.move(x, y))).isTrue();
            }
        }
        verifyEdges(box);
    }

    private void verifyEdges(final Box box) {
        assertThat(box.contains(START.move(-1, 0))).isFalse();
        assertThat(box.contains(START.move(0, -1))).isFalse();

        assertThat(box.contains(START.move(5, 0))).isFalse();
        assertThat(box.contains(START.move(4, -1))).isFalse();

        assertThat(box.contains(START.move(0, 2))).isFalse();
        assertThat(box.contains(START.move(-1, 1))).isFalse();

        assertThat(box.contains(START.move(4, 2))).isFalse();
        assertThat(box.contains(START.move(5, 1))).isFalse();
    }

    @Test
    public void shouldCreateRectangle() {
        Box box = new Box(START, 5, 2);
        verifyRectangle(box);

        box = new Box(START, 5, 2, false);
        verifyRectangle(box);
    }

    private void verifyRectangle(final Box box) {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 2; y++) {
                assertThat(box.contains(START.move(x, y))).isEqualTo(
                        x == 0 || y == 0 || x == 4 || y == 1
                );
            }
        }
        verifyEdges(box);
    }

    @Test
    public void shouldFindBoxIntersections() {
        assertThat(new Box(new Pixel(0, 0), 3, 5).intersects(new Box(new Pixel(2, 4), 5, 2))).isTrue();
        assertThat(new Box(new Pixel(0, 0), 3, 5).move(-1, 0).intersects(new Box(new Pixel(2, 4), 5, 2))).isFalse();
        assertThat(new Box(new Pixel(0, 0), 3, 5).move(0, -1).intersects(new Box(new Pixel(2, 4), 5, 2))).isFalse();
        assertThat(new Box(new Pixel(0, 0), 2, 4).intersects(new Box(new Pixel(2, 4), 5, 2))).isFalse();

        assertThat(new Box(new Pixel(0, 0), 4, 4, true).intersects(new Box(new Pixel(1, 1), 2, 2, true))).isTrue();
        assertThat(new Box(new Pixel(0, 0), 4, 4, false).intersects(new Box(new Pixel(1, 1), 2, 2, true))).isFalse();
    }

    @Test
    public void shouldFindLineIntersections() {
        assertThat(new Box(new Pixel(0, 0), 3, 5).intersects(new Line(new Pixel(2, 4), 5))).isTrue();
        assertThat(new Box(new Pixel(0, 0), 3, 5).intersects(new Line(new Pixel(3, 4), 5))).isFalse();
    }
}