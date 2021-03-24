import java.util.Arrays;

/**
 * Title:
 * Desc:
 *
 * Date: 2021/3/195:57 PM
 */
public class Solution {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 3, 6, 7};
        int[] b = {4,2,5,1,6,3,7};
        Solution solution = new Solution();
        TreeNode t = solution.reConstructBinaryTree(a, b);
        System.out.println(t.left.self+" "+t.right.self+" "+t.left.left.self+" "+t.right.right.self);
    }
}
