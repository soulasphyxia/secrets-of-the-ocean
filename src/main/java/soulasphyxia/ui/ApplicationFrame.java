package soulasphyxia.ui;

import javax.swing.*;
import java.awt.*;


public class ApplicationFrame extends JFrame {
    private final int FRAME_WIDTH = 1280;
    private final int FRAME_HEIGHT = 720;

    private final GameDisplay display;



    public ApplicationFrame(GameDisplay display){
        super("Эмулятор Электроника ИМ-03 Тайны Океана");
        this.display = display;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setLocationRelativeTo(null);
        initComponents();
        setLayout(null);
        setVisible(true);
    }

    private void initComponents() {
        getContentPane().setBackground(Color.decode("#FFFACC"));
        display.setLocation((FRAME_WIDTH - display.getDISPLAY_WIDTH())/2,
                            (FRAME_HEIGHT-display.getDISPLAY_HEIGHT())/2);
        add(display);


        MovementButton leftButton = new MovementButton();
        leftButton.setBounds(100,500,50,50);

        add(leftButton);
        MovementButton rightButton = new MovementButton();
        rightButton.setBounds(1135,500,50,50);
        add(rightButton);

        leftButton.addActionListener((e) -> {
            display.getDiver().left();
            display.update(display.getGraphics());
        });

        rightButton.addActionListener((e) -> {
            display.getDiver().right();
            display.update(display.getGraphics());
        });

        MenuButton gameABtn = new MenuButton();
        gameABtn.setBounds(1100,250, gameABtn.getWidth(),gameABtn.getHeight());
        JLabel gameALabel = new JLabel("Игра А");
        gameALabel.setBounds(1105,270,65,28);
        gameALabel.setFont(gameABtn.getFont());
        add(gameALabel);
        add(gameABtn);


        MenuButton gameBBtn = new MenuButton();
        gameBBtn.setBounds(1100,310, gameBBtn.getWidth(),gameBBtn.getHeight());
        JLabel gameBLabel = new JLabel("Игра B");
        gameBLabel.setBounds(1105,330,65,28);
        gameBLabel.setFont(gameBBtn.getFont());
        add(gameBLabel);
        add(gameBBtn);

        MenuButton rulesBtn = new MenuButton();
        rulesBtn.setBounds(1100,370, rulesBtn.getWidth(),rulesBtn.getHeight());
        JLabel rulesLabel = new JLabel("Правила");
        rulesLabel.setBounds(1097,390,65,28);
        rulesLabel.setFont(rulesBtn.getFont());
        add(rulesLabel);
        add(rulesBtn);

    }


}
