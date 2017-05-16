package controllers;


import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.AccountType;
import model.Passenger;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPassengerController extends Controller {

    @FXML
    private Text errorText;
    @FXML
    private Text photoText;
    @FXML
    private TextField idField,
            nameField,
            addressField,
            emailField,
            mobileNumberField,
            homeNumberField;
    @FXML
    private PasswordField password1Field;
    @FXML
    private PasswordField password2Field;

    private int id;
    private String password1;
    private String password2;
    private String name;
    private String address;
    private String email;
    private String mobileNumber;
    private String homeNumber;
    private String photoLocation;

    @FXML
    private void registerAction() {
        try {
            id = Integer.parseInt(idField.getText());
            password1 = password1Field.getText();
            password2 = password2Field.getText();
            name = nameField.getText();
            address = addressField.getText();
            email = emailField.getText();
            mobileNumber = mobileNumberField.getText();
            homeNumber = homeNumberField.getText();

            if (dataStore.getPassengers().get(id) != null ||
                    !password1.equals(password2) || password1.equals("")) {
                throw new Exception();
            }

            Passenger passenger = new Passenger(AccountType.PASSENGER, id, password1, email, name, address, homeNumber, mobileNumber, photoLocation);
            dataStore.addPassenger(passenger);

            screenController.loadScreen(Screens.LOGIN.getValue());
        } catch (Exception e) {
            errorText.setText("Error. Some fields are not in the correct format");
        }
    }

    @FXML
    private void photoBrowseAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Photo");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        final Stage dialog = new Stage();
        File selectedFile = fileChooser.showOpenDialog(dialog);
        if (selectedFile != null) {
            Pattern pattern = Pattern.compile("/[^/]*\\.[^/]*");
            Matcher matcher = pattern.matcher(selectedFile.toString());
            try {
                matcher.find();
                String fileString = matcher.group(0).substring(1);
                photoText.setText(fileString);
                String extension = fileString.substring(fileString.length() - 3);
                File outputFile = new File("src/main/resources/savedData/" + fileString);
                Image photo = new Image(selectedFile.toURI().toString());
                ImageIO.write(SwingFXUtils.fromFXImage(photo, null), extension, outputFile);
                photoLocation = "/savedData/"+fileString;
            } catch (IOException e) {
                errorText.setText("Error uploading photo");
            } catch (Exception e) {
                errorText.setText("Error in filename format");
            }
        }
    }

    @FXML
    void backAction() {
        screenController.loadScreen(Screens.REGISTER_ACCOUNT_TYPE.getValue());
    }
}
