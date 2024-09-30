package leetcode.blind75.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExit {

    /*
    You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+').
    You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column
    of the cell you are initially standing at.

    In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall,
    and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance.
    An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

    Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
     */

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        //Directions for up, down, left and right
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        //BFS Queue : Each element is [row, col, steps]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        //Visited boolean array to avoid cycles
        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] =true;

        //BFS Traversal
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[9];
            int col = cell[1];
            int steps = cell[2];

            //Explore neighbours
            for (int[] direction: directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];


                //Check if the new cell is within the bounds and not a wall
                if(newRow>=0 && newRow<m && newCol >=0 && newCol<n && maze[newRow][newCol]=='.'){
                    //If it's an exit and not the entrance, return the number of steps+1
                    if ((newRow ==0 || newRow==m-1 || newCol==0 ||newCol==n-1) && !(newRow==entrance[0] &&newCol==entrance[1])){
                        return steps +1;
                    }

                    //If cell is not visited add to the queue and mark as visited
                    if (!visited[newRow][newCol]){
                        queue.offer(new int[]{newRow, newCol, steps+1});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }

        //If not exit found
        return -1;
    }
}
