import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class M_Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another_2096 {

    public static void main(String[] args) {
        M_Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another_2096 m = new M_Step_By_Step_Directions_From_a_Binary_Tree_Node_to_Another_2096();
        TreeNode root0 = new TreeNode(5,
                new TreeNode(8,
                        new TreeNode(1,
                                new TreeNode(6),
                                null
                        ),
                        null
                ),
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(7,
                                null,
                                new TreeNode(2)
                        )
                )
        );
        System.out.println(m.getDirections(root0, 4, 3));
        TreeNode root1 = new TreeNode(5, new TreeNode(1,  new TreeNode(3),  null), new TreeNode(2, new TreeNode(6), new TreeNode(4)));
        System.out.println(m.getDirections(root1, 3, 6));
        TreeNode root2 = new TreeNode(2, new TreeNode(1), null);
        System.out.println(m.getDirections(root2, 2, 1));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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

    public static class StackNode {
        TreeNode node;
        String way;

        StackNode(TreeNode node, String way) {
            this.node = node;
            this.way = way;
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        String startWay = "";
        String endWay = "";

        boolean startComplete = false;
        boolean endComplete = false;

        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(root, ""));
        while (!startComplete || !endComplete) {
            StackNode stackNode = stack.pop();

            if (stackNode.node.val == startValue) {
                startComplete = true;
                startWay = stackNode.way;
            }
            if (stackNode.node.val == destValue) {
                endComplete = true;
                endWay = stackNode.way;
            }

            String sourceWay;
            if (stackNode.node.left != null) {
                sourceWay = stackNode.way + 'L';
                stack.push(new StackNode(stackNode.node.left, sourceWay));
            }
            if (stackNode.node.right != null) {
                sourceWay = stackNode.way + 'R';
                stack.push(new StackNode(stackNode.node.right, sourceWay));
            }
        }

        int minLength = Math.min(startWay.length(), endWay.length());
        int diffIndex = 0;
        boolean proideno = false;
        for (int i = 0; i < minLength; i++) {
            if (startWay.charAt(i) != endWay.charAt(i)) {
                diffIndex = i;
                proideno = true;
                break;
            }
        }
        if (!proideno) {
            diffIndex = minLength;
        }

        StringBuilder result = new StringBuilder();

        for (int i = diffIndex; i < startWay.length(); i++) {
            result.append("U");
        }
        result.append(endWay.substring(diffIndex));

        return result.toString();
    }
}
