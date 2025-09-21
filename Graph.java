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

import java.awt.event.*;

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


    // GRAPH TESTING
    public static void main(String[] args) {
        JFrame window = new JFrame("Graph");
        window.setLayout(new BorderLayout());
        window.setMinimumSize(new Dimension(600, 400));

        JButton addNode = new JButton("add node");
        addNode.setBounds(0, 0, 150, 30);

        Graph g = new Graph();

        addNode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String value = JOptionPane.showInputDialog("new node value:");
                DraggablePanel newNode = new DraggablePanel(value);
                newNode.setBounds(50, 50, 100, 30);
                DraggablePanel tmp = new DraggablePanel("tmp");
                tmp.setBounds(50, 50, 100, 30);

                g.addNode(newNode);
                g.addNode(tmp);
                g.addEdge(newNode, tmp);
                window.repaint();
            }
        });

        window.add(addNode, BorderLayout.NORTH);
        window.add(g, BorderLayout.CENTER);

        window.setVisible(true);
    }
}