package uk.gov.dwp.maze;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
