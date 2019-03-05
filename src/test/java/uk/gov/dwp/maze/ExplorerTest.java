package uk.gov.dwp.maze;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ExplorerTest {

    private Maze maze;
    private Explorer explorer;

    @Before
    public void setup() throws Throwable {
        maze = Maze.load(MazeTest.class.getClassLoader().getResourceAsStream("simple_room.txt"));
        explorer = new Explorer(maze);
        explorer.dropInToTheStartPoint();
    }

    @Test
    public void starts_at_start_point() {
        assertThat(explorer.getCurrentPose().getLocation()).isEqualTo(maze.getStartPoint());
    }

    @Test
    public void starts_facing_north() {
        assertThat(explorer.getCurrentPose().getDirection()).isEqualTo(Direction.N);
    }

    @Test
    public void can_tell_what_is_in_front() {
        assertThat(explorer.whatIsInFront())
            .isInstanceOf(Tile.class)
            .hasFieldOrPropertyWithValue("type", " ");
    }

    @Test
    public void initially_can_move_in_any_direction() {
        Set<Movement> actual = explorer.movementOptions();
        assertThat(actual).containsExactlyInAnyOrder(
            Movement.Forward,
            Movement.Back,
            Movement.Right,
            Movement.Left
        );
    }

    @Test
    public void cannot_move_into_a_wall() {
        explorer.rotateRight();
        explorer.moveForward();

        Set<Movement> actual = explorer.movementOptions();

        assertThat(actual).containsExactlyInAnyOrder(
            Movement.Left,
            Movement.Right,
            Movement.Back
        );
    }
}
