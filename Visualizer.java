import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Visualizer {
    public static void main(String[] args) {
        JFrame window = new JFrame("Visualizer");
        window.setLayout(new BorderLayout());
        window.setMinimumSize(new Dimension(600, 400));
        
        JButton addNode = new JButton("Add node");
        addNode.setBounds(0, 0, 150, 30);

        DraggablePanel head = new DraggablePanel("head");
        head.setBounds(50, 50, 100, 30);
        DraggablePanel tail = new DraggablePanel("tail");
        tail.setBounds(50, 50, 100, 30);
        Graph graph = new Graph();
        graph.addNode(head);
        graph.addNode(tail);
        graph.addEdge(head, tail);

        addNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = JOptionPane.showInputDialog("New node value:");
                DraggablePanel newNode = new DraggablePanel(value);
                newNode.setBounds(50, 50, 100, 30);
                DraggablePanel tmp = new DraggablePanel("tmp");
                tmp.setBounds(50, 50, 100, 30);
                graph.addNode(newNode);
                graph.addNode(tmp);
                graph.addEdge(newNode, tmp);
                window.repaint();
            }
        });

        window.add(graph, BorderLayout.CENTER);
        window.add(addNode, BorderLayout.NORTH);
    
        window.repaint();
        window.setVisible(true);
    }
}