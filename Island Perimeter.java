class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int block = 0;
        int nbrs = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    block++;
                    // down neighbor
                    if(i+1 < m && grid[i+1][j] == 1){
                        nbrs++;
                    }
                    // right neighbor
                    if(j+1 < n && grid[i][j+1] == 1){
                        nbrs++;
                    }
                }
            }
        }
        return 4*block - 2*nbrs;
    }
}