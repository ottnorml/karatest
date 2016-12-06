/**
 * Example code for assignment 15. Calls several methods that need to be implemented in {@link Pixel},
 * {@link Line}, and {@link Box}.
 *
 * @author Ullrich Hafner
 */
public class Assignment15 extends Kara {
    private int width;
    private int height;

    /**
     * Draws some nice graphics.
     */
    public void act() {
        width = computeWidth();
        height = computeHeight();

        Pixel topLeftCorner = new Pixel(0, 0);
        Pixel topRightCorner = topLeftCorner.move(width - 1, 0);
        Pixel bottomLeftCorner = topLeftCorner.move(0, height - 1);
        Pixel bottomRightCorner = topLeftCorner.move(width - 1, height - 1);

        draw(topLeftCorner, topRightCorner, bottomLeftCorner, bottomRightCorner);

        readLong("Edge Pixels...");
        clear();

        draw(new Pixel(-1, 0));
        draw(new Pixel(0, -1));
        draw(new Pixel(-1, -1));
        draw(new Pixel(-1, -1));
        draw(new Pixel(width, height - 1));
        draw(new Pixel(width - 1, height));
        draw(new Pixel(width, height));

        readLong("Lines...");
        clear();

        Line top = new Line(topLeftCorner, width);
        Line bottom = top.move(0, height - 1);
        Line left = new Line(topLeftCorner, height, false);
        Line right = left.move(width - 1, 0);

        draw(top, bottom, left, right);

        readLong("Intersection...");

        if (top.intersects(left) && top.intersects(right)
                && left.intersects(top) && left.intersects(bottom)
                && !top.intersects(bottom) && !left.intersects(right)) {
            clear();
        }

        draw(top, bottom, left, right);

        readLong("Contains...");

        if (top.contains(topLeftCorner) && top.contains(topRightCorner)
                && !top.contains(bottomLeftCorner) && !top.contains(bottomRightCorner)) {
            clear();
        }

        readLong("Boxes...");

        Box rectangle = new Box(topLeftCorner, width, height, false);
        Box filled = new Box(topLeftCorner.move(2, 2), width - 4, height - 4, true);

        draw(rectangle, filled);

        readLong("Intersection...");
        clear();

        if (filled.move(-2, -2).intersects(rectangle)) {
            draw(rectangle, filled.move(-2, -2));
        }
        if (rectangle.intersects(left.move(1, 0))) {
            draw(left.move(1, 0));
        }
        if (rectangle.intersects(new Box(topLeftCorner.move(2, 2), width - 4, height - 4))) {
            clear();
        }
        readLong("Contains...");
        clear();

        if (rectangle.contains(topLeftCorner) && !filled.contains(topLeftCorner)) {
            draw(rectangle, new Box(topLeftCorner.move(2, 2), width - 4, height - 4));
        }
    }

    private void clear() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (isOnLeaf()) {
                    removeLeaf();
                }
                move();
            }
            down();
        }
    }

    private void down() {
        turnRight();
        move();
        turnLeft();
    }

    private void draw(final Box... boxes) {
        for (Box box : boxes) {
            for (Pixel pixel : box.getPixels()) {
                draw(pixel);
            }
        }
    }

    private void draw(final Line... lines) {
        for (Line line : lines) {
            for (Pixel pixel : line.getPixels()) {
                draw(pixel);
            }
        }
    }

    private void draw(final Pixel... pixels) {
        for (Pixel pixel : pixels) {
            if (isValid(pixel.getX(), pixel.getY())) {
                moveBy(pixel.getX(), pixel.getY());
                if (!isOnLeaf()) {
                    putLeaf();
                }
                moveBy(-pixel.getX(), -pixel.getY());
            }
        }
    }

    private boolean isValid(final int x, final int y) {
        return x >= 0 && y >= 0 && x < width && y < height;
    }

    private void moveBy(final int xDelta, final int yDelta) {
        moveBy(xDelta);
        turnRight();
        moveBy(yDelta);
        turnLeft();
    }

    private void moveBy(final int steps) {
        int increment;
        if (steps < 0) {
            turnAround();
            increment = - steps;
        }
        else {
            increment = steps;
        }

        for (int i = 0; i < increment; i++) {
            move();
        }
        if (steps < 0) {
            turnAround();
        }
    }

    private void turnAround() {
        turnLeft();
        turnLeft();
    }

    private int computeWidth() {
        return computeLength();
    }

    private int computeHeight() {
        turnRight();
        int height = computeLength();
        turnLeft();
        return height;
    }

    private int computeLength() {
        int length = 0;

        putLeaf();
        do {
            move();
            length++;
        } while (!isOnLeaf());
        removeLeaf();

        return length;
    }
}
