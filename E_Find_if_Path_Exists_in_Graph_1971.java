import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class E_Find_if_Path_Exists_in_Graph_1971 {

    public void main(String[] args) {
        int[][] a = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(validPath(3, a, 0, 2));

        int[][] b = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        System.out.println(validPath(6, b, 0, 5));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, Node<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];

            map.putIfAbsent(i, new Node<>(i));
            map.putIfAbsent(j, new Node<>(j));

            Node<Integer> iNode = map.get(i);
            Node<Integer> jNode = map.get(j);

            iNode.childs.add(jNode);
            jNode.childs.add(iNode);
        }

        if (source == destination) return true;

        Node<Integer> start = map.get(source);
        Node<Integer> end = map.get(destination);

        if (start == null || end == null) return false;

        LinkedList<Node<Integer>> stack = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        stack.add(start);

        while (!stack.isEmpty()) {
            Node<Integer> current = stack.removeFirst();
            if (visited.contains(current.value)) continue;
            visited.add(current.value);

            if (Objects.equals(current.value, end.value)) return true;

            for (Node<Integer> child : current.childs) {
                if (!visited.contains(child.value)) {
                    stack.add(child);
                }
            }
        }

        return false;
    }

    public class Node<T> {
        public T value;
        public List<Node<T>> childs = new ArrayList<>();

        public Node(T value) {
            this.value = value;
        }
    }
}
