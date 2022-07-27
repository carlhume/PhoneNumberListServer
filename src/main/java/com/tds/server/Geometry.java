package com.tds.server;

public class Geometry {

    private String type;
    private double[] coordinates = new double[2];
    public Geometry( String newType, double [] newCoordinates ) {
        this.type = newType;
        this.coordinates = newCoordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }
}
