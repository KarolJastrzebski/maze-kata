package uk.gov.dwp.maze.stub;

import uk.gov.dwp.maze.Location;
import uk.gov.dwp.maze.Pose;
import uk.gov.dwp.maze.Tile;
import uk.gov.dwp.maze.Tracker;
import uk.gov.dwp.maze.printer.MazeVisitor;

import java.util.Map;

public class MazeVisitorStub implements MazeVisitor {

    private Pose pose;
    private Map<Location, Tile> map;
    private Tracker tracker;

    @Override
    public void visit(Pose pose) {
        this.pose = pose;
    }

    @Override
    public void visit(Map<Location, Tile> map) {
        this.map = map;
    }

    @Override
    public void visit(Tracker tracker) {
        this.tracker = tracker;
    }

    public Pose getPose() {
        return pose;
    }

    public Map<Location, Tile> getMap() {
        return map;
    }

    public Tracker getTracker() {
        return tracker;
    }
}
