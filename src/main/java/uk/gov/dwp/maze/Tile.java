package uk.gov.dwp.maze;

public class Tile {

    private final String type;

    public Tile(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public boolean isWall() {
        return type.contentEquals("X");
    }

    public boolean isStartPoint() {
        return type.contentEquals("S");
    }

    public boolean isFinishingPoint() {
        return type.contentEquals("F");
    }

    public Location step(Location oldLocation, Location newLocation) {
        return isWall() ? oldLocation : newLocation;
    }
}
