package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.DataStore;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by ptg19 on 4/04/17.
 */
public class ScreenController{
    Stage stage;
    DataStore dataStore;

    public ScreenController(Stage stage) {
        this.stage = stage;
    }
    public void initialize(){
        loadScreen(Screens.LOGIN.getValue());
    }

    public void loadScreen(String url) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(url));
            Parent root = loader.load();
            Controller controller = loader.getController();
            controller.setup(this);
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
