public class M_Unique_Paths_62 {

    public static void main(String[] args) {

        System.out.println(new M_Unique_Paths_62().uniquePaths(3, 7));
        System.out.println(new M_Unique_Paths_62().uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n) {
        int[][] array = new int[n][m];

        for (int i = 0; i < n; i++) {
            array[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            array[0][j] = 1;
        }

        for (int i = 1; i <n; i++) {
            for (int j = 1; j < m; j++) {
                array[i][j] = array[i-1][j] + array[i][j-1];
            }
        }

        return array[n-1][m-1];
    }
}
