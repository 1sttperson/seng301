package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.DataStore;
import model.Route;
import model.StopPoint;

import java.util.ArrayList;
import java.util.List;

public class CreateRouteController extends Controller{

    @FXML private Text errorText;
    @FXML private TextField searchField;

    @FXML private TableView<StopPoint> stopPointTable, routeTable;

    @FXML private TableColumn<StopPoint, Integer> routeNumber;
    @FXML private TableColumn<StopPoint, String> routeStreet;
    @FXML private TableColumn<StopPoint, String> routeSuburb;
    @FXML private TableColumn<StopPoint, Integer> stopPointNumber;
    @FXML private TableColumn<StopPoint, String> stopPointStreet;
    @FXML private TableColumn<StopPoint, String> stopPointSuburb;

    private List<StopPoint> stopPointList;
    private List<StopPoint> routeList;


    @Override
    public void setup(ScreenController screenController){
        this.screenController = screenController;
        this.dataStore = dataStore;

        stopPointList = FXCollections.observableArrayList(dataStore.getStopPoints());

        setupStopPointsSortAndFilter();
        stopPointNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        stopPointStreet.setCellValueFactory(new PropertyValueFactory<>("street"));
        stopPointSuburb.setCellValueFactory(new PropertyValueFactory<>("suburb"));

        routeList = FXCollections.observableArrayList(new ArrayList<StopPoint>());
        routeTable.setItems((ObservableList<StopPoint>) routeList);
        routeNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        routeStreet.setCellValueFactory(new PropertyValueFactory<>("street"));
        routeSuburb.setCellValueFactory(new PropertyValueFactory<>("suburb"));
    }

    private void setupStopPointsSortAndFilter(){
        FilteredList<StopPoint> filteredStopPoints = new FilteredList<>((ObservableList<StopPoint>) stopPointList, p -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredStopPoints.setPredicate(stopPoint -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (Integer.toString(stopPoint.getNumber()).contains(lowerCaseFilter) ||
                        stopPoint.getStreet().toLowerCase().contains(lowerCaseFilter) ||
                        stopPoint.getSuburb().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<StopPoint> sortedFilteredStopPoints = new SortedList<>(filteredStopPoints);
        sortedFilteredStopPoints.comparatorProperty().bind(stopPointTable.comparatorProperty());

        stopPointTable.setItems(sortedFilteredStopPoints);
    }

    @FXML
    private void addPointAction(){
        StopPoint selectedItem = stopPointTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            routeList.add(selectedItem);
            stopPointList.remove(selectedItem);
            stopPointTable.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void removePointAction(){
        StopPoint selectedItem = routeTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            stopPointList.add(selectedItem);
            routeList.remove(selectedItem);
            routeTable.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void createAction(){
        Route route = new Route(routeList);
        dataStore.addRoute(route);

        screenController.loadScreen(Screens.DRIVER.getValue());
    }

    @FXML
    private void backAction(){
        screenController.loadScreen(Screens.DRIVER.getValue());
    }
}
