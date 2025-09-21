import java.awt.*;

class Edge {
    private DraggablePanel nodeOne;
    private DraggablePanel nodeTwo;

    public Edge(DraggablePanel nodeOne, DraggablePanel nodeTwo) {
        this.nodeOne = nodeOne;
        this.nodeTwo = nodeTwo;
    }

    public Point nodeOneLocation() {
        return nodeOne.getLocation();
    }

    public Point nodeTwoLocation() {
        return nodeTwo.getLocation();
    }

    public boolean containsNode(DraggablePanel node) {
        return (nodeOne.equals(node) || nodeTwo.equals(node));
    }
}