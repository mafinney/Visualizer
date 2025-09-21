/**
 * LinkedList holds all the nodes in order in an ArrayList, only able to push to the end
 * and pop from the front
 * 
 * Change nodes and edges to be stored in queues for easier popping and drawing edges
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

class LinkedList extends JLayeredPane {
    private ArrayList<DraggablePanel> nodes;
    private ArrayList<Edge> edges;
    private int curr;
    private int head;

    public LinkedList() {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        curr = -1;
        head = 0;
    }

    public void push(DraggablePanel node) {
        if (!nodes.isEmpty()) {
            edges.add(new Edge(nodes.get(curr), node));
        }
        nodes.add(node);
        add(node);
        curr++;
        repaint();
    }

    public void pop() {
        if (head < edges.size()) {
            remove(nodes.get(0));
            edges.set(head, null);
            head++;
        }
    }

    protected void paintComponent(Graphics g) {
        for (Edge e : edges) {
            g.drawLine(e.nodeOneLocation().x, e.nodeOneLocation().y, e.nodeTwoLocation().x, e.nodeTwoLocation().y);
        }
        repaint();
    }
}