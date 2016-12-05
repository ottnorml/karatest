import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link Line}.
 *
 * @author Ullrich Hafner
 */
public class LineTest {
    private static final Pixel[] HORIZONTAL_PIXELS = {new Pixel(2, 2), new Pixel(3, 2), new Pixel(4, 2),
            new Pixel(5, 2), new Pixel(6, 2)};
    private static final Pixel[] VERTICAL_PIXELS = {new Pixel(2, 2), new Pixel(2, 3), new Pixel(2, 4),
            new Pixel(2, 5), new Pixel(2, 6)};

    @Test
    public void shouldCreateHorizontalLine() {
        Line line = createHorizontalLine();
        verifyHorizontalLine(line);

        line = new Line(new Pixel(2, 2), 5);
        verifyHorizontalLine(line);
    }

    private Line createHorizontalLine() {
        return new Line(new Pixel(2, 2), 5, true);
    }

    private void verifyHorizontalLine(final Line line) {
        assertThat(line.getPixels()).containsExactly(HORIZONTAL_PIXELS);
    }

    @Test
    public void shouldCreateVerticalLine() {
        Line line = createVerticalLine();
        assertThat(line.getPixels()).containsExactly(VERTICAL_PIXELS);
    }

    private Line createVerticalLine() {
        return new Line(new Pixel(2, 2), 5, false);
    }

    @Test
    public void shouldFindAllPixelsForHorizontalLine() {
        Line line = createHorizontalLine();
        for (Pixel pixel : HORIZONTAL_PIXELS) {
            assertThat(line.contains(pixel)).isTrue();
        }
        Pixel[] other = ArrayUtils.remove(VERTICAL_PIXELS, 0);
        for (Pixel pixel : other) {
            assertThat(line.contains(pixel)).isFalse();
        }
    }

    @Test
    public void shouldFindAllPixelsForVerticalLine() {
        Line line = createVerticalLine();
        for (Pixel pixel : VERTICAL_PIXELS) {
            assertThat(line.contains(pixel)).isTrue();
        }
        Pixel[] other = ArrayUtils.remove(HORIZONTAL_PIXELS, 0);
        for (Pixel pixel : other) {
            assertThat(line.contains(pixel)).isFalse();
        }
    }

    @Test
    public void shouldFindIntersection() {
        assertThat(createHorizontalLine().intersects(createVerticalLine())).isTrue();
        assertThat(createHorizontalLine().move(-1, 0).intersects(createVerticalLine())).isTrue();
        assertThat(createHorizontalLine().move(1, 0).intersects(createVerticalLine())).isFalse();
        assertThat(createHorizontalLine().intersects(createVerticalLine().move(0, -1))).isTrue();
        assertThat(createHorizontalLine().intersects(createVerticalLine().move(0, 1))).isFalse();

        assertThat(new Line(new Pixel(2, 4), 5).intersects(new Line(new Pixel(3, 3), 2, false))).isTrue();
        assertThat(new Line(new Pixel(2, 4), 5).intersects(new Line(new Pixel(1, 3), 2, false))).isFalse();
    }
}