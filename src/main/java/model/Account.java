package model;

import javafx.scene.image.Image;

/**
 * Created by ptg19 on 7/05/17.
 */
public abstract class Account {
    private AccountType type;
    private int id;
    private String password;
    private String email;
    private String name;
    private String address;
    private String homeNumber;
    private String mobileNumber;
    private String photoLocation;

    public Account(AccountType type, int id, String password, String email, String name, String address, String homeNumber, String mobileNumber, String photoLocation) {
        this.type = type;
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.address = address;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
        this.photoLocation = photoLocation;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
