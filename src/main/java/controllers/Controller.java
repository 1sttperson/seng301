package controllers;

import model.DataStore;

public abstract class Controller {
    ScreenController screenController;
    DataStore dataStore;

    public void setup(ScreenController screenController){
        this.screenController = screenController;
        this.dataStore = DataStore.getInstance();
    }
}
