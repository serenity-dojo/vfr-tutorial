package vfr.domain;

public class Distance {

    private UnitOfDistance unit;
    private Double value;

    public Distance(String valueWithUnit) {

       String[] parts =  valueWithUnit.trim().split(" ");
       unit = UnitOfDistance.valueOf(parts[1]);
       value = valueInMeters(Integer.parseInt(parts[0]), unit);
    }
    public static Distance of(String value) {
        return new Distance(value);
    }

    public UnitOfDistance getUnit() {return unit;}
    public Double getValue() {return value;}

    private Double valueInMeters(int value, UnitOfDistance unit) {
        switch (unit) {
            case km: return value * 1000.0;
            case m: return value * 1.0;
            case ft: return value / 3.281;
        }
        return null;
    }

    public Double inKilometers() {
        return value / 1000;
    }

    public Double inFeet() {
        return value * 3.281;
    }

}
