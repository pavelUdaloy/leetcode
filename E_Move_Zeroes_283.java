public class E_Move_Zeroes_283 {

    public static void main(String[] args) {
        E_Move_Zeroes_283 task = new E_Move_Zeroes_283();

        int[] nums1 = {0, 1, 0, 3, 12};
        task.moveZeroes(nums1);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] nums2 = {0};
        task.moveZeroes(nums2);
        for (int i : nums2) {
            System.out.print(i + " ");
        }
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int bucket = nums[i];
                        nums[i] = nums[j];
                        nums[j] = bucket;
                        break;
                    }
                }
            }
        }
    }
}
