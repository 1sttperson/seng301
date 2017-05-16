package controllers;

import javafx.fxml.FXML;
import model.DataStore;
import model.Driver;

public class DriverMainController extends Controller{

    public void initialize(){
    }

//    @Override
//    public void setup(ScreenController screenController){
//        this.screenController = screenController;
//        this.dataStore = dataStore;
//
//        //temporarily creating a test driver
//        Driver driver = new Driver(1);
//        this.dataStore.addDriver(driver);
//        this.dataStore.setCurrentDriver(driver);
//    }

    @FXML
    private void registerCarAction(){
        screenController.loadScreen(Screens.REGISTER_CAR.getValue());
    }

    @FXML
    private void createStopPointAction(){
        screenController.loadScreen(Screens.CREATE_STOP_POINT.getValue());
    }

    @FXML
    private void createRouteAction(){
        screenController.loadScreen(Screens.CREATE_ROUTE.getValue());
    }
}
