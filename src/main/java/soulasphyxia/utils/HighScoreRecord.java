package soulasphyxia.utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HighScoreRecord implements Comparable<HighScoreRecord> {

    private String playerName;
    private int score;
    private String gameMode;


    @Override
    public int compareTo(HighScoreRecord record) {
        return Integer.compare(record.score,this.score  );
    }
}
