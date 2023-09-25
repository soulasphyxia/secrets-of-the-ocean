package soulasphyxia.main;

import soulasphyxia.objects.Diver;
import soulasphyxia.objects.Tentacle;
import soulasphyxia.ui.ApplicationFrame;
import soulasphyxia.ui.Fonts;
import soulasphyxia.ui.GameDisplay;
import soulasphyxia.ui.GameOverDialog;

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
    private boolean endGame;
    private boolean isGameStarted;
    private boolean isPlayerDead;

    private int livesCount;
    private final List<JLabel> divers;
    private final List<Tentacle> tentacles;

    private Thread gameThread;
    private Timer playerTimer;

    private boolean speedIncrease;
    private int tentacleSpeed;

    private int gameASpeed = 1200;
    private int gameBSpeed = 950;



    public Game() throws IOException, FontFormatException{
        new Fonts().initializeFonts();
        display = new GameDisplay();
        frame = new ApplicationFrame(display);
        frame.setFocusable(true);
        diver = display.getDiver();
        divers = display.getDivers();
        tentacles = display.getTentacles();
        isGameStarted = false;
        display.setOpaque(false);
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
        int index = diver.getFrameIndex();
        Rectangle diverRect = new Rectangle(new Point(diver.getX(),diver.getY()-10),
                                            new Dimension(90,70));
        switch (index) {
            case 1,2 -> {
                diverRect = new Rectangle(new Point(diver.getX(),diver.getY()),
                                          new Dimension(50,50));
                Tentacle t = tentacles.get(0);
                Rectangle rect = new Rectangle(t.getX(),t.getY(),t.getWidth(),t.getHeight());
                if(rect.intersects(diverRect)) {
                    isPlayerDead = true;
                }
            }
            case 3 -> {
                Tentacle t = tentacles.get(1);
                Rectangle rect;
                if(t.isTip()) {
                    rect = new Rectangle(t.getX(),t.getY(),t.getWidth()+30,t.getHeight());
                }else {
                    rect = new Rectangle(0,0,0,0);
                }
                if(rect.intersects(diverRect)) {
                    isPlayerDead = true;
                }
            }

            case 4 -> {
                Tentacle t = tentacles.get(2);
                Rectangle rect;
                if(t.isTip()) {
                    rect = new Rectangle(t.getX(),t.getY(),t.getWidth(),t.getHeight());
                }else {
                    rect = new Rectangle(0,0,0,0);
                }
                if(rect.intersects(diverRect)) {
                    isPlayerDead = true;
                }
            }
            case 5 -> {
                Tentacle t = tentacles.get(3);
                Rectangle rect;
                if(t.isTip()) {
                    rect = new Rectangle(t.getX(),t.getY(),t.getWidth(),t.getHeight());
                }else {
                    rect = new Rectangle(0,0,0,0);
                }
                if(rect.intersects(diverRect)) {
                    isPlayerDead = true;
                }
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

    private void increaseTentacleSpeed() {
        Timer speedIncreaseTimer = new Timer();
        String gameMode = display.getGameModeLabel().getText();
        int tentacleSpeed = 0;
        switch (gameMode) {
            case "Игра А" -> {
                gameASpeed -= 70;
                tentacleSpeed = gameASpeed;
            }
            case "Игра Б" ->  {
                gameBSpeed -= 30;
                tentacleSpeed = gameBSpeed;
            }
        }

        int finalTentacleSpeed = tentacleSpeed;
        speedIncreaseTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                tentacles.forEach(x -> x.getTimer().setDelay(finalTentacleSpeed));
                speedIncrease = false;
            }
        },15000);
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
            tentacleSpeed = gameASpeed;
            if(!isGameStarted) {
                startGameLoop();
            }else {
                endTentacles();
                reset();
                startGameLoop();
            }
        });

        frame.getGameBBtn().addActionListener(e -> {
            tentacleSpeed = gameBSpeed;
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
                if(!speedIncrease) {
                    speedIncrease = true;
                    increaseTentacleSpeed();
                }
                checkCollisions();
                updateScore();
                treasureDelivered();
                if((diver.getScore() == 200 || diver.getScore() == 500) && livesCount < 3){
                    ++livesCount;
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
        new GameOverDialog(frame,diver.getScore(),display.getGameModeLabel().getText().charAt(5));
        frame.enableMenuButtons();

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
            endGame = false;
            isGameStarted = true;
            diver.setScore(0);
            divers.forEach(diver -> diver.setVisible(true));
            gameLoop();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



