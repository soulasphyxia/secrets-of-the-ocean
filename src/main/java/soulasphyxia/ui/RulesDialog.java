package soulasphyxia.ui;

import javax.swing.*;
import java.awt.*;

public class RulesDialog extends JDialog {
    private final int WIDTH = 750;
    private final int HEIGHT = 450;
    public RulesDialog(Frame owner) {
        super(owner,"Правила");
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        initComponents();
        setVisible(true);
    }


    private void initComponents(){
        JTextArea rulesField = new JTextArea("""
                Управляя водолазом, который может занимать шесть позиций,
                необходимо спустить его вниз и провести к сундуку с сокровищами,
                избегая щупалец осьминога.
                Стоя у сундука, нажимая кнопку «вправо»,
                необходимо набирать золота в мешочек.
                За каждую порцию набранного золота (одно нажатие на кнопку «вправо»)
                игроку начисляется одно очко.
                За каждый успешный возврат в лодку с золотом (независимо от его количества)
                начисляется три очка.
                Сначала щупальца двигаются медленно, но постепенно темп игры ускоряется.
                
                Управление:
                Вправо - D / Стрелка вправо
                Влево - A / Стрелка влево
                """);
        rulesField.setFont(new Font("Dialog", Font.PLAIN,17));
        rulesField.setBounds(5,0,750,350);
        rulesField.setBackground(getBackground());
        add(rulesField);

        JButton okButton = new JButton("Ок");
        okButton.setBounds(350,370,70,35);
        okButton.setFont(new Font("Dialog", Font.PLAIN,17));
        add(okButton);
        okButton.addActionListener(e -> {
            dispose();
        });
    }
}
