package soulasphyxia.ui;

import soulasphyxia.utils.HighScoreRecord;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class GameOverDialog extends JDialog {
    private final int WIDTH = 450;
    private final int HEIGHT = 250;

    private final int score;
    private String gameMode;
    public GameOverDialog(Frame owner, int score,String gameMode) {
        super(owner,"Игра окончена!");
        this.score = score;
        this.gameMode = gameMode;
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        initComponents();
        setVisible(true);
    }


    private void initComponents(){
        JLabel gameOverLabel = new JLabel(
                "Игра окончена! Введите имя для записи рекорда:"
        );

        gameOverLabel.setBounds(45,30,450,55);
        gameOverLabel.setFont(new Font("Dialog",Font.BOLD,14));
        add(gameOverLabel);


        JButton submitBtn = new JButton("Подтвердить");
        submitBtn.setBounds(85,160,120,25);
        add(submitBtn);

        JTextField playerNameInput = new JTextField("Player");
        playerNameInput.setBounds(140,90,180,25);
        add(playerNameInput);
        playerNameInput.setCaretPosition(playerNameInput.getText().length());

        JButton cancelBtn = new JButton("Отмена");
        cancelBtn.setBounds(245,160,120,25);
        add(cancelBtn);
        cancelBtn.addActionListener(e -> dispose());

        submitBtn.addActionListener(e -> {
            String playerName = playerNameInput.getText();
            if(playerName.equals("")) {
                System.out.println("Введите имя!");
            }else {
                try {
                    HighScoreRecord record = new HighScoreRecord(playerName,score,gameMode);
                    new HighScorePanel((Frame) this.getParent(),record);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                dispose();
            }
        });

    }
}
