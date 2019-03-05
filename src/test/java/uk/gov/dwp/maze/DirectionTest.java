package uk.gov.dwp.maze;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void rotating_N_right_is_E() {
        assertThat(Direction.N.rotateRight()).isEqualTo(Direction.E);
    }

    @Test
    public void rotating_W_left_twice_is_E() {
        assertThat(Direction.W.rotateLeft().rotateLeft()).isEqualTo(Direction.E);
    }

    @Test
    public void rotating_left_and_right_cancels_out() {
        assertThat(Direction.S.rotateLeft().rotateRight()).isEqualTo(Direction.S);
    }

    @Test
    public void rotating_4_times_right() {
        assertThat(Direction.E.rotateRight().rotateRight().rotateRight().rotateRight()).isEqualTo(Direction.E);
    }

}
