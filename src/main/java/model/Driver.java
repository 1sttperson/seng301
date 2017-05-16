package model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Driver extends Account{

    private String licenceType;
    private String licenceNumber;
    private LocalDate licenceIssued;
    private LocalDate licenceExpiry;
    private Map<String, Car> registeredCars;


    public Driver(AccountType type, int id, String password, String email, String name,
                  String address, String homeNumber, String mobileNumber, String photoLocation,
                  String licenceType, String licenceNumber, LocalDate licenceIssued, LocalDate licenceExpiry) {
        super(type, id, password, email, name, address, homeNumber, mobileNumber, photoLocation);

        this.licenceType = licenceType;
        this.licenceNumber = licenceNumber;
        this.licenceIssued = licenceIssued;
        this.licenceExpiry = licenceExpiry;
        this.registeredCars = new HashMap<>();
    }


    public void registerCar(Car car){
        registeredCars.put(car.getPlateNumber(), car);
    }
}
