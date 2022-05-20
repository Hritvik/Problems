class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] visited = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[i].length; j++){
                visited[i][j] = -1;
            }
        }
        return recursive(0, 0, obstacleGrid, visited);
    }
    
    private int recursive(int i, int j, int[][] obstacleGrid, int[][] visited){
        if(i < 0 || j < 0 || i >= obstacleGrid.length || j >= obstacleGrid[i].length){
            return 0;
        }else if(visited[i][j] != -1){
            return visited[i][j];
        }else if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1 && obstacleGrid[i][j] == 0){
            return 1;
        }else if(obstacleGrid[i][j] == 1){
            return 0;
        }else{
            int count = 0;
            count += recursive(i+1, j, obstacleGrid, visited);
            count += recursive(i, j+1, obstacleGrid, visited);
            visited[i][j] = count;
            return count;
        }   
    }
}