package controllers;

import com.sun.prism.image.CachingCompoundImage;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import model.DataStore;
import model.Route;
import model.StopPoint;

public class CreateTripController extends Controller{
    @FXML private Text errorText;

    @FXML private TableView routesTable;
    @FXML private TableColumn routeNameColumn;

    @FXML private TableView<StopPoint> stopPointTable;

    @FXML private TableColumn<StopPoint, Integer> numberColumn;
    @FXML private TableColumn<StopPoint, String> streetColumn;
    @FXML private TableColumn<StopPoint, String> suburbColumn;
    @FXML private TableColumn<StopPoint, String> stopTimeColumn;

    private ObservableList<StopPoint> stopPoints;
    private ObservableList<Route> routes;

    @Override
    public void setup(ScreenController screenController){
        this.screenController = screenController;
        this.dataStore = DataStore.getInstance();

        routes = FXCollections.observableArrayList(dataStore.getRoutes());
        routeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        routesTable.setItems(routes);

//        stopPoints = FXCollections.observableArrayList(dataStore.getStopPoints());
//        stopPointTable.setItems(stopPoints);
        stopPointTable.setEditable(true);
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        streetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
        suburbColumn.setCellValueFactory(new PropertyValueFactory<>("suburb"));
        stopTimeColumn.setCellValueFactory(new PropertyValueFactory<>("stopTime"));
        stopTimeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        stopTimeColumn.setOnEditCommit(
            t -> (t.getTableView().getItems().get(
                t.getTablePosition().getRow())
            ).setStopTime(t.getNewValue())
        );
        setRouteListener();
    }

    private void setRouteListener(){
        routesTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Route route = (Route)routesTable.getSelectionModel().getSelectedItem();
                stopPointTable.setItems(FXCollections.observableArrayList(route.getStopPoints()));
            }
        });
    }

    @FXML
    void selectCarAction() {

    }

    @FXML
    void createAction() {

    }

    @FXML
    void backAction() {
        screenController.loadScreen(Screens.DRIVER.getValue());
    }
}
