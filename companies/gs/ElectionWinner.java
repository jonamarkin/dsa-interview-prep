package companies.gs;

import java.util.HashMap;
import java.util.Map;

public class ElectionWinner {

    public static String findWinner(String[] votes){

        Map<String, Integer> voteCount = new HashMap<>();

        for(String vote: votes){
            voteCount.put(vote, voteCount.getOrDefault(vote, 0) + 1);
        }

        String winner = "";
        int maxVotes = 0;

        for(Map.Entry<String, Integer> entry : voteCount.entrySet()){
            String candidate = entry.getKey();
            int count = entry.getValue();

            if(count > maxVotes || (count == maxVotes && candidate.compareTo(winner) < 0)) {
                maxVotes = count;
                winner = candidate;
            }
        }

        return winner;
    }
}
