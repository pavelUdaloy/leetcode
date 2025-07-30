import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class M_Network_Delay_time_743 {

    public static void main(String[] args) {
        int[][] a1 = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(new M_Network_Delay_time_743().networkDelayTime(a1, 4, 2));
        int[][] a2 = {{1, 2, 1}};
        System.out.println(new M_Network_Delay_time_743().networkDelayTime(a2, 2, 1));
        int[][] a3 = {{1, 2, 1}};
        System.out.println(new M_Network_Delay_time_743().networkDelayTime(a3, 2, 2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Node> nodes = new HashMap<>();
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int price = time[2];
            if (!nodes.containsKey(from)) {
                nodes.put(from, new Node(from));
            }
            if (!nodes.containsKey(to)) {
                nodes.put(to, new Node(to));
            }
            nodes.get(from).routes.add(new Pair<>(nodes.get(to), price));
        }

        if (!nodes.containsKey(k)) {
            return -1;
        }

        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(k, 0);

        Stack<Node> stack = new Stack<>();
        stack.push(nodes.get(k));
        while (!stack.isEmpty()) {
            Node from = stack.pop();
            for (Pair<Node, Integer> route : from.routes) {
                Node to = route.first;
                int price = route.second;

                if (!visited.containsKey(to.value)) {
                    visited.put(to.value, visited.get(from.value) + price);
                    stack.push(to);
                } else if (visited.get(to.value) > visited.get(from.value) + price) {
                    visited.put(to.value, visited.get(from.value) + price);
                    stack.push(to);
                }
            }
        }

        if (visited.size() < n) {
            return -1;
        }

        return visited.values().stream().max(Integer::compareTo).orElse(-1);
    }

    public class Node {
        public int value;
        public List<Pair<Node, Integer>> routes = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }
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
