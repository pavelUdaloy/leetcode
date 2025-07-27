import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M_207_Course_Schedule {

    public static void main(String[] args) {
        int[][] ints = {{1, 0}};
        System.out.println(new M_207_Course_Schedule().canFinish(2, ints)); // true

        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println(new M_207_Course_Schedule().canFinish(2, prerequisites2)); // false

        int[][] prerequisites3 = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        System.out.println(new M_207_Course_Schedule().canFinish(5, prerequisites3)); // true

        int[][] prerequisites4 = {{1, 0}, {2, 0}, {0, 1}};
        System.out.println(new M_207_Course_Schedule().canFinish(3, prerequisites4)); // false
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {  // todo 3 variant
        return true;
    }

    public boolean rec() {
        return true;
    }

    public static class Node {
        public String status = "unwatched";
        public Set<Node> neighbors = new HashSet<>();

        public Node(String status, Set<Node> neighbors) {
            this.status = status;
            this.neighbors = neighbors;
        }
    }

//    public boolean canFinish(int numCourses, int[][] prerequisites) {  todo 1 variant
//        if (numCourses == 1 || prerequisites.length == 0) {
//            return true;
//        }
//
//        Map<Integer, Node> mapPrerequisites = new HashMap<>();
//
//        for (int i = 0; i < numCourses; i++) {
//            mapPrerequisites.put(i, new Node());
//        }
//
//        for (int[] prerequisite : prerequisites) {
//            mapPrerequisites.get(prerequisite[1]).routes.add(prerequisite[0]);
//        }
//
//        for (int i = 0; i < numCourses; i++) {
//            Node currentNode = mapPrerequisites.get(i);
//
//            if (Objects.equals(currentNode.status, "watched")) {
//                continue;
//            }
//
//            Stack<Node> stack = new Stack<>();
//            stack.push(currentNode);
//
//            while (!stack.isEmpty()) {
//                Node node = stack.peek();
//
//                if (Objects.equals(node.status, "watched")) {
//                    stack.pop();
//                    continue;
//                }
//
//                if (Objects.equals(node.status, "watching")) {
//                    node.status = "watched";
//                    stack.pop();
//                    continue;
//                }
//
//                node.status = "watching";
//                for (Integer next : node.routes) {
//                    Node nextNode = mapPrerequisites.get(next);
//
//                    if (Objects.equals(nextNode.status, "watching")) {
//                        return false;
//                    }
//
//                    if (!Objects.equals(nextNode.status, "watched")) {
//                        stack.push(nextNode);
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//    public static class Node {
//        public String status = "unwatched";
//        public List<Integer> routes = new ArrayList<>();
//    }

//    public boolean canFinish(int numCourses, int[][] prerequisites) {         todo 2 variant
//        int[] cources = new int[numCourses];
//        for (int[] prerequisite : prerequisites) {
//            cources[prerequisite[0]]++;
//        }
//
//        List<Integer> spazy = new LinkedList<>();
//        for (int i = 0; i < cources.length; i++) {
//            if (cources[i] == 0) {
//                spazy.add(i);
//            }
//        }
//
//        int finishedCourses = 0;
//
//        while (!spazy.isEmpty()) {
//            Integer i = spazy.removeFirst();
//            finishedCourses++;
//            for (int[] prerequisite : prerequisites) {
//                if (prerequisite[1] == i) {
//                    cources[prerequisite[0]]--;
//                    if (cources[prerequisite[0]] == 0) {
//                        spazy.add(prerequisite[0]);
//                    }
//                }
//            }
//        }
//
//        return finishedCourses == numCourses;
//    }
}
