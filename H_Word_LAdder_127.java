import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class H_Word_LAdder_127 {

    public static void main(String[] args) {
        System.out.println(new H_Word_LAdder_127().ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(new H_Word_LAdder_127().ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log")));
        System.out.println(new H_Word_LAdder_127().ladderLength("xxx", "yyy", List.of("xxy", "xaa", "yaa", "yya", "yxy", "yyy", "xxa")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Node> wordsMap = new HashMap<>();

        wordsMap.put(beginWord, new Node(beginWord));
        for (String word : wordList) {
            wordsMap.put(word, new Node(word));
        }

        if (!wordsMap.containsKey(endWord)) {
            return 0;
        }

        Node beginWordNode = wordsMap.get(beginWord);
        for (int j = 0; j < wordList.size(); j++) {
            String second = wordList.get(j);

            if (compare(beginWord, second)) {
                Node node2 = wordsMap.get(second);
                beginWordNode.routes.add(node2);
                node2.routes.add(beginWordNode);
            }
        }

        for (int i = 0; i < wordList.size() - 1; i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                String first = wordList.get(i);
                String second = wordList.get(j);

                if (compare(first, second)) {
                    Node node1 = wordsMap.get(first);
                    Node node2 = wordsMap.get(second);
                    node1.routes.add(node2);
                    node2.routes.add(node1);
                }
            }
        }

        Queue<QueueNode> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new QueueNode(null, 1, beginWordNode));
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            QueueNode queueNode = queue.poll();

            for (Node route : queueNode.current.routes) {
                if (route.value.equals(endWord)) {
                    return queueNode.count + 1;
                }
                if (!visited.contains(route.value)) {
                    visited.add(route.value);
                    queue.offer(new QueueNode(queueNode.current, queueNode.count + 1, route));
                }
            }
        }

        return 0;
    }

    public boolean compare(String first, String second) {
        int diff = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }

    public class Node {

        public Node(String value) {
            this.value = value;
            routes = new ArrayList<>();
        }

        public String value;
        public List<Node> routes;
    }

    public class QueueNode {

        public QueueNode(Node prev, int count, Node current) {
            this.prev = prev;
            this.count = count;
            this.current = current;
        }

        public Node prev;
        public int count;
        public Node current;
    }
}
