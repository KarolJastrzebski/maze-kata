package uk.gov.dwp.maze;

public class Pose {

    private final Location location;
    private final Direction direction;

    public Pose(Location location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    public Location getLocation() {
        return location;
    }

    public Direction getDirection() {
        return direction;
    }

    public Pose rotateLeft() {
        return rotate(direction.rotateLeft());
    }

    public Pose rotateRight() {
        return rotate(direction.rotateRight());
    }

    private Pose rotate(Direction newDirection) {
        return new Pose(location, newDirection);
    }

    public Pose move(Movement movement) {
        Direction facing = direction;
        for (int i = 0; i < movement.ordinal(); i++) {
            facing = facing.rotateRight();
        }
        return move(location.towards(facing));
    }

    public Pose move(Location newLocation) {
        return new Pose(newLocation, direction);
    }

    public boolean samePositionAs(Location other) {
        return location.equals(other);
    }
}
