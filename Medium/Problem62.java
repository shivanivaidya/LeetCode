/*

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

*/


public class Problem62 {
    public int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 || j == 0) {
                    map[i][j] = 1;
                }
                else {
                    map[i][j] = map[i-1][j]+map[i][j-1];
                }
            }
        }
        return map[m-1][n-1];
    }
}