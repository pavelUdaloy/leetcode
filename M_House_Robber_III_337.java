import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class M_House_Robber_III_337 {

    public static void main(String[] args) {
        TreeNode root0 = new TreeNode(4,
                new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null),
                null);
        System.out.println(new M_House_Robber_III_337().rob(root0));

        TreeNode root1 = new TreeNode(3,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(3, null, new TreeNode(1)));
        System.out.println(new M_House_Robber_III_337().rob(root1));
    }


//         4
//        /
//      1
//     /
//    2
//   /
//  3
//
//        4
//       /
//      1
//     /
//    2
//   /
//  3
// root = [4,1,null,2,null,3]

    public int rob(TreeNode root) {
        int sumF = 0;
        int sumT = 0;

        Stack<Pair<TreeNode, Boolean>> stack = new Stack<>();

        stack.push(new Pair<>(root, false));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pairNode = stack.pop();

            if (!pairNode.second) {
                sumF += pairNode.first.val;
            } else {
                sumT += pairNode.first.val;
            }

            if (pairNode.first.left != null) {
                stack.push(new Pair<>(pairNode.first.left, !pairNode.second));
            }
            if (pairNode.first.right != null) {
                stack.push(new Pair<>(pairNode.first.right, !pairNode.second));
            }
        }

        return Math.max(sumF, sumT);
    }

    public static class Pair<FIRST, SECOND> {
        public FIRST first;
        public SECOND second;

        public Pair(FIRST first, SECOND second) {
            this.first = first;
            this.second = second;
        }
    }

    public static class TreeNode {
        int val;
        List<TreeNode> neighbours = new ArrayList<>();

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
