package leetcode.blind75.graph;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i =0; i<n; i++){
            if (!visited[i]){
                dfs(isConnected, i, visited);
                provinces++;
            }
        }

        return provinces;
    }

    public void dfs(int[][] isConnected, int city, boolean[] visited){
        visited[city] = true;

        for (int neighbour = 0; neighbour< isConnected.length; neighbour++){
            if (isConnected[city][neighbour] ==1 && !visited[neighbour]){
                dfs(isConnected, neighbour, visited);
            }
        }
    }

}
