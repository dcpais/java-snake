package snake;

import javafx.application.Application;
import javafx.stage.Stage;
import snake.logic.SnakeGame;
import snake.userinterface.Gui;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Gui userInterface = new Gui(primaryStage);
        SnakeGame game = new SnakeGame(userInterface);
        try {
            game.start();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
