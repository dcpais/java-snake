package snake.userinterface;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import snake.enums.Orientation;

public class Gui implements EventHandler<KeyEvent> {

    //DIMENSIONS
    private final double SCALE = 1;
    public static int WINDOW_X = 520;
    public static int WINDOW_Y = 560;
    public static int BOARD_PADDING = 20;
    public static final int NUM_CELLS = 15;
    public static int CELL_WIDTH = (WINDOW_X - 2 * BOARD_PADDING) / NUM_CELLS;

    //COLOURS
    private final Color BACKGROUND_COLOR = Color.rgb(74,117,45);

    //MEMBER VARIABLES
    private final Stage stage;
    private final Group root;
    private VBox viewContainer;
    private Board board;
    private StatusBar statusBar;
    private Orientation orientation;
    private Snake snake;

    //CONSTRUCTOR
    public Gui(Stage primaryStage) {
        this.stage = primaryStage;
        this.root = new Group();
        this.orientation = Orientation.DOWN;
        setupInterface();
    }

    //MEMBER FUNCTIONS
    public void move(Orientation orientation) {
        snake.move(orientation);
    }

    private void setupInterface() {
        setDimensions();
        setPartitions();
        initStatusBar();
        initBoard();
        initSnake();
        stage.show();
    }

    private void initSnake() {
        this.snake = new Snake(board.getBoard());
    }

    private void initStatusBar() {
        statusBar = new StatusBar();
        viewContainer.getChildren().add(statusBar.getStatusBar());
    }

    private void initBoard() {
        board = new Board();
        viewContainer.getChildren().add(board.getBoard());
    }

    private void setPartitions() {
        viewContainer = new VBox();
        viewContainer.setPrefWidth(WINDOW_X);
        viewContainer.setPrefHeight(WINDOW_Y);
        viewContainer.setAlignment(Pos.TOP_CENTER);
        root.getChildren().add(viewContainer);
    }

    private void setDimensions() {
        Scene scene = new Scene(this.root, WINDOW_X, WINDOW_Y);
        scene.setFill(BACKGROUND_COLOR);
        scene.setOnKeyPressed(this);
        stage.setTitle("~Snek~");
        stage.setScene(scene);

        BOARD_PADDING = (int) (BOARD_PADDING * SCALE);
        WINDOW_X = (int) (WINDOW_X * SCALE);
        WINDOW_Y = (int) (WINDOW_Y * SCALE);
        CELL_WIDTH = (int) (CELL_WIDTH * SCALE);
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case UP: orientation = Orientation.UP; break;
            case DOWN: orientation = Orientation.DOWN; break;
            case LEFT: orientation = Orientation.LEFT; break;
            case RIGHT: orientation = Orientation.RIGHT; break;
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
