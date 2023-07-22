package soulasphyxia.ui;

import javax.swing.*;
import java.awt.*;

public class GameOverDialog extends JDialog {
    private final int WIDTH = 250;
    private final int HEIGHT = 350;
    public GameOverDialog(Frame owner) {
        super(owner,"Игра окончена!");
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
