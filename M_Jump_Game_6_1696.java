import java.util.LinkedList;

public class M_Jump_Game_6_1696 {

    public static void main(String[] args) {
        int[] nums7 = {-300, -200, -500, 400, 500, -1000};
        System.out.println(new M_Jump_Game_6_1696().maxResult(nums7, 3));

        int[] nums5 = {10, -5, -2, 4, 0, 3};
        System.out.println(new M_Jump_Game_6_1696().maxResult(nums5, 3));

        int[] nums6 = {1, -1, -2, 4, -7, 3};
        System.out.println(new M_Jump_Game_6_1696().maxResult(nums6, 2));

        int[] nums0 = {1, -5, -20, 4, -1, 3, -6, -3};
        System.out.println(new M_Jump_Game_6_1696().maxResult(nums0, 2));
    }

    public int maxResult(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        for (int i = 1; i < nums.length; i++) {
            if (list.getFirst() < i - k) {
                list.removeFirst();
            }
            nums[i] += nums[list.getFirst()];
            while (!list.isEmpty() && nums[list.getLast()] <= nums[i]) {
                list.removeLast();
            }
            list.addLast(i);
        }
        return nums[nums.length - 1];
    }
}
