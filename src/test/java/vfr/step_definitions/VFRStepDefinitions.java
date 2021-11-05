package vfr.step_definitions;

import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import vfr.domain.FlightLevel;
import vfr.domain.RelativePosition;
import vfr.domain.Distance;

import java.util.List;
import java.util.Map;

public class VFRStepDefinitions {
    private Distance horizontalDistance;
    private Distance heightAboveClouds;
    private RelativePosition positionOfClouds;

    FlightLevel flightLevel;
    Distance visibility;

    @ParameterType("FL (.*)")
    public FlightLevel flightLevel(Integer value) {
        return FlightLevel.of(value);
    }

    @Given("the plane is flying at FL {int}")
    public void the_plane_is_flying_at(FlightLevel flightLevel) {
        this.flightLevel = flightLevel;
//        this.flightLevel = FlightLevel.of(flightLevel);
    }

    @When("the current visibility is {visibility}")
    public void the_current_visibility_is_km(Distance visibilityInKm) {
        this.visibility = visibility;
    }

    @DataTableType
    public RelativePosition relativePosition(Map<String, String> positionData) {
        String horizontal = positionData.get("Horizontal distance to clouds");
        String vertical = positionData.get("Vertical distance to clouds");
        return new RelativePosition(
                Distance.of(horizontal),
                Distance.of(vertical)
        );
    }

    @When("clouds are reported at:")
//    public void clouds_are_reported_at(io.cucumber.datatable.DataTable cloudPositions) {
//    public void clouds_are_reported_at(List<Map<String, String>> cloudPositions) {
//            Map<String, String> cloudPosition = cloudPositions.get(0);
//        Integer horizontalDistance = Integer.parseInt(cloudPositions.asMaps().get(0).get("Horizontal distance to clouds"));
//        Integer heightAboveClouds = Integer.parseInt(cloudPositions.asMaps().get(0).get("Vertical distance to clouds"));
//        this.horizontalDistance = Distance.of(cloudPositions.get("Horizontal distance to clouds"));
//        this.heightAboveClouds = Distance.of(cloudPositions.get("Vertical distance to clouds"));

    public void clouds_are_reported_at(RelativePosition cloudPositions) {
        this.positionOfClouds = cloudPositions;
    }

    @Then("the VFT warning should be displayed: {word}")
    public void the_vft_warning_should_be_displayed_no(String yesNo) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
