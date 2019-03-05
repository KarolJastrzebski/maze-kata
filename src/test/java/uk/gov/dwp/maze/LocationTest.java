package uk.gov.dwp.maze;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {

    private static void viewing(int startX, int startY, Direction facing, int expectedX, int expectedY) {
        assertThat(new Location(startX, startY).towards(facing))
            .hasFieldOrPropertyWithValue("x", expectedX)
            .hasFieldOrPropertyWithValue("y", expectedY);
    }

    @Test
    public void viewing_N() {
        viewing(3, 7, Direction.N, 3, 6);
    }

    @Test
    public void viewing_E() {
        viewing(1, -3, Direction.E, 2, -3);
    }

    @Test
    public void viewing_S() {
        viewing(234, 11, Direction.S, 234, 12);
    }

    @Test
    public void viewing_W() {
        viewing(10, 11, Direction.W, 9, 11);
    }

    @Test
    public void comparing_same_positions() {
        assertThat(new Location(1, 1)).isEqualTo(new Location(1, 1));
    }
}
