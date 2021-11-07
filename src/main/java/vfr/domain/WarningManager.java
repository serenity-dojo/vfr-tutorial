package vfr.domain;

public class WarningManager {

    private FlightConditions flightConditions;
    private boolean warning = true;

    public WarningManager(FlightConditions flightConditions) {

        if(flightConditions.getFlightLevel()>=100) {
            if(flightConditions.getVisibility() >= 8 &&
                flightConditions.getHorizontalDistance() >= 1500 &&
                flightConditions.getHeightAboveClouds() >= 1000) {
                warning = false;
            }
        }
        //todo: flight conditions below FL 100

    }

    public static WarningManager of(FlightConditions flightConditions) {
        return new WarningManager(flightConditions);
    }

    public String inStringFormat() {

        if(warning) return "Yes";
        else return "No";
    }

}
