package uk.gov.dwp.maze;

public enum Tile {
    Wall('X'),
    Start('S'),
    Finish('F'),
    Open(' ');

    private final char symbol;

    Tile(char symbol) {
        this.symbol = symbol;
    }

    public static Tile fromSymbol(char symbol) {
        for (Tile value : values()) {
            if (value.symbol == symbol) {
                return value;
            }
        }
        return null;
    }

    public Location step(Location oldLocation, Location newLocation) {
        return this == Wall ? oldLocation : newLocation;
    }

    public char getSymbol() {
        return symbol;
    }
}
