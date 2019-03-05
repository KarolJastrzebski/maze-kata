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

    public Direction rotate(Orientation orientation) {
        Direction[] values = values();
        int next = ordinal() + orientation.getTowards();
        if (next < 0) {
            next = values.length - 1;
        } else if (next == values.length) {
            next = 0;
        }
        return values[next];
    }
}
