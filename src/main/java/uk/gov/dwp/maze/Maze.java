package uk.gov.dwp.maze;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Maze {

    private final Location startPoint;
    private Map<Location, Tile> map;

    public Maze(Map<Location, Tile> map) {
        startPoint = map.entrySet()
            .stream()
            .filter(positionTileEntry -> positionTileEntry.getValue() == Tile.Start)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Start point not found"))
            .getKey();

        this.map = map;
    }

    public static Maze load(InputStream stream) throws IOException {
        if (stream == null) {
            throw new IOException("Input file not found");
        }
        Map<Location, Tile> map = new HashMap<>();
        int x = 0;
        int y = 0;
        char c;
        boolean nextLine = false;
        while (stream.available() > 0) {
            c = (char) stream.read();
            if (c == 10 || c == 13) {
                nextLine = true;
                x = 0;
                continue;
            }
            if (nextLine) {
                y++;
                nextLine = false;
            }
            map.put(new Location(x, y), Tile.fromSymbol(c));
            x++;
        }
        return new Maze(map);
    }

    public static Maze load(String input) throws IOException {
        return load(new ByteArrayInputStream(input.getBytes()));
    }

    public Location getStartPoint() {
        return startPoint;
    }

    public Location step(Location oldLocation, Location newLocation) {
        Tile tile = map.get(newLocation);
        return tile == null ? oldLocation : tile.step(oldLocation, newLocation);
    }

    public Tile get(Location location) {
        return map.get(location);
    }

    public void accept(MazeVisitor visitor) {
        visitor.visit(map);
    }
}
