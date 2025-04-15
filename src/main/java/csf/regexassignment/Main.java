package csf.regexassignment;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static String name;
    public static String dob;
    public static String email;
    public static String zip;
    public static Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("register-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Register here...");
        stage.setScene(scene);
        stage.show();
    }

    public static void setScene(String newScene) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(newScene + ".fxml"));
        scene.setRoot(fxmlLoader.load());
    }

    public static void main(String[] args) {
        launch();
    }
}