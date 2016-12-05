/**
 * Example code for assignment 15. Calls several methods that need to be implemented in {@link Canvas}.
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
        Pixel topRightCorner = new Pixel(width - 1, 0);
        Pixel bottomLeftCorner = new Pixel(0, height - 1);
        Pixel bottomRightCorner = new Pixel(width - 1, height - 1);

        draw(topLeftCorner, topRightCorner, bottomLeftCorner, bottomRightCorner);

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
        Line bottom = new Line(bottomLeftCorner, width, true);
        Line left = new Line(topLeftCorner, height, false);
        Line right = new Line(topRightCorner, width, false);

        draw(top, bottom, left, right);

        readLong("Boxes...");
        clear();

        Box rectangle = new Box(topLeftCorner, width, height, false);
        Box filled = new Box(topLeftCorner.move(2, 2), width - 4, height - 4);

        draw(rectangle, filled);
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
        return x >= 0 && y >= 0&& x < width && y < height;
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
