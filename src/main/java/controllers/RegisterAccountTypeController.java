package controllers;


import javafx.fxml.FXML;

public class RegisterAccountTypeController extends Controller {

    @FXML
    void driverAction() {
        screenController.loadScreen(Screens.REGISTER_DRIVER.getValue());
    }

    @FXML
    void passengerAction() {
        screenController.loadScreen(Screens.REGISTER_PASSENGER.getValue());
    }

    @FXML
    void backAction() {
        screenController.loadScreen(Screens.LOGIN.getValue());
    }

}
