package uk.gov.dwp.maze;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerTest {

    private static Pose[] sampleExploration = {
        newPose(0, 0, Direction.N),
        newPose(0, 0, Direction.E),
        newPose(1, 0, Direction.E),
        newPose(1, 0, Direction.S),
        newPose(1, 1, Direction.S),
        newPose(1, 1, Direction.W),
        newPose(0, 1, Direction.W),
        newPose(0, 1, Direction.N),
        newPose(0, 0, Direction.N)
    };

    private Tracker tracker;

    private static Pose newPose(int x, int y, Direction direction) {
        return new Pose(new Location(x, y), direction);
    }

    @Before
    public void setup() {
        tracker = new Tracker();
    }

    @Test
    public void initially_empty() {
        assertThat(tracker.getHistory()).hasSize(0);
    }

    @Test
    public void stores_registered_pose_in_history() {
        Pose pose = newPose(0, 0, Direction.N);

        tracker.register(pose);

        assertThat(tracker.getHistory()).containsExactly(pose);
    }

    @Test
    public void records_every_change_in_history() {
        runSampleExploration(tracker);

        assertThat(tracker.getHistory()).containsExactly(sampleExploration);
    }

    @Test
    public void returns_set_of_visited_locations() {
        runSampleExploration(tracker);

        assertThat(tracker.getVisitedLocations()).containsExactlyInAnyOrder(
            new Location(0, 0),
            new Location(1, 0),
            new Location(1, 1),
            new Location(0, 1)
        );
    }

    @Test
    public void allows_protection_of_original_from_tampering_data() {
        Tracker copy = new Tracker(tracker);
        runSampleExploration(copy);

        assertThat(tracker.getHistory()).hasSize(0);
        assertThat(copy.getHistory()).hasSizeGreaterThan(0);
    }

    private void runSampleExploration(Tracker tracker) {
        for (Pose pose : sampleExploration) {
            tracker.register(pose);
        }
    }
}
