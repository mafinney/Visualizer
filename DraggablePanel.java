/**
 * DraggablePanel is a JPanel object that contains a JLabel and can be dragged accross the parent container
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DraggablePanel extends JPanel {
    private JLabel label;
    private Point mouseClickLocation;

    public DraggablePanel(String str) {
        super();
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label = new JLabel(str);
        add(label, SwingConstants.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    mouseClickLocation = e.getPoint();
                } else {
                    mouseClickLocation = null;
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (mouseClickLocation == null) {
                    return ;
                }

                Point currLocation = getLocation();
                Point newLocation = new Point(currLocation.x + e.getX() - mouseClickLocation.x, currLocation.y + e.getY() - mouseClickLocation.y);
                Dimension parentBounds = getParent().getSize();

                if (inBounds(newLocation, parentBounds)) {
                    setLocation(newLocation);
                }
            }
        });
    }

    public boolean inBounds(Point point, Dimension bounds) {
        if (point.x < 0 || point.y < 0) {
            return false;
        } else if (point.x > (bounds.getWidth() - getWidth()) || point.y > (bounds.getHeight() - getHeight())) {
            return false;
        } else {
            return true;
        }
    }

    public String getValue() {
        return label.getText();
    }

    public void setValue(String str) {
        label.setText(str);
        repaint();
    }
}