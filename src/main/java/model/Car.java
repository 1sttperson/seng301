package model;

import java.util.Date;

public class Car {
    private String type;
    private String model;
    private String colour;
    private String plateNumber;
    private Integer yearMade;
    private Integer numSeats;

    public Car(String type, String model, String colour, String plateNumber, Integer yearMade, Integer numSeats) {
        this.type = type;
        this.model = model;
        this.colour = colour;
        this.plateNumber = plateNumber;
        this.yearMade = yearMade;
        this.numSeats = numSeats;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
}
