package model;

import javafx.scene.image.Image;

/**
 * Created by ptg19 on 8/05/17.
 */
public class Passenger extends Account{

    public Passenger(AccountType type, int id, String password, String email, String name, String address, String homeNumber, String mobileNumber, String photoLocation) {
        super(type, id, password, email, name, address, homeNumber, mobileNumber, photoLocation);
    }
}
