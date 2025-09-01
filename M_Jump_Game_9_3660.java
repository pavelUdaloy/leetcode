import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class M_Jump_Game_9_3660 {

    public static void main(String[] args) {
        int[] nums4 = {3, 8, 1, 10, 2, 9};
        System.out.println(Arrays.toString(new M_Jump_Game_9_3660().maxValue(nums4)));

        int[] nums2 = {5, 2, 8, 6, 3, 9, 1, 7, 4, 10};
        System.out.println(Arrays.toString(new M_Jump_Game_9_3660().maxValue(nums2)));

        int[] nums0 = {2, 1, 3};
        System.out.println(Arrays.toString(new M_Jump_Game_9_3660().maxValue(nums0)));

        int[] nums1 = {2, 3, 1};
        System.out.println(Arrays.toString(new M_Jump_Game_9_3660().maxValue(nums1)));
    }

    public int[] maxValue(int[] nums) {
        int n = nums.length;
        if (n == 0) return new int[0];

        int[] pre = new int[n];
        int[] suff = new int[n];
        int[] res = new int[n];

        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(nums[i], pre[i - 1]);
        }

        suff[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = Math.min(nums[i], suff[i + 1]);
        }

        res[n - 1] = pre[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            res[i] = pre[i];
            if (pre[i] > suff[i + 1]) {
                res[i] = res[i + 1];
            }
        }
        return res;
    }

    public int[] maxValue2(int[] nums) {
        int n = nums.length;
        int[] lefts = new int[n];
        int[] rights = new int[n];

        int maxLeft = nums[0];
        lefts[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > maxLeft) {
                maxLeft = nums[i];
            }
            lefts[i] = maxLeft;
        }

        CuLiList<Integer> list = new CuLiList<>();
        for (int i = 0; i < n; i++) {
            list.add(nums[i], i);
        }

        // инициализируем rights[last] как сам последний элемент
        rights[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            Node<Integer> node = list.getNode(nums[i]);
            int max = lefts[i];

            if (node != null && node.prev != null) {
                for (int idx : node.prev.indexes) {
                    if (idx > i) { // можно прыгнуть только вправо
                        max = Math.max(max, lefts[idx]);
                    }
                }
            }

            if (node != null && node.next != null) {
                for (int idx : node.next.indexes) {
                    if (idx > i) { // тоже вправо
                        max = Math.max(max, lefts[idx]);
                    }
                }
            }

            rights[i] = max;

            if (node != null) {
                node.indexes.remove(i);
                if (node.indexes.isEmpty()) {
                    list.remove(node);
                }
            }
        }

        int[] result = new int[n];
        // возвращаем только rights — это то, что ты вычислял как "реально достижимое"
        for (int i = 0; i < n; i++) {
            result[i] = rights[i];
        }

        return result;
    }

    public static class CuLiList<T extends Comparable<T>> {
        public Node<T> head;
        private final Map<T, Node<T>> map = new HashMap<>();

        public void add(T value, int index) {
            if (map.containsKey(value)) {
                map.get(value).indexes.add(index);
                return;
            }

            Node<T> newNode = new Node<>(value, index);
            map.put(value, newNode);

            if (head == null) {
                head = newNode;
                return;
            }

            Node<T> cur = head, prev = null;
            while (cur != null && cur.value.compareTo(value) < 0) {
                prev = cur;
                cur = cur.next;
            }

            newNode.prev = prev;
            newNode.next = cur;
            if (prev != null) prev.next = newNode;
            if (cur != null) cur.prev = newNode;

            if (prev == null) head = newNode;
        }

        public Node<T> getNode(T value) {
            return map.get(value);
        }

        public void remove(Node<T> node) {
            map.remove(node.value);
            if (node.prev != null) node.prev.next = node.next;
            if (node.next != null) node.next.prev = node.prev;
            if (head == node) head = node.next;
        }
    }

    public static class Node<T> {
        public Node<T> prev;
        public Node<T> next;
        public T value;
        public Set<Integer> indexes = new HashSet<>();

        public Node(T value, int index) {
            this.value = value;
            this.indexes.add(index);
        }
    }
}
