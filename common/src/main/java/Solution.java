import java.util.ArrayList;

/**
 * Title:
 * Desc:
 * <p>
 * Date: 2021/3/195:57 PM
 */
public class Solution {

//    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//        if (pre.length == 0 || in.length == 0) {
//            return null;
//        }
//        TreeNode node = new TreeNode(pre[0]);
//        for (int i = 0; i < in.length; i++) {
//            if (pre[0] == in[i]) {
//                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
//                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
//            }
//        }
//        return node;
//    }
//
//    public static void main(String[] args) {
//        int[] a = {1, 2, 4, 5, 3, 6, 7};
//        int[] b = {4,2,5,1,6,3,7};
//        Solution solution = new Solution();
//        TreeNode t = solution.reConstructBinaryTree(a, b);
//        System.out.println(t.left.self+" "+t.right.self+" "+t.left.left.self+" "+t.right.right.self);
//    }


    public static void main(String[] args) {
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        ArrayList<Integer> out = GetLeastNumbers_Solution(input, k);
        System.out.println(out);
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> output = new ArrayList();
        if (k > input.length) {
            return output;
        }
        for (int i = 0; i < input.length; i++) {
            output.add(input[i]);
        }
        int l = output.size();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (output.get(j) > output.get(j + 1)) {
                    int men = output.get(j);
                    output.set(j, output.get(j + 1));
                    output.set(j + 1, men);
                }
            }
        }
        if (output.size() > k) {
            for (int i = k; i < output.size();) {
                output.remove(i);
            }
            return output;
        } else {
            return new ArrayList();
        }
    }
}
