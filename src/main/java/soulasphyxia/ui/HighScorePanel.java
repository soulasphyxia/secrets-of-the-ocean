package soulasphyxia.ui;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import soulasphyxia.main.Main;
import soulasphyxia.utils.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class HighScorePanel extends JDialog {
    private final int WIDTH = 500;
    private final int HEIGHT = 450;
    private File file;
    private ArrayList<HighScoreRecord> recordList;

    private final Font font = new Font("Dialog",Font.PLAIN,21);
    public HighScorePanel(Frame frame, HighScoreRecord record) throws IOException, URISyntaxException {
        super(frame,"Таблица рекордов");
        //Path targetPath = Paths.get(Objects.requireNonNull(Main.class.getResource("/scores.txt")).toURI());
        String path = getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        path = path.substring(0, path.lastIndexOf('/')+1);
        File root = new File(path);

        file = new File(root, "/classes/scores.txt");



        HighScoreReader highScoreReader = new HighScoreReader(file);
        recordList = highScoreReader.readHighScores();
        if(!recordList.contains(record)){
            recordList.add(record);
        }
        Collections.sort(recordList);
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JLabel rankLabel = new JLabel("Место");
        JLabel playerNameLabel = new JLabel("Имя игрока");
        JLabel scoreLabel = new JLabel("Очки");
        JLabel gameModeLabel = new JLabel("Режим");
        rankLabel.setBounds(20,50,100,25);
        playerNameLabel.setBounds(130,50,150,25);
        scoreLabel.setBounds(300,50,100,25);
        gameModeLabel.setBounds(400,50,100,25);
        gameModeLabel.setFont(font);
        rankLabel.setFont(font);
        playerNameLabel.setFont(font);
        scoreLabel.setFont(font);
        add(rankLabel);
        add(playerNameLabel);
        add(scoreLabel);
        add(gameModeLabel);

        JButton okButton = new JButton("Ок");
        okButton.setBounds(210,370,70,35);
        okButton.setFont(font);
        add(okButton);
        recordList.forEach(record -> {
            int index = recordList.indexOf(record);
            JLabel rank = new JLabel(String.valueOf(index+1));
            JLabel name = new JLabel(record.getPlayerName());
            JLabel score = new JLabel(String.valueOf(record.getScore()));
            JLabel gameMode = new JLabel(record.getGameMode());
            gameMode.setFont(font);
            rank.setFont(font);
            name.setFont(font);
            score.setFont(font);
            int y = 50 + 25*(index+1);
            rank.setBounds(40,y,100,25);
            name.setBounds(130,y,150,25);
            score.setBounds(300,y,100,25);
            gameMode.setBounds(400,y,100,25);
            add(rank);
            add(name);
            add(score);
            add(gameMode);
        });

        okButton.addActionListener(e -> {
            HighScoreWriter writer = new HighScoreWriter(file);
            try {
                writer.writeRecords(recordList);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            dispose();
        });
    }
}
