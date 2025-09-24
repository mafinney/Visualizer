import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Visualizer {
    public static void main(String[] args) {
        JFrame window = initFrame("Visualizer");

        JButton addNode = new JButton("Add node");
        addNode.setBounds(0, 0, 150, 30);
        JButton popNode = new JButton("Pop node");
        popNode.setBounds(0, 0, 150, 30);

        window.add(initButtonPanel(addNode, popNode), BorderLayout.NORTH);

        JStack dataStructure = new JStack();
        window.add(dataStructure, BorderLayout.CENTER);

        addNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = JOptionPane.showInputDialog("New node value:");
                dataStructure.push(value);
                window.repaint();
            }
        });

        popNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataStructure.pop();
            }
        });
    
        window.repaint();
        window.setVisible(true);
    }

    public static JFrame initFrame(String name) {
        JFrame window = new JFrame(name);
        window.setLayout(new BorderLayout());
        window.setMinimumSize(new Dimension(600, 400));
        return window;
    }

    public static JPanel initButtonPanel(JButton addNode, JButton popNode) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addNode);
        buttonPanel.add(popNode);
        return buttonPanel;
    }
}