import java.util.ArrayList;
import java.util.List;

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
    public void shouldCreateAPointAsBox() {
        Box box = new Box(START, 1, 1, true);
        assertThat(box.getPixels()).containsExactly(START);

        box = new Box(START, 1, 1, false);
        assertThat(box.getPixels()).containsExactly(START);
    }

    @Test
    public void shouldCreateFilledBox() {
        Box box = new Box(START, 5, 2);

        verifyPixels(box, expectedBoxPixels());
    }

    private void verifyPixels(final Box box, final Pixel[] expectedPixels) {
        assertThat(box.getPixels()).containsExactlyInAnyOrder(expectedPixels);
        verifyEdges(box);
    }

    private Pixel[] expectedBoxPixels() {
        ArrayList<Pixel> pixels = new ArrayList<>();
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 2; y++) {
                pixels.add(START.move(x, y));
            }
        }
        return pixels.toArray(new Pixel[pixels.size()]);
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
        Pixel[] expectedPixels = expectedRectanglePixels();

        Box box = new Box(START, 5, 2);
        verifyPixels(box, expectedPixels);

        box = new Box(START, 5, 2, false);
        verifyPixels(box, expectedPixels);
    }

    private Pixel[] expectedRectanglePixels() {
        List<Pixel> pixels = new ArrayList<>();
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 2; y++) {
                if (x == 0 || y == 0 || x == 4 || y == 1) {
                    pixels.add(START.move(x, y));
                }
            }
        }
        return pixels.toArray(new Pixel[pixels.size()]);
    }

    @Test
    public void shouldNeverReturnInternalArray() {
        Box box = new Box(START, 5, 2);
        Pixel[] copyOrInternal = box.getPixels();
        copyOrInternal[0] = null;

        assertThat(box.getPixels()).containsExactlyInAnyOrder(expectedRectanglePixels());
    }

    @Test
    public void shouldFindBoxIntersections() {
        assertThat(new Box(new Pixel(0, 0), 3, 5).intersects(new Box(new Pixel(2, 4), 5, 2))).isTrue();
        assertThat(new Box(new Pixel(0, 0), 3, 5).move(-1, 0).intersects(new Box(new Pixel(2, 4), 5, 2))).isFalse();
        assertThat(new Box(new Pixel(0, 0), 3, 5).move(0, -1).intersects(new Box(new Pixel(2, 4), 5, 2))).isFalse();
        assertThat(new Box(new Pixel(0, 0), 2, 4).intersects(new Box(new Pixel(2, 4), 5, 2))).isFalse();

        assertThat(new Box(new Pixel(0, 0), 4, 4, true).intersects(new Box(new Pixel(1, 1), 2, 2, true))).isTrue();
        assertThat(new Box(new Pixel(0, 0), 4, 4, false).intersects(new Box(new Pixel(1, 1), 2, 2, true))).isFalse();

        assertThat(new Box(new Pixel(2, 4), 5, 3).contains(new Pixel(6, 6))).isTrue();
        assertThat(new Box(new Pixel(2, 4), 5, 3).contains(new Pixel(3, 5))).isFalse();
        assertThat(new Box(new Pixel(2, 4), 5, 3, true).contains(new Pixel(3, 5))).isTrue();

    }

    @Test
    public void shouldFindLineIntersections() {
        assertThat(new Box(new Pixel(0, 0), 3, 5).intersects(new Line(new Pixel(2, 4), 5))).isTrue();
        assertThat(new Box(new Pixel(0, 0), 3, 5).intersects(new Line(new Pixel(3, 4), 5))).isFalse();
    }
}