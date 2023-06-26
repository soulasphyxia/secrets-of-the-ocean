package soulasphyxia.ui;

import lombok.Getter;
import lombok.Setter;
import soulasphyxia.Diver;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

@Getter
@Setter
public class GameDisplay extends JPanel {
    private final int DISPLAY_WIDTH = 820;
    private final int DISPLAY_HEIGHT = 400;
    private final Diver diver = new Diver();

    public GameDisplay() {
        super();
        setSize(DISPLAY_WIDTH,DISPLAY_HEIGHT);
        this.setBorder(new LineBorder(Color.decode("#9F0000"),7,true));
        initComponents();
        setVisible(true);
        setLayout(null);
    }


    private void initComponents() {
        diver.setBounds(diver.getX(),diver.getY(),diver.getDIVER_WIDTH(),diver.getDIVER_HEIGHT());
        add(diver);

    }



}
