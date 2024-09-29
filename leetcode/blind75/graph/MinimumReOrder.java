package leetcode.blind75.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumReOrder {
    /*
    There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between
    two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

    Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

    This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

    Your task consists of reorienting some roads such that each city can visit the city 0.
    Return the minimum number of edges changed.

    It's guaranteed that each city can reach city 0 after reorder.
     */

    public int minReorder(int n, int[][] connections) {

        //Adjacency list for both incoming and outgoing roads
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();

        for (int i =0; i<n; i++){
            adjacencyList.put(i, new ArrayList<>());
        }

        //Store the various roads
        //Mark with true if going from a to b and false otherwise

        for (int[] road : connections){
            int from = road[0];
            int to = road[1];

            adjacencyList.get(from).add(new int[]{to,1}); //1 for outgoing
            adjacencyList.get(to).add(new int[]{from, 0}); //0 for incoming
        }

        //DFS to traverse the graph starting from 0
        boolean[] visited = new boolean[n];
        return dfs(0, visited, adjacencyList);
    }

    private int dfs(int node, boolean[] visited, Map<Integer, List<int[]>> adjacencyList) {

        visited[node] = true;
        int changeCount = 0;

        for(int[] neighbour : adjacencyList.get(node)){
            int nextCity = neighbour[0];
            int direction = neighbour[1];

            if(!visited[nextCity]){
                //If outgoing we need to reverse it
                if (direction ==1){
                    changeCount+=1;
                }

                //Recur for next city
                changeCount+=dfs(nextCity, visited, adjacencyList);
            }
        }

        return changeCount;
    }
}
