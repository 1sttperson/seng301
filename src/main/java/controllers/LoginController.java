package controllers;

import javafx.fxml.FXML;

public class LoginController extends Controller{

    public void initialize(){}

     @FXML
     private void driverSelectAction() {
         screenController.loadScreen(Screens.DRIVER.getValue());
     }

    @FXML
    private void registerAction() {
        screenController.loadScreen(Screens.REGISTER_ACCOUNT_TYPE.getValue());
    }
}
