/**
 * JQueue is a JLayeredPane object that adds and removes nodes like a queue would
 * JQueue implements LinearDataStructure
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class JQueue extends JLayeredPane implements LinearDataStructure {
    private Deque<DraggablePanel> nodes;
    private Deque<Edge> edges;

    public JQueue() {
        nodes = new ArrayDeque<>();
        edges = new ArrayDeque<>();
    }

    public void push(String str) {
        DraggablePanel node = new DraggablePanel(str);

        add(node); // add to pane

        // If there is other nodes already, then an edge also needs to be added
        if (!nodes.isEmpty()) {
            edges.offerLast(new Edge(nodes.peekLast(), node));
        }

        nodes.offerLast(node);
        repaint();
    }

    public void pop() {
        if (!nodes.isEmpty()) {
            remove(nodes.peekFirst()); // remove from pane
            nodes.pollFirst();
        }
        if (!edges.isEmpty()) {
            edges.pollFirst();
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