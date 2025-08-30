import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class H_Jump_Game_4_1345 {

    public static void main(String[] args) {
        int[] nums6 = {-76, 3, 66, -32, 64, 2, -19, -8, -5, -93, 80, -5, -76, -78, 64, 2, 16};
        System.out.println(new H_Jump_Game_4_1345().minJumps(nums6));

        int[] nums5 = {51, 64, -15, 58, 98, 31, 48, 72, 78, -63, 92, -5, 64, -64, 51, -48, 64, 48, -76, -86, -5, -64, -86, -47, 92, -41, 58, 72, 31, 78, -15, -76, 72, -5, -97, 98, 78, -97, -41, -47, -86, -97, 78, -97, 58, -41, 72, -41, 72, -25, -76, 51, -86, -65, 78, -63, 72, -15, 48, -15, -63, -65, 31, -41, 95, 51, -47, 51, -41, -76, 58, -81, -41, 88, 58, -81, 88, 88, -47, -48, 72, -25, -86, -41, -86, -64, -15, -63};
        System.out.println(new H_Jump_Game_4_1345().minJumps(nums5));

        int[] nums0 = {6, 1, 9};
        System.out.println(new H_Jump_Game_4_1345().minJumps(nums0));

        int[] nums1 = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(new H_Jump_Game_4_1345().minJumps(nums1));

        int[] nums2 = {7};
        System.out.println(new H_Jump_Game_4_1345().minJumps(nums2));

        int[] nums3 = {7, 6, 9, 6, 9, 6, 9, 7};
        System.out.println(new H_Jump_Game_4_1345().minJumps(nums3));
    }

    public int minJumps(int[] arr) {
        if (arr.length == 1) return 0;
        if (arr.length == 2) return 1;

        Map<Integer, Set<Integer>> numberToPositions = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            numberToPositions.computeIfAbsent(arr[i], k -> new HashSet<>()).add(i);
        }

        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new ArrayDeque<>();
        q.add(new Pair<>(new Pair<>(0, 0), arr[0]));

        boolean[] visited = new boolean[arr.length];
        visited[0] = true;

        while (!q.isEmpty()) {
            Pair<Pair<Integer, Integer>, Integer> cur = q.poll();
            int step = cur.first.first;
            int pos = cur.first.second;
            int number = cur.second;

            if (pos == arr.length - 1) {
                return step;
            }

            for (Integer nxt : numberToPositions.get(number)) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(new Pair<>(new Pair<>(step + 1, nxt), arr[nxt]));
                }
            }
            numberToPositions.get(number).clear();

            if (pos - 1 >= 0 && !visited[pos - 1]) {
                visited[pos - 1] = true;
                q.add(new Pair<>(new Pair<>(step + 1, pos - 1), arr[pos - 1]));
            }
            if (pos + 1 < arr.length && !visited[pos + 1]) {
                visited[pos + 1] = true;
                q.add(new Pair<>(new Pair<>(step + 1, pos + 1), arr[pos + 1]));
            }
        }

        return arr.length;
    }

    public static class Pair<FIRST, SECOND> {
        public FIRST first;
        public SECOND second;
        public Pair(FIRST first, SECOND second) {
            this.first = first;
            this.second = second;
        }
    }
}
