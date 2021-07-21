package snake.util.structs;

import javafx.scene.shape.Rectangle;

public class Node {

    //MEMBER VARIABLES
    private Rectangle bodyPart;
    private Node nextNode;

    //CONSTRUCTOR
    public Node(Rectangle rect) {
        this.bodyPart = rect;
        this.nextNode = null;
    }

    //GETTER SETTER FUNCTIONS
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    public Rectangle getRect() {
        return this.bodyPart;
    }

}
