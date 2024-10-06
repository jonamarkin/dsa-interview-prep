package leetcode.blind75.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    /*
    You are given an m x n grid where each cell can have one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.
    Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

    Return the minimum number of minutes that must elapse until no cell has a fresh orange.
    If this is impossible, return -1.
     */


    /*
    Time Complexity: O (m * n )
    Space Complexity: O ( m * n)
     */

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;

        // Directions array to move up, down, left, and right.
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Queue to perform BFS.
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Add all initial rotten oranges to the queue and count fresh oranges.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    // Add rotten orange coordinates and initial time (0 minutes) to queue.
                    queue.offer(new int[]{i, j, 0});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // If there are no fresh oranges at the start, return 0.
        if (freshCount == 0) {
            return 0;
        }

        // Step 2: Perform BFS to rot fresh oranges.
        int minutes = 0;
        int rottenCount = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int time = current[2];
            minutes = time;  // Update the time to the latest value.

            // Check all 4 possible directions (up, down, left, right).
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // If the new cell is within bounds and has a fresh orange, rot it.
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 2;  // Mark as rotten.
                    freshCount--;  // Decrease the count of fresh oranges.
                    queue.offer(new int[]{newRow, newCol, time + 1});  // Add it to the queue with incremented time.
                }
            }
        }

        // If there are no fresh oranges left, return the time; otherwise, return -1.
        return freshCount == 0 ? minutes : -1;
    }
}
