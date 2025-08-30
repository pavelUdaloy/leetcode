import java.util.Stack;

public class M_Jump_Game_3_1306 {

    public static void main(String[] args) {
        int[] nums1 = {4, 2, 3, 0, 3, 1, 2};
        System.out.println(new M_Jump_Game_3_1306().canReach(nums1, 5));

        int[] nums2 = {4, 2, 3, 0, 3, 1, 2};
        System.out.println(new M_Jump_Game_3_1306().canReach(nums2, 0));

        int[] nums3 = {3, 0, 2, 1, 2};
        System.out.println(new M_Jump_Game_3_1306().canReach(nums3, 2));
    }

    public boolean canReach(int[] arr, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        boolean[] visited = new boolean[arr.length];

        if (arr[start] == 0) {
            return true;
        }

        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            visited[index] = true;

            if (index + arr[index] < arr.length && !visited[index + arr[index]]) {
                if (arr[index + arr[index]] == 0) {
                    return true;
                } else {
                    stack.push(index + arr[index]);
                }
            }
            if (index - arr[index] >= 0 && !visited[index - arr[index]]) {
                if (arr[index - arr[index]] == 0) {
                    return true;
                } else {
                    stack.push(index - arr[index]);
                }
            }
        }

        return false;
    }
}
