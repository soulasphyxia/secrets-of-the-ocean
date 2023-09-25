package soulasphyxia.utils;

import lombok.AllArgsConstructor;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

@AllArgsConstructor
public class HighScoreReader {

    private File file;


    public ArrayList<HighScoreRecord> readHighScores() throws IOException {
        ArrayList<HighScoreRecord> records = new ArrayList<>();
        if (file.length() != 0) {
            try(Scanner sc = new Scanner(file)) {
                while(sc.hasNext()) {
                    String line = sc.nextLine();
                    String[] tokens = line.split(" ");
                    HighScoreRecord record = new HighScoreRecord();
                    record.setPlayerName(tokens[0]);
                    record.setScore(Integer.parseInt(tokens[1]));
                    record.setGameMode(tokens[2]);
                    records.add(record);
                }
            }
        }
        return records;



    }



}
