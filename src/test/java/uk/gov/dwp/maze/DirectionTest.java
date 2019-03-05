package uk.gov.dwp.maze;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.dwp.maze.Orientation.Left;
import static uk.gov.dwp.maze.Orientation.Right;

public class DirectionTest {

    @Test
    public void rotating_N_right_is_E() {
        assertThat(Direction.N.rotate(Right)).isEqualTo(Direction.E);
    }

    @Test
    public void rotating_W_left_twice_is_E() {
        assertThat(Direction.W.rotate(Left).rotate(Left)).isEqualTo(Direction.E);
    }

    @Test
    public void rotating_left_and_right_cancels_out() {
        assertThat(Direction.S.rotate(Left).rotate(Right)).isEqualTo(Direction.S);
    }

    @Test
    public void rotating_4_times_right() {
        assertThat(Direction.E.rotate(Right).rotate(Right).rotate(Right).rotate(Right)).isEqualTo(Direction.E);
    }

}
