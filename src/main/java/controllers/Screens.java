package controllers;

public enum Screens {
    LOGIN ("/Login.fxml"),
    REGISTER_ACCOUNT_TYPE("/RegisterAccountType.fxml"),
    REGISTER_DRIVER("/RegisterDriver.fxml"),
    REGISTER_PASSENGER("/RegisterPassenger.fxml"),
    DRIVER ("/Driver.fxml"),
    PASSENGER ("/Passenger.fxml"),
    REGISTER_CAR ("/RegisterCar.fxml"),
    CREATE_STOP_POINT ("/CreateStopPoint.fxml"),
    CREATE_ROUTE ("/CreateRoute.fxml"),
    CREATE_TRIP ("/CreateTrip.fxml");

    private final String value;

    Screens(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
