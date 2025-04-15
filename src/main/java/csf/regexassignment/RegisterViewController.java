package csf.regexassignment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.regex.*;

import static csf.regexassignment.Main.*;

/**
 * @author Aidan Rodriguez
 * @since 4/14/2025
 */
public class RegisterViewController {
    public static final Pattern NAME_PATTERN = Pattern.compile("[(A-Za-z)]{2,25}");
    public static final Pattern DOB_PATTERN = Pattern.compile("((\\d{2})/(\\d{2})/(\\d{4}))");
    public static final Pattern EMAIL_PATTERN = Pattern.compile("([A-Za-z\\d])+@farmingdale\\.edu");
    public static final Pattern ZIP_PATTERN = Pattern.compile("[\\d]{5}");

    public static boolean firstNameValid = false;
    public static boolean lastNameValid = false;
    public static boolean dobValid = false;
    public static boolean emailValid = false;
    public static boolean zipValid = false;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField dobField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField zipField;

    @FXML
    private Button registerButton;

    @FXML
    private Label firstNameFeedback;

    @FXML
    private Label lastNameFeedback;

    @FXML
    private Label dobFeedback;

    @FXML
    private Label emailFeedback;

    @FXML
    private Label zipFeedback;

    /**
     * Checks if the firstNameField contains a valid value (contains 2 - 25 letters). If firstNameField satisfies this
     * condition, feedback is given to the user, and the field is marked as a valid field.
     */
    @FXML
    private void firstNameCheck() {
        Matcher m = NAME_PATTERN.matcher(firstNameField.getText());
        if (!m.matches()) {
            firstNameValid = false;
            firstNameFeedback.setTextFill(Color.RED);
            firstNameFeedback.setText("First name must be 2 - 25 characters.");
        }
        else {
            firstNameValid = true;
            firstNameFeedback.setTextFill(Color.GREEN);
            firstNameFeedback.setText("Valid input received!");
        }
        checkAllFields();
    }

    /**
     * Checks if the lastNameField contains a valid value (contains 2 - 25 letters). If lastNameField satisfies this
     * condition, feedback is given to the user, and the field is marked as a valid field.
     */
    @FXML
    private void lastNameCheck() {
        Matcher m = NAME_PATTERN.matcher(lastNameField.getText());
        if (!m.matches()) {
            lastNameValid = false;
            lastNameFeedback.setTextFill(Color.RED);
            lastNameFeedback.setText("Last name must be 2 - 25 characters.");
        }
        else {
            lastNameValid = true;
            lastNameFeedback.setTextFill(Color.GREEN);
            lastNameFeedback.setText("Valid input received!");
        }
        checkAllFields();
    }

    /**
     * Checks if the dobField contains a valid values (text in MM/DD/YYYY format). If dobField satisfies this condition,
     * feedback is given to the user, and the field is marked as a valid field.
     * @throws IllegalStateException While the user is typing, the field will not contain any valid groups for the
     * Matcher to parse. The IllegalStateException is handled by informing the user that a valid response has not been
     * given yet.
     */
    @FXML
    private void dobCheck() {
        try {
            Matcher m = DOB_PATTERN.matcher(dobField.getText());
            dobFeedback.setTextFill(Color.RED);
            dobValid = false;
            if (m.matches()) {
                int month = Integer.parseInt(m.group(2));
                int day = Integer.parseInt(m.group(3));
                int year = Integer.parseInt(m.group(4));
                if (month > 12 || month == 0) {
                    dobFeedback.setText("That is an invalid month.");
                } else if (day > 31 || day == 0) {
                    dobFeedback.setText("That is an invalid day.");
                } else if (year < 999 || year > 2025) {
                    dobFeedback.setText("That is an invalid year.");
                } else {
                    dobFeedback.setTextFill(Color.GREEN);
                    dobFeedback.setText("Valid input received!");
                    dobValid = true;
                }
            } else {
                dobFeedback.setText("Date must be in mm/dd/yyyy format.");
            }
        }
        catch (IllegalStateException e) {
            dobFeedback.setText("Date must be in mm/dd/yyyy format.");
            System.out.println("Date is not in proper format!");
        }
        checkAllFields();
    }

    /**
     * Checks if the emailField contains a valid value (contains exactly 5 digits). If emailField satisfies this
     * condition, feedback is given to the user, and the field is marked as a valid field.
     */
    @FXML
    private void emailCheck() {
        Matcher m = EMAIL_PATTERN.matcher(emailField.getText());
        if (!m.matches()) {
            emailValid = false;
            emailFeedback.setTextFill(Color.RED);
            emailFeedback.setText("Email must be a valid Farmingdale email.");
        }
        else {
            emailValid = true;
            emailFeedback.setTextFill(Color.GREEN);
            emailFeedback.setText("Valid input received!");
        }
        checkAllFields();
    }

    /**
     * Checks if the zipField contains a valid value (contains exactly 5 digits). If zipField satisfies this condition,
     * feedback is given to the user, and the field is marked as a valid field.
     */
    @FXML
    private void zipCheck() {
        Matcher m = ZIP_PATTERN.matcher(zipField.getText());
        if (!m.matches()) {
            zipValid = false;
            zipFeedback.setTextFill(Color.RED);
            zipFeedback.setText("Zip code must be 5 digits.");
        }
        else {
            zipValid = true;
            zipFeedback.setTextFill(Color.GREEN);
            zipFeedback.setText("Valid input received!");

        }
        checkAllFields();
    }

    @FXML
    private void registerClicked() throws IOException {
        name = firstNameField.getText() + " " + lastNameField.getText();
        dob = dobField.getText();
        zip = zipField.getText();
        email = emailField.getText();
        Main.setScene("registered-view");
    }
    /**
     * Checks if all the boolean values associated with a Text Field are true. If all the values are true, the
     * registerButton will be enabled. Otherwise, the Button will remain inaccessible.
     */
    private void checkAllFields() {
        if (firstNameValid && lastNameValid && emailValid && dobValid && zipValid) {
            registerButton.setDisable(false);
        }
        else {
            registerButton.setDisable(true);
        }
    }


}
