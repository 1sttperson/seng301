package controllers;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.AccountType;
import model.Driver;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterDriverController extends Controller{

    @FXML private TextField idField;
    @FXML private PasswordField password1Field;
    @FXML private TextField nameField;
    @FXML private TextField mobileNumberField;
    @FXML private TextField emailField;
    @FXML private Text photoText;
    @FXML private Text errorText;
    @FXML private PasswordField password2Field;
    @FXML private TextField addressField;
    @FXML private TextField homeNumberField;
    @FXML private ComboBox licenceTypeMenu;
    @FXML private TextField licenceNumberField;
    @FXML private DatePicker licenceIssuedPicker;
    @FXML private DatePicker licenceExpiryPicker;

    private int id;
    private String password1;
    private String password2;
    private String name;
    private String address;
    private String email;
    private String mobileNumber;
    private String homeNumber;
    private String photoLocation;
    private String licenceType;
    private String licenceNumber;
    private LocalDate licenceIssued;
    private LocalDate licenceExpiry;

    @Override
    public void setup(ScreenController screenController) {
        super.setup(screenController);
        licenceTypeMenu.getItems().addAll(
                "Full for >2 years",
                "Full",
                "Restricted",
                "Learners");
    }

    @FXML void registerAction() {
        try {
            id = Integer.parseInt(idField.getText());
            password1 = password1Field.getText();
            password2 = password2Field.getText();
            name = nameField.getText();
            address = addressField.getText();
            email = emailField.getText();
            mobileNumber = mobileNumberField.getText();
            homeNumber = homeNumberField.getText();
            licenceType = licenceTypeMenu.getValue().toString();
            licenceNumber = licenceNumberField.getText();
            licenceIssued = licenceIssuedPicker.getValue();
            licenceExpiry = licenceExpiryPicker.getValue();


            if (dataStore.getDrivers().get(id) != null ||
                    !password1.equals(password2) || password1.equals("")) {
                throw new Exception();
            }

            Driver driver = new Driver(AccountType.DRIVER, id, password1, email, name, address,
                    homeNumber, mobileNumber, photoLocation, licenceType, licenceNumber, licenceIssued, licenceExpiry);
            dataStore.addDriver(driver);

            screenController.loadScreen(Screens.LOGIN.getValue());
        } catch (Exception e) {
            errorText.setText("Error. Some fields are not in the correct format");
        }
    }

    @FXML
    private void backAction(){
        screenController.loadScreen(Screens.REGISTER_ACCOUNT_TYPE.getValue());
    }

    @FXML
    void photoBrowseAction() {
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
    void selectType() {
        licenceTypeMenu.getTypeSelector();
    }

}