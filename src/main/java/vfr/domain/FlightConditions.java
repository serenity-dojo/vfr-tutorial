package vfr.domain;

public class FlightConditions {

    private final int flightLevel;
    private final Double heightAboveClouds;
    private final Double horizontalDistance;
    private final Double visibility;

    public FlightConditions(FlightLevel flightLevel, Distance visibility,
                            RelativePosition positionOfClouds
                            /*Distance horizontalDistance, Distance heightAboveClouds*/) {
        this.flightLevel = flightLevel.inFeet();
        this.visibility = visibility.inKilometers();
        this.horizontalDistance = positionOfClouds.horizontalDistance.getValue();
        this.heightAboveClouds = positionOfClouds.verticalDistance.inFeet();
    }

    public int getFlightLevel() {
        return flightLevel;
    }

    public Double getHeightAboveClouds() {
        return heightAboveClouds;
    }

    public Double getHorizontalDistance() {
        return horizontalDistance;
    }

    public Double getVisibility() {
        return visibility;
    }
}
