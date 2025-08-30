import java.util.HashSet;
import java.util.Set;

public class H_Jump_Game_5_1340 {

    public static void main(String[] args) {
        int[] nums6 = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        System.out.println(new H_Jump_Game_5_1340().maxJumps(nums6, 2));

        int[] nums5 = {3, 3, 3, 3, 3};
        System.out.println(new H_Jump_Game_5_1340().maxJumps(nums5, 3));

        int[] nums0 = {6, 1, 9};
        System.out.println(new H_Jump_Game_5_1340().maxJumps(nums0, 1));

        int[] nums1 = {7,6,5,4,3,2,1};
        System.out.println(new H_Jump_Game_5_1340().maxJumps(nums1, 1));
    }

    public int maxJumps(int[] arr, int d) {
        CuLiList<Integer> sortedNumbersWithIndexes = new CuLiList<>();

        sortedNumbersWithIndexes.head = new Node<>(arr[0], 0);

        for (int i = 1; i < arr.length; i++) {
            if (sortedNumbersWithIndexes.head.value > arr[i]) {
                Node<Integer> newHead = new Node<>(arr[i], i);
                sortedNumbersWithIndexes.head.prev = newHead;
                newHead.next = sortedNumbersWithIndexes.head;
                sortedNumbersWithIndexes.head = newHead;
            } else if (sortedNumbersWithIndexes.head.value == arr[i]) {
                sortedNumbersWithIndexes.head.indexes.add(i);
            } else {
                Node<Integer> node = sortedNumbersWithIndexes.head;
                while (true) {
                    if (node.value > arr[i]) {
                        Node<Integer> newHead = new Node<>(arr[i], i);
                        node.prev.next = newHead;
                        newHead.prev = node.prev;
                        newHead.next = node;
                        node.prev = newHead;
                        break;
                    } else if (node.value == arr[i]) {
                        node.indexes.add(i);
                        break;
                    }
                    if (node.next == null) {
                        Node<Integer> newHead = new Node<>(arr[i], i);
                        node.next = newHead;
                        newHead.prev = node;
                        break;
                    } else {
                        node = node.next;
                    }
                }
            }
        }

        int maxDynamic = 1;
        int[] dynamicValues = new int[arr.length];
        Node<Integer> node = sortedNumbersWithIndexes.head;
        while (true) {
            int value = node.value;
            for (Integer index : node.indexes) {
                int max = 1;

                int rightLine = Math.min(index + d, arr.length - 1);
                for (int i = index; i <= rightLine; i++) {
                    if (i == index) {
                        continue;
                    }
                    if (arr[i] >= value) {
                        break;
                    }
                    if (dynamicValues[i] + 1 > max) {
                        max = dynamicValues[i] + 1;
                    }
                }
                int leftLine = Math.max(index - d, 0);
                for (int i = index; i >= leftLine; i--) {
                    if (i == index) {
                        continue;
                    }
                    if (arr[i] >= value) {
                        break;
                    }
                    if (dynamicValues[i] + 1 > max) {
                        max = dynamicValues[i] + 1;
                    }
                }
                dynamicValues[index] = max;
                if (maxDynamic < dynamicValues[index]) {
                    maxDynamic = dynamicValues[index];
                }
            }

            node = node.next;
            if (node == null) {
                break;
            }
        }

        return maxDynamic;
    }

    public static class CuLiList<T> {
        public Node<T> head;

        public CuLiList() {
            this.head = null;
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
