import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class M_133_Clone_Graph {

    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return recClone(node, map);
    }

    public Node recClone(Node node, Map<Integer, Node> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node newNode = new Node(node.val);
        map.put(node.val, newNode);

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(recClone(neighbor, map));
        }
        return newNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
