package soulasphyxia;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
@Getter
@Setter
public class Diver extends JLabel {
    private final String path = "src/main/resources/images/diver.png";
    private int x;
    private int y;
    private final int DIVER_WIDTH = 524;
    private final int DIVER_HEIGHT = 700;

    public Diver() {
        super();
        this.setIcon(new ImageIcon(path));
        this.x = 400;
        this.y = 100;
    }

    public void right() {
        this.x += 50;
    }

    public void left() {
        this.x -= 50;
    }


}
