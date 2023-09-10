package hackerrank;

import java.util.ArrayList;
import java.util.List;

/*
 * Maria plays college basketball and wants to go pro. Each season she maintains a record of her play. She tabulates the number of times she breaks her season record for most points and least points in a game. Points scored in the first game establish her record for the season, and she begins counting from there.
 * Example
 * scores = [12,24,10,24]
 * Scores are in the same order as the games played. She tabulates her results as follows:
                                        Count
        Game  Score  Minimum  Maximum   Min Max
        0      12     12       12       0   0
        1      24     12       24       0   1
        2      10     10       24       1   1
        3      24     10       24       1   1
    Given the scores for a season, determine the number of times Maria breaks her records for most and least points scored during the season.
 */

public class BreakingRecords {
    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        // Declare variables to hold the min, max and number of times of breaking min
        // and max
        int maxScore = scores.get(0);
        int minScore = scores.get(0);

        int minBreaks = 0;
        int maxBreaks = 0;

        for (int score : scores.subList(1, scores.size())) {
            if (score < minScore) {
                minScore = score;
                minBreaks++;
            }
            if (score > maxScore) {
                maxScore = score;
                maxBreaks++;
            }
        }

        List<Integer> results = new ArrayList<>();
        results.add(maxBreaks);
        results.add(minBreaks);

        return results;

    }
}
