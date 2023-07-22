package soulasphyxia.objects;

import lombok.Getter;
import lombok.Setter;
import soulasphyxia.utils.ResourcesLoader;

import javax.swing.*;

@Getter
@Setter
public class Octopus extends JLabel {
    private String path = "images/octopus.png";
    private int x;
    private int y;
    private final int OCTOPUS_WIDTH = 378;
    private final int OCTOPUS_HEIGHT = 157;
    private final ResourcesLoader rl = new ResourcesLoader();
    public Octopus() {
        super();
        this.x = 230;
        this.y = 90;
        setIcon(new ImageIcon(rl.getResource(path)));
    }
}
