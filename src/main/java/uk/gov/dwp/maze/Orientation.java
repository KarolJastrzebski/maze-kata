package uk.gov.dwp.maze;

public enum Orientation {
    Left(-1),
    Right(1);

    private final int towards;

    Orientation(int towards) {
        this.towards = towards;
    }

    public int getTowards() {
        return towards;
    }
}
