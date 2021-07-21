package snake.util.structs;

public class LinkedList {

    //MEMBER VARIABLES
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(Node newNode) {

        //If no nodes exist in list:
        if (this.head == null) { this.head = newNode; this.tail = newNode; return; }

        //Else, find the end of the snake and add the node:
        Node currentNode = this.head;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }

        currentNode.setNextNode(newNode);
        this.tail = newNode;

    }
}
