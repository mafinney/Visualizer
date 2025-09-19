/**
 * Graph holds all DraggablePanels in the data structure, connected or not
 * Graph also holds all edges and only draws lines between connected DraggablePanels from the edges list
 * 
 * Order for adding nodes to graph:
 *  1. Add the node to the graph object's node list
 *  2. Add any edges between the new node and existing nodes in the graph, if needed ex. Graph.addEdge(DraggablePanel n1, DraggablePanel n2);
 * 
 * Drawing edges:
 *  1. Iterate over edges list making a new list of lines connecting the src and dest nodes at each edge
 *  2. Draw each line in the new list of lines to the window
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.*;

class Graph extends JLayeredPane {
    private ArrayList<DraggablePanel> nodes;
    private ArrayList<Edge> edges;

    public Graph() {
        super();
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addNode(DraggablePanel node) {
        nodes.add(node);
        add(node);
        repaint();
    }

    public void addEdge(DraggablePanel nodeOne, DraggablePanel nodeTwo) {
        edges.add(new Edge(nodeOne, nodeTwo));
        repaint();
    }

    protected void paintComponent(Graphics g) {
        for (Edge e : edges) {
            g.drawLine(e.nodeOneLocation().x, e.nodeOneLocation().y, e.nodeTwoLocation().x, e.nodeTwoLocation().y);
        }
        repaint();
    }
}

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
}