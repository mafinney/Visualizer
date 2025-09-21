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
        JButton popNode = new JButton("Pop node");
        popNode.setBounds(0, 0, 150, 30);

        LinkedList list = new LinkedList();

        addNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = JOptionPane.showInputDialog("New node value:");
                DraggablePanel newNode = new DraggablePanel(value);
                newNode.setBounds(50, 50, 100, 30);
                list.push(newNode);
                window.repaint();
            }
        });

        popNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.pop();
            }
        });

        window.add(list, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addNode);
        buttonPanel.add(popNode);
        window.add(buttonPanel, BorderLayout.NORTH);
    
        window.repaint();
        window.setVisible(true);
    }
}