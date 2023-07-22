package soulasphyxia.main;
import soulasphyxia.objects.Diver;
import soulasphyxia.objects.Octopus;
import soulasphyxia.objects.Tentacle;
import soulasphyxia.ui.ApplicationFrame;
import soulasphyxia.ui.Fonts;
import soulasphyxia.ui.GameDisplay;
import soulasphyxia.ui.GameOverDialog;
import soulasphyxia.utils.PositionFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game implements Runnable{
    private final ApplicationFrame frame;
    private final GameDisplay display;
    private final Diver diver;
    private final Octopus octopus;
    private boolean endGame;
    private boolean isGameStarted;
    private boolean isPlayerDead;

    private int livesCount;
    private final List<JLabel> divers;
    private final List<Tentacle> tentacles;

    private Thread gameThread;
    private Timer playerTimer;
    private int tentacleSpeed;

    private boolean liveAdded;


    public Game() throws IOException, FontFormatException{
        //new Fonts().initializeFonts();
        display = new GameDisplay();
        frame = new ApplicationFrame(display);
        frame.setFocusable(true);
        diver = display.getDiver();
        divers = display.getDivers();
        octopus = display.getOctopus();
        tentacles = display.getTentacles();
        isGameStarted = false;
        frame.disableMovementButtons();
        addStartGameListener();
    }


    private void treasureDelivered(){
        if(diver.getFrameIndex() == 0 && diver.isTreasure()) {
            diver.setScore(diver.getScore() + 3);
            diver.setTreasure(false);
        }
    }

    private void updateScore() {
        display.getScoreLabel().setText(String.valueOf(diver.getScore()));
    }

    private void checkCollisions() {
        PositionFrame currentFrame = diver.getFrames().get(diver.getFrameIndex());
        Rectangle diverRect = new Rectangle(new Point(currentFrame.getX(), currentFrame.getY()),
                                            new Dimension(90, 90));
        for(Tentacle t : tentacles) {
            Rectangle tentacleRect = new Rectangle(t.getBounds());
            if(tentacleRect.intersects(diverRect)) {
                isPlayerDead = true;
            }
        }

    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        tentacles.forEach(x -> x.getTimer().setDelay(tentacleSpeed));
        this.livesCount = 3;
        this.gameThread.start();
    }


    private void startTentacles() {
        tentacles.forEach(tentacle -> {
            tentacle.getTimer().start();
            tentacle.setFrameIndex(0);
            tentacle.setVisible(true);
        });
    }

    private void endTentacles() {
        tentacles.forEach(tentacle -> {
            tentacle.setFrameIndex(0);
            tentacle.setVisible(false);
            tentacle.getTimer().stop();
        });
    }



    private void antiIdle() {
        playerTimer = new Timer();
        playerTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(diver.getFrameIndex() == 0) {
                    diver.nextFrame();
                }
            }
        },15000);
    }


    private void startGameTimer() {
        Timer startGameTimer = new Timer();
        startGameTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                frame.enableMovementButtons();
            }
        },1000);
    }

    private void reset() {
        isPlayerDead = false;
        diver.setTreasure(false);
        diver.setFrame(diver.getFrames().get(0));
        diver.setFrameIndex(0);
        display.update(display.getGraphics());
        frame.update(frame.getGraphics());
        updateScore();
    }




    private void addStartGameListener() {
        frame.getGameABtn().addActionListener(e -> {
            tentacleSpeed = 2000;
            if(!isGameStarted) {
                startGameLoop();
            }else {
                endTentacles();
                reset();
                startGameLoop();
            }
        });

        frame.getGameBBtn().addActionListener(e -> {
            tentacleSpeed = 950;
            if(!isGameStarted) {
                startGameLoop();
            }else {
                endTentacles();
                reset();
                startGameLoop();
            }
        });
    }

    private void gameLoop() throws InterruptedException {
        frame.disableMenuButtons();
        while(!endGame){
            startGameTimer();
            antiIdle();
            startTentacles();
            while(!isPlayerDead) {
                updateScore();
                treasureDelivered();
                checkCollisions();
                if((diver.getScore() == 200 || diver.getScore() == 500) && livesCount < 3){
                    liveAdded = false;
                    ++livesCount;
                    System.out.println(livesCount);
                }
                if(!liveAdded){
                    liveAdded = true;
                    addLive();
                }
            }
            --livesCount;
            if(livesCount  >= 1) {
                divers.get(livesCount - 1).setVisible(false);
            }
            playerTimer.cancel();
            endTentacles();
            dieAnimation();
            if(livesCount == 0) {
                endGame = true;
            }
            reset();
        }

        gameThread.interrupt();
        isGameStarted = false;
        new GameOverDialog(frame);
        frame.enableMenuButtons();
    }

    private void addLive() {

    }

    private void dieAnimation() {
        frame.disableMovementButtons();
        diver.setFrame(diver.getDieFrame());
        try{
            Thread.sleep(2000);
        }catch (InterruptedException ignored) {
        }
    }

    @Override
    public void run() {
        try {
            frame.update(frame.getGraphics());
            endGame = false;
            isGameStarted = true;
            liveAdded = true;
            diver.setScore(0);
            divers.forEach(diver -> diver.setVisible(true));
            gameLoop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



