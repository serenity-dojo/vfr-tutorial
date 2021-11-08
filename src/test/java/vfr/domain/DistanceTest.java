package vfr.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DistanceTest {

//    @Test
//    void visibilityRangeHasAValueAndAUnit() {
//        VisibilityRange range = VisibilityRange.of("10 km");
//        assertThat(range.getUnit()).isEqualTo(UnitOfDistance.km);
//        assertThat(range.getValue()).isEqualTo(10000);
//    }

    @Test
    void visibilityCanBeDefinedInKms() {
        assertThat(Distance.of("10 km").inKilometers()).isEqualTo(10);
    }

    @Test
    void visibilityCanBeDefinedInMetres() {
        assertThat(Distance.of("10000 m").inKilometers()).isEqualTo(10);
    }

    @Test
    void visibilityCanBeDefinedInFeet() {
        assertThat(Distance.of("3281 ft").inKilometers()).isEqualTo(1);
    }
}
