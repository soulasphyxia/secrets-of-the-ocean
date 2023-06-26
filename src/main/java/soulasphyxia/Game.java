package soulasphyxia;

import soulasphyxia.ui.ApplicationFrame;
import soulasphyxia.ui.GameDisplay;

public class Game {
    private final ApplicationFrame frame;
    public Game() {
        GameDisplay display = new GameDisplay();
        frame = new ApplicationFrame(display);
    }
}
