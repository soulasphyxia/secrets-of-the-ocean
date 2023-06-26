package soulasphyxia.ui;

import javax.swing.*;
import java.awt.*;

public class MovementButton extends JButton {
    public MovementButton() {
        super();
        setBackground(Color.decode("#E50000"));
        setFocusable(false);
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);

    }
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.decode("#9F0000"));
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(Color.decode("#9F0000"));
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }



}
