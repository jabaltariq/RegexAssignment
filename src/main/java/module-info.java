module csf.regexassignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens csf.regexassignment to javafx.fxml;
    exports csf.regexassignment;
}