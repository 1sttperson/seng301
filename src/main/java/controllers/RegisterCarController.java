package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Car;
import model.Driver;

import java.text.DateFormat;
import java.util.Date;


/**
 * Created by ptg19 on 5/04/17.
 */
public class RegisterCarController extends Controller {
    @FXML
    Text errorText;

    @FXML
    TextField typeField,
            modelField,
            plateNumberField,
            yearField,
            colourField,
            seatsField;

    private String type;
    private String model;
    private String colour;
    private String plateNumber;
    private Integer modelYear;
    private Integer numSeats;

    private void initialize(){}

    @FXML
    private void registerAction(){
        try{
            if (!plateNumberField.getText().toUpperCase().matches("([A-Z]|\\d){5,6}")||
                    !yearField.getText().matches("\\d{4}")){
                throw new Exception();
            }

            numSeats = Integer.parseInt(seatsField.getText());
            modelYear = Integer.parseInt(seatsField.getText());
            type = typeField.getText();
            model = modelField.getText();
            colour = colourField.getText();
            plateNumber = plateNumberField.getText();


            Car car = new Car(type, model, colour, plateNumber, modelYear, numSeats);
            Driver driver = dataStore.getCurrentDriver();
            driver.registerCar(car);

            System.out.println(car.getPlateNumber());
            screenController.loadScreen(Screens.DRIVER.getValue());
        } catch (Exception e){
            errorText.setText("Error. Some fields are not in the correct format");
        }
    }

    @FXML
    private void backAction(){
        screenController.loadScreen(Screens.DRIVER.getValue());
    }
}
