package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.StopPoint;

/**
 * Created by ptg19 on 23/04/17.
 */
public class CreateStopPointController extends Controller{
    @FXML
    Text errorText;
    @FXML
    TextField numberField, streetField, suburbField;

    public void initialize(){
    }

    @FXML
    private void createAction(){
        StopPoint stopPoint = new StopPoint(Integer.parseInt(numberField.getText()), streetField.getText(), suburbField.getText());

        if (dataStore.getStopPoints().contains(stopPoint)){
            errorText.setText("A stop point with that address already exists");
        } else {
            dataStore.addStopPoint(stopPoint);
            screenController.loadScreen(Screens.DRIVER.getValue());
        }
    }

    @FXML
    private void backAction(){
        screenController.loadScreen(Screens.DRIVER.getValue());
    }
}
