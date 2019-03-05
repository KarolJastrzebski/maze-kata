package uk.gov.dwp.maze.visitor;

import uk.gov.dwp.maze.Location;
import uk.gov.dwp.maze.MazeVisitor;
import uk.gov.dwp.maze.Pose;
import uk.gov.dwp.maze.Tile;
import uk.gov.dwp.maze.Tracker;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

public class TextMazeVisitor implements MazeVisitor {

    private final static Function<Entry<Location, Tile>, Integer> byX = entry -> entry.getKey().getX();
    private final static Function<Entry<Location, Tile>, Integer> byY = entry -> entry.getKey().getY();
    private final static char[] directionGlyphs = {'^', '>', 'v', '<'};
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

    public void print(PrintStream out) {
        lastY = 0;
        map.entrySet().stream()
            .sorted(Comparator.comparing(byY).thenComparing(byX))
            .forEach(entry -> {
                if (lastY != entry.getKey().getY()) {
                    out.println();
                    lastY = entry.getKey().getY();
                }
                if (readyToPrintExplorer(entry)) {
                    out.print(explorerGlyph());
                } else {
                    out.print(entry.getValue().getType());
                }
            });
        out.println();
    }

    private boolean readyToPrintExplorer(Entry<Location, Tile> entry) {
        return pose != null && pose.samePositionAs(entry.getKey());
    }

    private char explorerGlyph() {
        return directionGlyphs[pose.getDirection().ordinal()];
    }
}
