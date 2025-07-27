public class M_Jump_Game_2_45 {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(jump(nums1));

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(jump(nums2));

        int[] nums3 = {4, 5, 1, 1, 4, 1, 1, 1, 1};
        System.out.println(jump(nums3)); // 2
    }

    public static int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int counter = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                counter++;
                currentEnd = farthest;
            }
        }

        return counter;
    }
}
