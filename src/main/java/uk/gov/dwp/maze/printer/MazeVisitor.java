package uk.gov.dwp.maze.printer;

import uk.gov.dwp.maze.Location;
import uk.gov.dwp.maze.Pose;
import uk.gov.dwp.maze.Tile;
import uk.gov.dwp.maze.Tracker;

import java.util.Map;

public interface MazeVisitor {

    void visit(Pose pose);

    void visit(Map<Location, Tile> map);

    void visit(Tracker tracker);
}
