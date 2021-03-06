package snake.userinterface;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import snake.util.Orientation;
import snake.util.structs.LinkedList;
import snake.util.structs.Node;

import java.util.ArrayList;

public class Snake {

    //CONSTANTS
    private final Color bodyColour = Color.rgb(83, 112, 224);

    //MEMBER VARIABLES
    private TilePane overlay;
    private LinkedList body;

    //CONSTRUCTOR
    public Snake(StackPane master) {
        this.overlay = new TilePane();
        this.body = new LinkedList();
        createSnake(master);
    }

    //MEMBER FUNCTIONS
    public void move(Orientation orientation) {
        return;
    }

    private void createSnake(StackPane master) {
        master.getChildren().add(overlay);
        overlay.setAlignment(Pos.CENTER);
        appendToBody(Gui.WINDOW_X / 2, Gui.WINDOW_Y / 2);
        appendToBody(Gui.WINDOW_X / 2 + 1, Gui.WINDOW_Y / 2);
    }

    private void appendToBody(int x, int y) {
        Rectangle squareToAppend = new Rectangle(x, y, Gui.CELL_WIDTH, Gui.CELL_WIDTH);
        squareToAppend.setFill(bodyColour);
        Node bodyPart = new Node(squareToAppend);
        body.addNode(bodyPart);
        overlay.getChildren().add(squareToAppend);
    }

}
