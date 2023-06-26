package soulasphyxia.ui;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
@Getter
public class MenuButton extends JButton {


    private final int MENU_BTN_WIDTH = 50;
    private final int MENU_BTN_HEIGHT = 25;

    private final Font menuFont = new Font(Font.MONOSPACED,Font.PLAIN,64);
    public MenuButton() {
        super();
        setSize(MENU_BTN_WIDTH,MENU_BTN_HEIGHT);
        setBackground(Color.decode("#D9D9D9"));
        setBorder(new LineBorder(Color.decode("#9F0000"),4,true));
    }
}
