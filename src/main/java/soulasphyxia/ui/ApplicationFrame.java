package soulasphyxia.ui;
import lombok.Getter;
import lombok.Setter;
import soulasphyxia.utils.ResourcesLoader;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@Getter
@Setter
public class ApplicationFrame extends JFrame {
    private final GameDisplay display;
    private boolean gameModeSet = false;
    private MovementButton rightButton;
    private MovementButton leftButton;
    private MenuButton gameBBtn;
    private MenuButton gameABtn;
    private ResourcesLoader rl = new ResourcesLoader();
    ImageIcon icon = new ImageIcon(rl.getResource("images/background_source.jpg"));
    private final int FRAME_WIDTH = icon.getIconWidth();
    private final int FRAME_HEIGHT = icon.getIconHeight();
    private MenuButton rulesBtn;
    public ApplicationFrame(GameDisplay display){
        super("Эмулятор Электроника ИМ-03 Тайны Океана");
        this.display = display;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setResizable(false);
        setContentPane(new JLabel(icon));
        setLocationRelativeTo(null);
        initComponents();
        setLayout(null);
        setVisible(true);
    }

    private void initComponents() {
        display.setLocation((FRAME_WIDTH - display.getDISPLAY_WIDTH())/2,
                            (FRAME_HEIGHT-display.getDISPLAY_HEIGHT())/2);
        add(display);

        leftButton = new MovementButton();
        leftButton.setBounds(90,479,90,90);
        add(leftButton);

        rightButton = new MovementButton();
        rightButton.setBounds(1086,483,90,90);
        add(rightButton);


        leftButton.addActionListener((e) -> {
            display.getDiver().prevFrame();
            display.update(display.getGraphics());
        });

        rightButton.addActionListener((e) -> {
            display.getDiver().nextFrame();
            display.update(display.getGraphics());
        });

        gameABtn = new MenuButton();
        gameABtn.setBounds(1083,67, gameABtn.getWidth(),gameABtn.getHeight());
        add(gameABtn);
        gameABtn.setOpaque(false);
        gameABtn.addActionListener(e -> {
            display.getGameModeLabel().setText("Игра А");
            display.getGameModeLabel().setBounds(20,320,120,22);
        });


        gameBBtn = new MenuButton();
        gameBBtn.setBounds(1083,155, gameBBtn.getWidth(),gameBBtn.getHeight());

        add(gameBBtn);
        gameBBtn.setOpaque(false);
        gameBBtn.addActionListener(e -> {
            display.getGameModeLabel().setText("Игра Б");
            display.getGameModeLabel().setBounds(20,320,120,22);
        });

        rulesBtn = new MenuButton();
        rulesBtn.setBounds(1083,245, rulesBtn.getWidth(),rulesBtn.getHeight());
        add(rulesBtn);
        rulesBtn.setOpaque(false);
        rulesBtn.addActionListener(e -> new RulesDialog(this));


        gameABtn.setFocusable(false);
        gameBBtn.setFocusable(false);
        rulesBtn.setFocusable(false);


        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> rightButton.doClick();
                    case KeyEvent.VK_LEFT, KeyEvent.VK_A -> leftButton.doClick();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });

    }


    public void disableMovementButtons() {
        rightButton.setEnabled(false);
        leftButton.setEnabled(false);
    }

    public void enableMovementButtons() {
        rightButton.setEnabled(true);
        leftButton.setEnabled(true);
    }


    public void disableMenuButtons() {
        gameABtn.setEnabled(false);
        gameBBtn.setEnabled(false);
        rulesBtn.setEnabled(false);
    }

    public void enableMenuButtons() {
        gameABtn.setEnabled(true);
        gameBBtn.setEnabled(true);
        rulesBtn.setEnabled(true);
    }



}
