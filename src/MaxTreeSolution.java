import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * Created by xsun on 15-09-20.
 */

public class MaxTreeSolution {
    /*
    如果能够确定每个节点的父亲节点，则可以构造出整棵树。找出每个数往左数第一个比他大的数和往右数第一个比他大的数，
    两者中较小的数即为该数的父亲节点。如：[3,1,2]，3没有父亲节点，1的父亲节点为2，2的父亲节为3。
    并且可以根据与父亲的位置关系来确定是左儿子还是右儿子。接下来的问题是如何快速找出每个数往左、往右第一个比他大的数。
    这里需要用到数据结构栈。以找每个数左边第一个比他大的数为例，从左到右遍历每个数，栈中保持递减序列，
    新来的数不停的Pop出栈顶直到栈顶比新数大或没有数。以[3,1,2]为例，首先3入栈，接下来1比3小，无需pop出3，1入栈，
    并且确定了1往左第一个比他大的数为3。接下来2比1大，1出栈，2比3小，2入栈。并且确定了2往左第一个比他大的数为3。
    用同样的方法可以求得每个数往右第一个比他大的数。时间复杂度O(n)，空间复杂度也是O(n)为最优解法。
     */
    public TreeNode maxTree(int[] A) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = null;
        stack.push(new TreeNode(A[0]));
        for (int i = 1; i < A.length; i++) {
            if (A[i] < stack.peek().val) {
                stack.push(new TreeNode(A[i]));
            } else {
                TreeNode node = stack.pop();
                while (!stack.isEmpty() && stack.peek().val < A[i]){
                    TreeNode tmp = stack.pop();
                    tmp.right = node;
                    node = tmp;
                }

                TreeNode newNode = new TreeNode(A[i]);
                newNode.left = node;
                stack.push(newNode);
            }
        }

        root = stack.pop();
        while (!stack.isEmpty()){
            stack.peek().right = root;
            root = stack.pop();
        }

        return root;
    }
}
