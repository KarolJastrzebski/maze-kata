package uk.gov.dwp.maze;

import java.util.Objects;

public class Location {

    private final int x;
    private final int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Location add(Location other) {
        return new Location(x + other.x, y + other.y);
    }

    public Location towards(Direction direction) {
        return add(direction.getRelativeMovement());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        return x == location.x &&
            y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
