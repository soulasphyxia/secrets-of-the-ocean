package soulasphyxia.ui;

import lombok.Getter;
import lombok.Setter;
import soulasphyxia.objects.Diver;
import soulasphyxia.objects.Octopus;
import soulasphyxia.objects.Tentacle;
import soulasphyxia.utils.ResourcesLoader;
import soulasphyxia.utils.TentacleFabric;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GameDisplay extends JPanel {
    private final int DISPLAY_WIDTH = 602;
    private final int DISPLAY_HEIGHT = 384;

    private final Diver diver;
    private final Octopus octopus;
    private final JLabel scoreLabel = new JLabel("999");
    private final JLabel gameModeLabel = new JLabel("");
    private int index = 0;
    private boolean flag = false;
    private List<Tentacle> tentacles;
    private List<JLabel> divers;
    private ResourcesLoader rl = new ResourcesLoader();

    public GameDisplay() {
        super();
        diver = new Diver();
        octopus = new Octopus();
        tentacles = TentacleFabric.getTentacles();
        divers = new ArrayList<>();
        setSize(DISPLAY_WIDTH,DISPLAY_HEIGHT);
        initComponents();
        setVisible(true);
        setLayout(null);
    }


    private void initComponents() {
        diver.setBounds(diver.getX(),diver.getY(),diver.getDIVER_WIDTH(),diver.getDIVER_HEIGHT());
        add(diver);

        JLabel diver1 = new JLabel();
        JLabel diver2 = new JLabel();
        ImageIcon icon = new ImageIcon(rl.getResource("images/diver_0.png"));
        diver1.setIcon(icon);
        diver2.setIcon(icon);
        diver1.setBounds(diver.getX() + 60,diver.getY(),icon.getIconWidth(),icon.getIconHeight());
        diver2.setBounds(diver.getX() + 120,diver.getY(),icon.getIconWidth(),icon.getIconHeight());
        divers.add(diver1);
        divers.add(diver2);
        divers.forEach(this::add);

        octopus.setBounds(octopus.getX(), octopus.getY(), octopus.getOCTOPUS_WIDTH(), octopus.getOCTOPUS_HEIGHT());
        add(octopus);
        scoreLabel.setFont(new Font("Digital Counter 7",Font.PLAIN,64));
        scoreLabel.setBounds(450,0,128,64);
        add(scoreLabel);
        gameModeLabel.setFont(new Font("Digital Counter 7",Font.PLAIN,22));
        add(gameModeLabel);
        tentacles.forEach(tentacle -> {
            tentacle.setBounds(tentacle.getBounds());
            add(tentacle);
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
