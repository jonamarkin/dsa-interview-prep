package companies.gs;

import java.util.*;

public class TrainMapReconstructor {

    public static String reconstructPath(List<String[]> connections) {
        // Build forward and reverse maps
        Map<String, String> forwardMap = new HashMap<>();
        Set<String> destinations = new HashSet<>();

        for (String[] connection : connections) {
            String from = connection[0];
            String to = connection[1];
            forwardMap.put(from, to);
            destinations.add(to);
        }

        // Find the starting point: a source that's not a destination
        String start = null;
        for (String station : forwardMap.keySet()) {
            if (!destinations.contains(station)) {
                start = station;
                break;
            }
        }

        // Traverse the path
        if (start == null) return "Invalid input: no starting point.";

        StringBuilder result = new StringBuilder(start);
        while (forwardMap.containsKey(start)) {
            start = forwardMap.get(start);
            result.append(" -> ").append(start);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        List<String[]> connections = Arrays.asList(
                new String[]{"New York", "Boston"},
                new String[]{"Boston", "Chicago"},
                new String[]{"Chicago", "Denver"},
                new String[]{"Denver", "San Francisco"}
        );

        System.out.println(reconstructPath(connections));
        // Output: New York -> Boston -> Chicago -> Denver -> San Francisco
    }
}
