package soulasphyxia.objects;
import lombok.Getter;
import lombok.Setter;
import soulasphyxia.utils.PositionFrame;
import soulasphyxia.utils.ResourcesLoader;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Diver extends JLabel {
    private String path = "images/diver_0.png";
    private int x;
    private int y;
    private int DIVER_WIDTH = 90;
    private int DIVER_HEIGHT = 90;
    private int frameIndex;
    private boolean treasure;
    private int score;
    private boolean isDead;
    private PositionFrame dieFrame;
    ArrayList<PositionFrame> frames;

    private ResourcesLoader rl = new ResourcesLoader();
    public Diver() {
        super();
        this.setIcon(new ImageIcon(rl.getResource(path)));
        this.x = 33;
        this.y = 0;
        this.frameIndex = 0;
        this.score = 0;
        this.treasure = false;
        this.isDead = false;
        this.frames = new ArrayList<>(List.of(new PositionFrame(33,0,"images/diver_0.png",90,90),
                                              new PositionFrame(33,93,"images/diver_1.png",30,30),
                                              new PositionFrame(53,223,"images/diver_2.png",90,90),
                                              new PositionFrame(149,280,"images/diver_3.png",90,90),
                                              new PositionFrame(260,280,"images/diver_4.png",90,90),
                                              new PositionFrame(390,285,"images/diver_5.png",90,90)
                ));

        dieFrame = new PositionFrame(357,200,"images/diver_die.png");
    }

    public void nextFrame() {
        if(frameIndex + 1 < frames.size()) {
            setFrame(frames.get(++frameIndex));
        }else {
            treasure = true;
            score++;
        }
    }

    public void prevFrame() {
        if(frameIndex > 0) {
            if(!treasure && frameIndex == 1) {
                setFrame(frames.get(1));
            }else {
                setFrame(frames.get(--frameIndex));
            }
        }
    }


    public void setFrame(PositionFrame frame) {
        this.x = frame.getX();
        this.y = frame.getY();
        this.path = frame.getSrc();
        ImageIcon icon = new ImageIcon(rl.getResource(path));
        this.setIcon(icon);
        setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
    }
}
