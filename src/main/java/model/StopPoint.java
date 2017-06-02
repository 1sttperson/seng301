package model;

public class StopPoint {
    private int number;
    private String street;
    private String suburb;
    private String stopTime;

    public StopPoint(int number, String street, String suburb) {
        this.number = number;
        this.street = street;
        this.suburb = suburb;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public int getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getSuburb() {
        return suburb;
    }

    public boolean equals(Object o) {
        return (o instanceof StopPoint) &&
                (((StopPoint) o).getNumber()) == (this.getNumber()) &&
                (((StopPoint) o).getStreet()).equals(this.getStreet()) &&
                (((StopPoint) o).getSuburb()).equals(this.getSuburb());
    }
}
