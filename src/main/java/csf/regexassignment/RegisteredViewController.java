package csf.regexassignment;

import static csf.regexassignment.Main.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author Aidan Rodriguez
 */
public class RegisteredViewController {
    @FXML
    private Button loadUserButton;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label zipLabel;

    @FXML
    private Label dobLabel;

    /**
     * Initiated on press of the loadUserButton. It will take information from static variables in main to display this
     * information to the user.
     */
    @FXML
    public void loadUser() {
        welcomeLabel.setText("Welcome, " + name);
        emailLabel.setText("Email: " + email);
        zipLabel.setText("Zip Code: " + zip);
        dobLabel.setText("Date of Birth: " + dob);
        loadUserButton.setOpacity(0.0);
    }
}
