package model;

import java.util.List;

public class Route {
    private List<StopPoint> stopPoints;
    private String name;

    public Route(List<StopPoint> stopPoints, String name) {
        this.stopPoints = stopPoints;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<StopPoint> getStopPoints() {
        return stopPoints;
    }
}
