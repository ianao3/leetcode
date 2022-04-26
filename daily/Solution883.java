public class Solution883 {
    public int projectionArea(int[][] grid) {
        int xArea = 0, yArea = 0, zArea = 0;
        for (int i = 0; i < grid.length; i++) {
            int a = 0, b = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    xArea++;
                }
                a = Math.max(a, grid[i][j]);
                b = Math.max(b, grid[j][i]);
            }
            yArea += a;
            zArea += b;
        }
        return xArea + yArea + zArea;
    }
}
