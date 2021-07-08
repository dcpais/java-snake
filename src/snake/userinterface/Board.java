package snake.userinterface;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Stack;

public class Board {

    //COLORS
    private final Color GRID_LIGHT = Color.rgb(168,217,72);
    private final Color GRID_DARK = Color.rgb(142,204,56);
    private final Color GRID_BACKGROUND = Color.rgb(87,138,52);

    //MEMBER VARIABLES
    private StackPane board;

    //CONSTRUCTOR
    public Board() {
        this.board = new StackPane();
        drawBackground();
        drawBoard();
    }

    private void drawBackground() {
        Rectangle rect = new Rectangle(Gui.WINDOW_X, Gui.WINDOW_X);
        rect.setFill(GRID_BACKGROUND);
        board.getChildren().add(rect);
    }

    private void drawBoard() {
        TilePane boardBackground = new TilePane();
        boardBackground.setMaxSize(Gui.NUM_CELLS * Gui.CELL_WIDTH, Gui.NUM_CELLS * Gui.CELL_WIDTH);
        int counter = 0;

        for (int x = 0; x < Gui.NUM_CELLS * Gui.NUM_CELLS; x++) {
            Rectangle rect = new Rectangle(Gui.CELL_WIDTH, Gui.CELL_WIDTH);
            if (counter % 2 == 0) {
                rect.setFill(GRID_LIGHT);
            } else {
                rect.setFill(GRID_DARK);
            }
            boardBackground.getChildren().add(rect);
            counter++;
        }
        boardBackground.setAlignment(Pos.CENTER);
        board.getChildren().add(boardBackground);
    }

    //GETTERS
    public StackPane getBoard() {
        return board;
    }
}
