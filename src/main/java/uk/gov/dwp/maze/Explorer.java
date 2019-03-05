package uk.gov.dwp.maze;

import java.util.HashSet;
import java.util.Set;

public class Explorer {

    private final Maze maze;
    private Pose pose;
    private Tracker tracker;

    public Explorer(Maze maze) {
        this.maze = maze;
        tracker = new Tracker();
    }

    public Pose getCurrentPose() {
        return pose;
    }

    public void dropInToTheStartPoint() {
        pose = new Pose(maze.getStartPoint(), Direction.N);
        trackPose();
    }

    private void trackPose() {
        tracker.register(pose);
    }

    public Tracker getTracker() {
        return new Tracker(tracker);
    }

    public void rotateLeft() {
        pose = pose.rotateLeft();
    }

    public void rotateRight() {
        pose = pose.rotateRight();
    }

    public void moveForward() {
        pose = pose.moveTo(navigate(Movement.Forward));
        trackPose();
    }

    public Tile whatIsInFront() {
        return maze.get(pose.moveForward().getLocation());
    }

    public Set<Movement> movementOptions() {
        Set<Movement> options = new HashSet<>();
        for (Movement movement : Movement.values()) {
            Location location = navigate(movement);
            if (!pose.samePositionAs(location)) {
                options.add(movement);
            }
        }
        return options;
    }

    private Location navigate(Movement movement) {
        return maze.step(pose.getLocation(), pose.move(movement).getLocation());
    }

    public void accept(MazeVisitor visitor) {
        visitor.visit(pose);
        visitor.visit(tracker);
        maze.accept(visitor);
    }
}
