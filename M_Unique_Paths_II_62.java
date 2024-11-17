public class M_Unique_Paths_II_62 {

    public static void main(String[] args) {

        int[][] array = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(new M_Unique_Paths_II_62().uniquePathsWithObstacles(array));

        int[][] array2 = {
                {0, 1},
                {0, 0}
        };
        System.out.println(new M_Unique_Paths_II_62().uniquePathsWithObstacles(array2));

        int[][] array3 = {
                {0, 0},
                {0, 1}
        };
        System.out.println(new M_Unique_Paths_II_62().uniquePathsWithObstacles(array3));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if (obstacleGrid[n-1][m-1] == 1) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] != 0) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == -1) {
                break;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }

        for (int j = 0; j < m; j++) {
            if (obstacleGrid[0][j] == -1) {
                break;
            } else {
                obstacleGrid[0][j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == -1) {
                    continue;
                } else if (obstacleGrid[i - 1][j] == -1 && obstacleGrid[i][j - 1] == -1) {
                    obstacleGrid[i][j] = 0;
                } else if (obstacleGrid[i - 1][j] == -1) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                } else if (obstacleGrid[i][j - 1] == -1) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }

        return obstacleGrid[n - 1][m - 1];
    }
}
