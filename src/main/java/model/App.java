package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controllers.ScreenController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;

public class App extends Application {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void start(Stage stage) throws Exception {
        try {
            DataStore.setInstance(load());
        } catch (Exception e) {
        }
        ScreenController screenController = new ScreenController(stage);
        screenController.initialize();

        stage.setTitle("UC RSS");
        stage.show();
    }

    public static DataStore load() throws UnsupportedEncodingException {
        Reader reader = new InputStreamReader(App.class.getResourceAsStream("/savedData/data.json"), "UTF-8");
        return gson.fromJson(reader, DataStore.class);
    }

    public static void save(DataStore dataStore) {
        try {
            Writer writer;
            writer = new OutputStreamWriter(new FileOutputStream("src/main/resources/savedData/data.json"), "UTF-8");
            gson.toJson(dataStore, writer);
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
