package soulasphyxia.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PositionFrame {
    private final int x;
    private final int y;
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
    }

    public PositionFrame(int x, int y, String src,int width, int height) {
        this.x = x;
        this.y = y;
        this.src = src;
        this.width = width;
        this.height = height;
    }

}
