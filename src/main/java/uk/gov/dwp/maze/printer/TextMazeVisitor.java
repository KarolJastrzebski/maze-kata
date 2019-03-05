package uk.gov.dwp.maze.printer;

import uk.gov.dwp.maze.Location;
import uk.gov.dwp.maze.Pose;
import uk.gov.dwp.maze.Tile;
import uk.gov.dwp.maze.Tracker;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

public class TextMazeVisitor implements MazeVisitor {

    private Pose pose;
    private int lastY = 0;
    private Map<Location, Tile> map;

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
    }

    public void print() {
        lastY = 0;
        Function<Entry<Location, Tile>, Integer> byX = entry -> entry.getKey().getX();
        Function<Entry<Location, Tile>, Integer> byY = entry -> entry.getKey().getY();
        map.entrySet().stream()
            .sorted(Comparator.comparing(byY).thenComparing(byX))
            .forEach(entry -> {
                if (lastY != entry.getKey().getY()) {
                    System.out.println();
                    lastY = entry.getKey().getY();
                }
                if (pose != null && pose.samePositionAs(entry.getKey())) {
                    System.out.print(directedPosition());
                } else {
                    System.out.print(entry.getValue().getType());
                }
            });
        System.out.println();
    }

    private String directedPosition() {
        switch (pose.getDirection()) {
            case N:
                return "^";
            case E:
                return ">";
            case S:
                return "v";
            case W:
                return "<";
        }
        return "";
    }
}
