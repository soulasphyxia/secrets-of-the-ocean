package soulasphyxia.objects;

import lombok.Getter;
import lombok.Setter;
import soulasphyxia.utils.PositionFrame;
import soulasphyxia.utils.ResourcesLoader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@Getter
@Setter
public class Tentacle extends JLabel implements ActionListener {
    private int x;
    private int y;
    private String path = "images/";
    private int TENTACLE_WIDTH;
    private int TENTACLE_HEIGHT;
    private final Timer timer;
    private int frameIndex;
    private boolean reverse;
    private ArrayList<PositionFrame> frames;
    private boolean isTip = false;
    private int tentacleSpeed;
    private ResourcesLoader rl = new ResourcesLoader();

    public Tentacle(ArrayList<PositionFrame> frames) {
        super();
        frameIndex = 0;
        this.frames = frames;
        setFrame(frames.get(0));
        timer = new Timer(tentacleSpeed,this);
        timer.setInitialDelay(0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(frameIndex < frames.size() && !reverse) {
            setFrame(frames.get(frameIndex));
            if(frameIndex  == frames.size() - 1) {
                isTip = true;
            }
            frameIndex++;
            isTip = false;
        }
        else {
            isTip = false;
            reverse = true;
            if(frameIndex > 0) {
                setFrame(frames.get(--frameIndex));
            }
            if(frameIndex == 0) {
                reverse = false;
            }
            if(frameIndex == 14) {
                reverse = false;
                frameIndex = 0;
            }
        }
    }

    public void setFrame(PositionFrame frame) {
        this.x = frame.getX();
        this.y = frame.getY();
        ImageIcon icon = new ImageIcon(rl.getResource(path + frame.getSrc()));
        setIcon(icon);
        setBounds(x,y,icon.getIconWidth(),icon.getIconHeight());
    }

}


