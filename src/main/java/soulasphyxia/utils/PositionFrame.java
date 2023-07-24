package soulasphyxia.utils;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class PositionFrame {
    private final int x;
    private final int y;
    private int x_hit;
    private int y_hit;
    private final String src;
    private int width;
    private int height;
    private boolean isLastFrame = false;

    public PositionFrame(int x, int y, String src) {
        this.x = x;
        this.y = y;
        this.src = src;
    }
    public PositionFrame(int x, int y, String src, boolean isLastFrame) {
        this.x = x;
        this.y = y;
        this.src = src;
        this.isLastFrame = isLastFrame;
        if(!isLastFrame) {
            x_hit = 0;
            y_hit = 0;
            width = 0;
            height = 0;
        }else{
            x_hit = x;
            y_hit = y;
            width = 200;
            height = 300;
        }
    }

    public PositionFrame(int x, int y, String src,int width, int height) {
        this.x = x;
        this.y = y;
        this.src = src;
        this.width = width;
        this.height = height;
    }


    public Dimension getDimension() {
        return new Dimension(width,height);
    }

    public Rectangle getRectangle() {
        return new Rectangle(new Point(x_hit,y_hit),getDimension());
    }

}
