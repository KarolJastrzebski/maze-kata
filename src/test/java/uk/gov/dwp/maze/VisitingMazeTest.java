package uk.gov.dwp.maze;

import org.junit.Before;
import org.junit.Test;
import uk.gov.dwp.maze.stub.MazeVisitorStub;

import static org.assertj.core.api.Assertions.assertThat;

public class VisitingMazeTest {

    private Explorer explorer;
    private MazeVisitorStub stub;

    @Before
    public void setUp() throws Exception {
        Maze maze = Maze.load("S");
        explorer = new Explorer(maze);
        stub = new MazeVisitorStub();

        explorer.dropInToTheStartPoint();
        explorer.accept(stub);
    }

    @Test
    public void collects_explorers_current_pose() {
        assertThat(stub.getPose()).isEqualTo(explorer.getCurrentPose());
    }

    @Test
    public void collects_explorers_tracker() {
        assertThat(stub.getTracker().getHistory()).containsOnlyElementsOf(explorer.getTracker().getHistory());
    }

    @Test
    public void collects_maze_map() {
        assertThat(stub.getMap()).hasSize(1);
    }
}
