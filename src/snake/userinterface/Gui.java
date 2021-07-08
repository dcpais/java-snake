package snake.userinterface;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui {


    //DIMENSIONS
    private final double SCALE = 1;
    public static int WINDOW_X = 520;
    public static int WINDOW_Y = 560;
    public static int BOARD_PADDING = 20;
    public static final int NUM_CELLS = 19;
    public static int CELL_WIDTH = (WINDOW_X - 2 * BOARD_PADDING) / NUM_CELLS;

    //COLOURS
    private final Color BACKGROUND_COLOR = Color.rgb(74,117,45);

    //MEMBER VARIABLES
    private final Stage stage;
    private final Group root;
    private VBox viewContainer;
    private Board board;
    private StatusBar statusBar;

    //CONSTRUCTOR
    public Gui(Stage primaryStage) {
        this.stage = primaryStage;
        this.root = new Group();
        setupInterface();
    }

    //MEMBER FUNCTIONS
    private void setupInterface() {
        setDimensions();
        setPartitions();
        initStatusBar();
        initBoard();
        stage.show();
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
        stage.setTitle("~Snek~");
        stage.setScene(scene);

        BOARD_PADDING = (int) (BOARD_PADDING * SCALE);
        WINDOW_X = (int) (WINDOW_X * SCALE);
        WINDOW_Y = (int) (WINDOW_Y * SCALE);
        CELL_WIDTH = (int) (CELL_WIDTH * SCALE);
    }
}
