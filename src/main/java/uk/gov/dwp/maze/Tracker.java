package uk.gov.dwp.maze;

import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

public class Tracker {

    private LinkedList<Pose> history = new LinkedList<>();

    public Tracker() {
    }

    public Tracker(Tracker original) {
        history = new LinkedList<>(original.history);
    }

    public void register(Pose pose) {
        history.add(pose);
    }

    public LinkedList<Pose> getHistory() {
        return history;
    }

    public Set<Location> getVisitedLocations() {
        return history.stream().map(Pose::getLocation).collect(Collectors.toSet());
    }
}
