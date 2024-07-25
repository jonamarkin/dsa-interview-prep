package grokking.dijkstra;

import java.util.*;

public class DijkstraAlgo {

    public static void main(String[] args) {
        dijkstra();
    }


    public static void dijkstra(){
        HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
        //Fill the grap
        HashMap<String, Integer> startMap = new HashMap<>();
        startMap.put("A", 6);
        startMap.put("B", 2);
        graph.put("START", startMap);

        HashMap<String, Integer> aMap = new HashMap<>();
        aMap.put("FIN", 1);
        graph.put("A", aMap);

        HashMap<String, Integer> bMap = new HashMap<>();
        bMap.put("A", 3);
        bMap.put("FIN", 5);
        graph.put("B", bMap);

        HashMap<String, Integer> finMap = new HashMap<>();
        graph.put("B", finMap);


        //Create hashmap for costs and fill it as well
        HashMap<String, Integer> costMap = new HashMap<>();
        costMap.put("A", 6);
        costMap.put("B", 2);
        costMap.put("FIN", Integer.MAX_VALUE);
        costMap.put("START", 0);

        //Another hashmap for parents
        HashMap<String, String> parentMap = new HashMap<>();
        parentMap.put("A", "START");
        parentMap.put("B", "START");
        parentMap.put("FIN", null);


        //Array to keep track of processed nodes
        List<String> processed = new ArrayList<>();


        //The algorithm
        String node = findLowestCostNode(costMap, processed);
        while (node!=null){
            int cost = costMap.get(node);
            HashMap<String, Integer> neighbours = graph.get(node);

            if (neighbours != null) {
                for (String n : neighbours.keySet()) {
                    int newCost = cost + neighbours.get(n);

                    if (costMap.get(n) > newCost) {
                        costMap.put(n, newCost);
                        parentMap.put(n, node);
                    }
                }
            }

            processed.add(node);
            node = findLowestCostNode(costMap, processed);
        }


        System.out.println(parentMap);
        System.out.println(costMap);
    }

    public static String findLowestCostNode(Map<String, Integer> costs,  List<String> processed){
        int lowestCost = Integer.MAX_VALUE;
        String lowestCostNode = null;

        for (String node : costs.keySet()){
            if (costs.get(node) < lowestCost && !processed.contains(node)){
                lowestCost = costs.get(node);
                lowestCostNode = node;
            }
        }

        return lowestCostNode;
    }



}
