package vfr.step_definitions;

import io.cucumber.java.ParameterType;
import vfr.domain.Distance;

public class DomainParameterTypes {
    @ParameterType("(.*) (km|m|ft)")
    public Distance visibility(String value, String unit) {
        return Distance.of(value + " " + unit);
    }

//    @ParameterType(".*")
//    public VisibilityRange visibility(String value) {
//        return null;
//    }
}
