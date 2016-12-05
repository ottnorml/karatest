import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Tests the class {@link Pixel}.
 *
 * @author Ullrich Hafner
 */
public class PixelTest {
    @Test
    public void shouldCreateInstance() {
        Pixel pixel = new Pixel(2, 4);
        assertThat(pixel.getX()).isEqualTo(2);
        assertThat(pixel.getY()).isEqualTo(4);
    }

    @Test
    public void shouldHaveEquals() {
        assertThat(new Pixel(2, 4)).isEqualTo(new Pixel(2, 4));
        assertThat(new Pixel(2, 4)).isNotEqualTo(new Pixel(3, 4));
        assertThat(new Pixel(2, 4)).isNotEqualTo(new Pixel(2, 5));
    }

    @Test
    public void shouldMoveInAllDirections() {
        assertThat(new Pixel(2, 4).move(-1, 0)).isEqualTo(new Pixel(1, 4));
        assertThat(new Pixel(2, 4).move(0, -1)).isEqualTo(new Pixel(2, 3));
        assertThat(new Pixel(2, 4).move(1, 0)).isEqualTo(new Pixel(3, 4));
        assertThat(new Pixel(2, 4).move(0, 1)).isEqualTo(new Pixel(2, 5));
    }
}