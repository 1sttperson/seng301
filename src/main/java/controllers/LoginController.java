package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.DataStore;

public class LoginController extends Controller{

    public void initialize(){}

    @FXML
    private TextField idField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void driverSelectAction() {
        screenController.loadScreen(Screens.DRIVER.getValue());
    }

    @FXML
    private void registerAction() {
        screenController.loadScreen(Screens.REGISTER_ACCOUNT_TYPE.getValue());
    }

    @FXML
    private void loginAction() {
        try {
            DataStore dataStore = DataStore.getInstance();
            Integer studentId = Integer.parseInt(idField.getText());
            if (dataStore.getDrivers().containsKey(studentId)) {
                if (dataStore.getDrivers().get(studentId).getPassword().equals(passwordField.getText())) {
                    screenController.loadScreen(Screens.DRIVER.getValue());
                }
            }
            else if (dataStore.getPassengers().containsKey(studentId)) {
                if (dataStore.getPassengers().get(studentId).getPassword().equals(passwordField.getText())) {
                    screenController.loadScreen(Screens.PASSENGER.getValue());
                }
            } else {
                System.err.println("password does not exist");
            }
        } catch (Exception e) {
            System.err.println("password in the wrong format");
        }
    }
}
