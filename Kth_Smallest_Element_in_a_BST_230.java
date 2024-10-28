public class Kth_Smallest_Element_in_a_BST_230 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Kth_Smallest_Element_in_a_BST_230 aaa = new Kth_Smallest_Element_in_a_BST_230();

        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        TreeNode roo2 = new TreeNode(6, new TreeNode(2, null, new TreeNode(4)), new TreeNode(8));
        TreeNode roo3 = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1, null, null), null), new TreeNode(4)), new TreeNode(6));

        System.out.println(aaa.kthSmallest(roo3, 3));
    }

    public int RESULT;

    public int kthSmallest(TreeNode root, int k) {
        RESULT = root.val;
        int value = 0;
        if (root.left != null) {
            value = rec(k, root.left, value);
        }
        value++;
        if (value == k) {
            return root.val;
        }
        if (root.right != null) {
            rec(k, root.right, value);
        }

        return RESULT;
    }

    private int rec(int k, TreeNode node, int value) {
        if (node.left != null) {
            value = rec(k, node.left, value);
        }
        value++;
        if (value == k) {
            RESULT = node.val;
        }

        if (node.right != null) {
            value = rec(k, node.right, value);
        }

        return value;
    }
}
