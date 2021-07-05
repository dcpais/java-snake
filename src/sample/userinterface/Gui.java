package sample.userinterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Gui {

    //CONSTANTS
    public static final double BOARD_PADDING = 10;

    //MEMBERS
    private Stage stage;

    public Gui(Stage primaryStage) {
        this.stage = primaryStage;
        try {
            setupInterface();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupInterface() throws IOException {
        Parent root = new Group();
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }
}
