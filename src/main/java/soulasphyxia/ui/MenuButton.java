package soulasphyxia.ui;
import lombok.Getter;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
@Getter
public class MenuButton extends JButton {


    private final int MENU_BTN_WIDTH = 60;
    private final int MENU_BTN_HEIGHT = 30;

    public MenuButton() {
        super();
        setSize(MENU_BTN_WIDTH,MENU_BTN_HEIGHT);
        setBackground(Color.decode("#D9D9D9"));
        setBorder(new EmptyBorder(0,0,0,0));

    }

}
