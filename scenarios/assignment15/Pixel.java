/**
 * TODO: Write a description of class Pixel here.
 *
 * @author TODO: your name
 */
public class Pixel {
    // TODO: Implement class Pixel

    // Do not remove the equals method!
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pixel pixel = (Pixel)o;

        if (getX() != pixel.getX()) {
            return false;
        }
        return getY() == pixel.getY();

    }

    // Do not remove the hashCode method!
    @Override
    public int hashCode() {
        return 31 * getX() + getY();
    }
}
