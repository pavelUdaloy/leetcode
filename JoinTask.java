import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JoinTask {

    public static void main(String[] args) {
        List<Pair<Integer, String>> left = new ArrayList<>();
        left.add(new Pair<>(1, "A"));
        left.add(new Pair<>(2, "B"));
        left.add(new Pair<>(3, "C"));

        List<Pair<Integer, String>> right = new ArrayList<>();
        right.add(new Pair<>(1, "X"));
        right.add(new Pair<>(2, "Y"));
        right.add(new Pair<>(4, "Z"));

        List<Triple<Integer, String, String>> result = join(left, right);

        for (Triple<Integer, String, String> triple : result) {
            System.out.println(triple.first + ", " + triple.second + ", " + triple.third);
        }
    }

    private static List<Triple<Integer, String, String>> join(List<Pair<Integer, String>> left, List<Pair<Integer, String>> right) {
        List<Set<String>> list = new ArrayList<>(1000);
        for (int i = 0; i < 10000; i++) {
            list.add(new HashSet<>());
        }

        for (Pair<Integer, String> pair : left) {
            Set<String> strings = list.get(pair.first);
            if (strings == null) {
                list.set(pair.first, new HashSet<>());
            }
            list.get(pair.first).add(pair.second);
        }
        for (Pair<Integer, String> pair : right) {
            Set<String> strings = list.get(pair.first);
            if (strings == null) {
                list.set(pair.first, new HashSet<>());
            }
            list.get(pair.first).add(pair.second);
        }
        List<Triple<Integer, String, String>> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Set<String> strings = list.get(i);
            ArrayList<String> strings1 = new ArrayList<>(strings);
            if (strings.size() == 2) {
                result.add(new Triple<>(i, strings1.get(0), strings1.get(1)));
                System.out.println(strings);
            }
        }
        return result;
    }


    private static class Pair<A, B> {

        private A first;
        private B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class Triple<A, B, C> {

        private A first;
        private B second;
        private C third;

        Triple(A first, B second, C third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}