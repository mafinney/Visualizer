/**
 * LinkedList holds all the nodes in order in an ArrayList, only able to push to the end
 * and pop from the front
 * 
 * Change nodes and edges to be stored in queues for easier popping and drawing edges
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

class JLinkedListPane extends JLayeredPane {
    private LinkedList<DraggablePanel> nodes;
    private LinkedList<Edge> edges;

    public JLinkedListPane() {
        nodes = new LinkedList<>();
        edges = new LinkedList<>();
    }

    public void push(DraggablePanel node) {
        if (nodes.size() > 0) {
            edges.addLast(new Edge(nodes.peekLast(), node));
        }
        nodes.addLast(node);
        add(node);
        repaint();
    }

    public void pop() {
        if (nodes.size() > 0) {
            remove(nodes.peekFirst());
            nodes.removeFirst();
            if (edges.size() > 0) {
                edges.removeFirst();
            }
        }
        repaint();
    }

    protected void paintComponent(Graphics g) {
        for (Edge e : edges) {
            g.drawLine(e.nodeOneLocation().x, e.nodeOneLocation().y, e.nodeTwoLocation().x, e.nodeTwoLocation().y);
        }
        repaint();
    }
}