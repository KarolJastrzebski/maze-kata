package uk.gov.dwp.maze;

public enum Direction {
    N(0, -1),
    E(1, 0),
    S(0, 1),
    W(-1, 0);

    private final Location relativeMovement;

    Direction(int x, int y) {
        relativeMovement = new Location(x, y);
    }

    public Location getRelativeMovement() {
        return relativeMovement;
    }

    public Direction rotateRight() {
        return rotate(1);
    }

    public Direction rotateLeft() {
        return rotate(3);
    }

    private Direction rotate(int i) {
        return values()[(ordinal() + i) % 4];
    }
}
