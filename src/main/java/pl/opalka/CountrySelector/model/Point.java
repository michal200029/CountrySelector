package pl.opalka.CountrySelector.model;

import lombok.Data;

@Data
public class Point {
    private double latitude;
    private double longitude;
    private String countryName;

    public Point(double latitude, double longitude, String countryName) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.countryName = countryName;
    }

    public Point(){

    }
}
