package soulasphyxia.utils;

import lombok.AllArgsConstructor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
@AllArgsConstructor
public class HighScoreWriter {

    private File file;

    public void writeRecords(ArrayList<HighScoreRecord> records) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for(HighScoreRecord record : records) {
                String line =
                        record.getPlayerName() + " " +
                                record.getScore() + " " +
                                        record.getGameMode() + "\n";
                writer.write(line);
            }
        }

    }
}
