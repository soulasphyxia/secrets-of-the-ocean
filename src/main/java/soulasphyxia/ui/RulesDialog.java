package soulasphyxia.ui;

import javax.swing.*;
import java.awt.*;

public class RulesDialog extends JDialog {
    private final int WIDTH = 250;
    private final int HEIGHT = 350;
    public RulesDialog(Frame owner) {
        super(owner,"Правила");
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        initComponents();
        setVisible(true);
    }


    private void initComponents(){

    }
}
