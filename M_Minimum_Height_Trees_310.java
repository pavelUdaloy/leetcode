import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M_Minimum_Height_Trees_310 {

    public static void main(String[] args) {
        M_Minimum_Height_Trees_310 m = new M_Minimum_Height_Trees_310();

        int[][] arr1 = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(m.findMinHeightTrees(4, arr1));

        int[][] arr2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(m.findMinHeightTrees(6, arr2));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer>[] result = new Set[n];
        for (int i = 0; i < n; i++) {
            result[i] = new HashSet<>();
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            result[from].add(to);
            result[to].add(from);
        }

        int ignoreCount = 0;
        boolean[] ignore = new boolean[n];
        while (n - ignoreCount >= 3) {
            Set<Integer> leaves = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (result[i].size() == 1 && !ignore[i]) {
                    leaves.add(i);
                }
            }
            for (Integer leaf : leaves) {
                ignore[leaf] = true;
                ignoreCount++;

                for (Integer i : result[leaf]) {
                    result[i].remove(leaf);
                }
                result[leaf].clear();
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!ignore[i]) {
                resultList.add(i);
            }
        }
        return resultList;
    }
}
