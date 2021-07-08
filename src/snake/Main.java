package snake;

import javafx.application.Application;
import javafx.stage.Stage;
import snake.userinterface.Gui;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Gui userInterface = new Gui(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
