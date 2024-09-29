package leetcode.blind75.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

    /*
    There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms.
    However, you cannot enter a locked room without having its key.

    When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it
    unlocks, and you can take all of them with you to unlock the other rooms.

    Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
    return true if you can visit all the rooms, or false otherwise.
     */


    //BFS Solution
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        Queue<Integer> roomsQueue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        visited[0] = true;
        roomsQueue.offer(0);

        int visitedRooms = 0;

        while (!roomsQueue.isEmpty()){
            int currentRoom = roomsQueue.poll();
            visitedRooms++;

            for (int key: rooms.get(currentRoom)){
                if (!visited[key]){
                    visited[key] = true;
                    roomsQueue.offer(key);
                }
            }
        }

        return visitedRooms == n;
    }


//DFS Solution
public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
    boolean[] visited = new boolean[rooms.size()];
    dfs(rooms, 0, visited);

    for (boolean v: visited){
        if(!v) return false;
    }

    return true;
}

public void dfs(List<List<Integer>> rooms, int room, boolean[] visited){
        if (visited[room]) return;

        visited[room] = true;
        for (int key: rooms.get(room)){
            dfs(rooms, key, visited);
        }
}


}