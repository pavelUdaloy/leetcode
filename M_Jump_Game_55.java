public class M_Jump_Game_55 {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums1));

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums2));
    }

    public static boolean canJump(int[] nums) {
        boolean findNotNull = false;
        int prevSymbolPoz = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != 0) {
                if (findNotNull) {
                    if (prevSymbolPoz - i <= nums[i]) {
                        findNotNull = false;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            } else if (!findNotNull) {
                findNotNull = true;
                prevSymbolPoz = i + 1;
            }
        }
        return !findNotNull;
    }
}
