package uk.gov.dwp.maze;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class MazeTest {

    private Maze maze;

    @Before
    public void setUp() throws Exception {
        maze = Maze.load(MazeTest.class.getClassLoader().getResourceAsStream("simple_room.txt"));
    }

    @Test
    public void starting_position_is_marked_with_S() {
        assertThat(maze.get(maze.getStartPoint())).hasFieldOrPropertyWithValue("type", "S");
    }

    @Test
    public void top_left_corner_is_a_wall() {
        assertThat(maze.get(new Location(0, 0)).isWall()).isTrue();
    }

    @Test
    public void requires_non_null_input() {
        Throwable thrown = catchThrowable(() -> Maze.load((InputStream) null));
        assertThat(thrown).hasMessage("Input file not found");
    }

    @Test
    public void requires_at_least_a_start_point() {
        Throwable thrown = catchThrowable(() -> Maze.load("X"));
        assertThat(thrown).hasMessage("Start point not found");
    }
}
