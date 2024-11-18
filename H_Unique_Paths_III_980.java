import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class H_Unique_Paths_III_980 {

    public static void main(String[] args) {

        int[][] array = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        System.out.println(new H_Unique_Paths_III_980().uniquePathsIII(array));

        int[][] array2 = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        };
        System.out.println(new H_Unique_Paths_III_980().uniquePathsIII(array2));

        int[][] array3 = {
                {0, 1},
                {2, 0}
        };
        System.out.println(new H_Unique_Paths_III_980().uniquePathsIII(array3));
    }

    public class QueueNode {

        public int[][] array;
        public int nNow;
        public int mNow;

        public QueueNode(int[][] array, int nNow, int mNow) {
            this.array = array;
            this.nNow = nNow;
            this.mNow = mNow;
        }
    }

    public static int result;
    public static Queue<QueueNode> queue;

    public int uniquePathsIII(int[][] grid) {
        result = 0;
        queue = new PriorityQueue<>(new Comparator<QueueNode>() {
            @Override
            public int compare(QueueNode node1, QueueNode node2) {
                // Пример: сравнение по строке nNow
                return Integer.compare(node1.nNow, node2.nNow);
            }
        });

        int startN = 0;
        int startM = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startN = i;
                    startM = j;
                }
            }
        }

        queue.offer(new QueueNode(copyArray(grid), startN, startM));

        while (!queue.isEmpty()) {
            QueueNode node = queue.poll();
            checkNode(node);
        }

        return result;
    }

    private void checkNode(QueueNode node) {
        node.array[node.nNow][node.mNow] = 5;

        if (node.nNow != 0 && node.array[node.nNow - 1][node.mNow] == 0) {
            queue.add(new QueueNode(copyArray(node.array), node.nNow - 1, node.mNow));
        } else if (node.nNow != 0 && node.array[node.nNow - 1][node.mNow] == 2) {
            checkResult(copyArray(node.array));
        }
        if (node.mNow != 0 && node.array[node.nNow][node.mNow - 1] == 0) {
            queue.add(new QueueNode(copyArray(node.array), node.nNow, node.mNow - 1));
        } else if (node.mNow != 0 && node.array[node.nNow][node.mNow - 1] == 2) {
            checkResult(copyArray(node.array));
        }
        if (node.nNow != node.array.length - 1 && node.array[node.nNow + 1][node.mNow] == 0) {
            queue.add(new QueueNode(copyArray(node.array), node.nNow + 1, node.mNow));
        } else if (node.nNow != node.array.length - 1 && node.array[node.nNow + 1][node.mNow] == 2) {
            checkResult(copyArray(node.array));
        }
        if (node.mNow != node.array[0].length - 1 && node.array[node.nNow][node.mNow + 1] == 0) {
            queue.add(new QueueNode(copyArray(node.array), node.nNow, node.mNow + 1));
        } else if (node.mNow != node.array[0].length - 1 && node.array[node.nNow][node.mNow + 1] == 2) {
            checkResult(copyArray(node.array));
        }
    }

    private void checkResult(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    return;
                }
            }
        }
        result++;
    }

    private int[][] copyArray(int[][] array) {
        if (array == null) {
            return null;
        }
        int[][] copiedArray = new int[array.length][];

        for (int i = 0; i < array.length; i++) {
            copiedArray[i] = new int[array[i].length];
            copiedArray[i] = Arrays.copyOf(array[i], array[i].length);
        }

        return copiedArray;
    }
}
