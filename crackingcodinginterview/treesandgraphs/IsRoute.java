package crackingcodinginterview.treesandgraphs;

import com.sun.source.tree.Tree;

import java.util.*;

public class IsRoute {

    /*
    Given a directed graph, design an algorithm to find out whether there is a route between two nodes
     */

    public static boolean hasRoute(GraphNode start, GraphNode end, HashMap<GraphNode, List<GraphNode>> graph) {

        Queue<GraphNode> nodeQueue = new LinkedList<>();
        HashSet<GraphNode> searched = new HashSet<>();

        nodeQueue.add(start);

        while (!nodeQueue.isEmpty()) {

            GraphNode node = nodeQueue.poll();

            if (!searched.contains(node)) {
                List<GraphNode> adjacent = graph.get(node);

                if (adjacent.contains(end)) {
                    System.out.println("End reached");
                    return true;
                } else {
                    searched.add(node);
                    if (graph.containsKey(node)) {
                        nodeQueue.addAll(adjacent);
                    }
                }
            }


        }

        return false;

    }


}
