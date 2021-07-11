package snake.logic;

import snake.enums.Orientation;
import snake.userinterface.Gui;

public class SnakeGame {

    //MEMBER VARIABLES
    private Gui viewHandle;
    boolean updated;

    //CONSTRUCTOR
    public SnakeGame(Gui userInterface) {
        this.viewHandle = userInterface;
    }

    //MEMBER FUNCTIONS
    public void start() {
        int counter = 0;
        boolean run = true;

    }

    private void updateView() {
        Orientation orientation = viewHandle.getOrientation();
        switch (orientation) {
            case UP -> viewHandle.move(Orientation.UP);
            case DOWN -> viewHandle.move(Orientation.DOWN);
            case LEFT -> viewHandle.move(Orientation.LEFT);
            case RIGHT -> viewHandle.move(Orientation.RIGHT);
        }

    }

}
