/**
 * Preorder
 * Inorder
 * PostOrder
 */
class 98ValidBinarySearchTree {

    long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        //return verifyPreorder(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        // return verifyInorder(root);
        return f(root)[1] != Long.MAX_VALUE;
    }

    private boolean verifyPreorder(TreeNode root, int left, int right) {
        if (root == null) return true;
        
        if (root.val <= left || root.val >= right) return false;

        return verifyPreorder(root.left, left, root.val) && verifyPreorder(root.right, root.val, right);
    }

    private boolean verifyInorder(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (verifyInorder(root.left) == false) return false;
        if (prev >= root.val) {
            return false;
        }
        prev = root.val;
        return verifyInorder(root.right);
    }

    // 用 Long.MAX_VALUE 和 Long.MIN_VALUE 充当正负无穷
    private long[] f(TreeNode node) {
        if (node == null) {
            return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        }
        
        long[] l = f(node.left);
        long[] r = f(node.right);
        
        long x = node.val;
        // 这里的比较和 Python 一模一样，且不会有溢出/等于的问题
        if (x <= l[1] || x >= r[0]) {
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        }
        
        return new long[]{Math.min(l[0], x), Math.max(r[1], x)};
    }
}