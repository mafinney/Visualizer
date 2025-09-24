/**
 * JStack is a JLayeredPane object that adds and removes nodes like a stack would
 * JStack implements LinearDataStructure
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class JStack extends JLayeredPane implements LinearDataStructure {
    private Stack<DraggablePanel> nodes;
    private Stack<Edge> edges;

    public JStack() {
        nodes = new Stack<>();
        edges = new Stack<>();
    }

    public void push(String str) {
        DraggablePanel node = new DraggablePanel(str);

        add(node); // add to pane

        // If there is other nodes already in the stack, then an edge also needs to be added
        if (!nodes.isEmpty()) {
            edges.push(new Edge(nodes.peek(), node));
        }

        nodes.push(node);
        repaint();
    }

    public void pop() {
        if (!nodes.isEmpty()) {
            remove(nodes.peek()); // remove from pane
            nodes.pop();
        }
        if (!edges.isEmpty()) {
            edges.pop();
        }
        repaint();
    }

    public void clear() {
        removeAll(); // remove all from pane
        nodes.clear();
        edges.clear();
    }

    protected void paintComponent(Graphics g) {
        for (Edge e : edges) {
            g.drawLine(e.nodeOneLocation().x, e.nodeOneLocation().y, e.nodeTwoLocation().x, e.nodeTwoLocation().y);
        }
        repaint();
    }
}