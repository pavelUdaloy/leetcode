public class M_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance_1334 {

    public static void main(String[] args) {
        int[][] i1 = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        System.out.println(new M_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance_1334().findTheCity(4, i1, 4));
        int[][] i2 = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(new M_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance_1334().findTheCity(5, i2, 2));
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distances = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = 1000000000;
            }
        }

        for (int i = 0; i < n; i++) {
            distances[i][i] = 0;
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int price = edge[2];

            distances[from][to] = price;
            distances[to][from] = price;
        }

        for (int k = 0; k < n / 2 + 1; k++) {
            for (int i = 0; i < n / 2 + 1; i++) {
                for (int j = 0; j < n / 2 + 1; j++) {
                    int min = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                    distances[i][j] = min;
                    distances[j][i] = min;
                }
            }
        }

        int ans = -1;
        int mini = Integer.MAX_VALUE;
        int[] reachable = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && distances[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            reachable[i] = count;
            if (count <= mini) {
                mini = count;
                ans = i;
            }
        }

        return ans;
    }
}
