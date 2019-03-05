package uk.gov.dwp.maze;

import java.util.Map;

public interface MazeVisitor {

    void visit(Pose pose);

    void visit(Map<Location, Tile> map);

    void visit(Tracker tracker);
}
