import java.util.ArrayList;
import java.util.List;

public class H_K_th_Smallest_in_Lexicographical_Order_440 {

    public static void main(String[] args) {
        H_K_th_Smallest_in_Lexicographical_Order_440 task = new H_K_th_Smallest_in_Lexicographical_Order_440();
        System.out.println(task.findKthNumber(13, 2));
//        System.out.println(task.findKthNumber(1, 1));
//        System.out.println(task.findKthNumber(100, 50));
//        System.out.println(task.findKthNumber(999, 99));
//        System.out.println(task.findKthNumber(4289384, 1922239)); // 2730010
//        System.out.println(task.findKthNumber(7747794, 5857460)); // 6271710
    }

    public int findKthNumber(int n, int k) {
        int currentPrefix = 1;
        k--;

        while (k > 0) {
            int count = countNumbersWithPrefix(currentPrefix, n);
            if (k >= count) {
                currentPrefix++;
                k -= count;
            } else {
                currentPrefix *= 10;
                k--;
            }
        }

        return currentPrefix;
    }

    private int countNumbersWithPrefix(int prefix, int n) {
        long firstNumber = prefix, nextNumber = prefix + 1;
        int totalCount = 0;

        while (firstNumber <= n) {
            totalCount += Math.min(n + 1, nextNumber) - firstNumber;
            firstNumber *= 10;
            nextNumber *= 10;
        }

        return totalCount;
    }
}
