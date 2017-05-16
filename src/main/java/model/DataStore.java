package model;

import java.util.*;

/**
 * Created by ptg19 on 4/04/17.
 */
public class DataStore {
    private Map<Integer, Driver> drivers;
    private Map<Integer, Passenger> passengers;
    private Driver currentDriver;
    private List<StopPoint> stopPoints;
    private List<Route> routes;

    private static DataStore instance = null;

    public static DataStore getInstance() {
        if (instance == null){
            instance = new DataStore();
        }
        return instance;
    }

    public static void setInstance(DataStore dataStore) {
        instance = dataStore;
    }

    public DataStore() {
        this.drivers = new HashMap<>();
        this.passengers = new HashMap<>();
        this.stopPoints = new ArrayList<>();
        this.routes = new ArrayList<>();
    }

    public void addDriver(Driver driver){
        drivers.put(driver.getId(), driver);
        App.save(instance);
    }
    public void addPassenger(Passenger passenger){
        passengers.put(passenger.getId(), passenger);
        App.save(instance);
    }
    public void addStopPoint(StopPoint stopPoint)
    {
        stopPoints.add(stopPoint);
        App.save(instance);
//        for(StopPoint point: stopPoints){
//            System.out.println(point.getNumber());
//        }
    }

    public void addRoute(Route route){
        routes.add(route);
        App.save(instance);
    }

    public void setCurrentDriver(Driver currentDriver) {
        this.currentDriver = currentDriver;
    }
    public Driver getCurrentDriver() {
        return currentDriver;
    }

    public List<StopPoint> getStopPoints() {
        return stopPoints;
    }

    public Map<Integer, Passenger> getPassengers() {
        return passengers;
    }

    public Map<Integer, Driver> getDrivers() {
        return drivers;
    }
}
