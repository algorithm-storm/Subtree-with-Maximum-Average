/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {

    public static void main(String [] args){

        TreeNode root = new TreeNode(1);
        TreeNode leftTree = new TreeNode(2);
        root.left = leftTree;
        TreeNode rightTree4 = new TreeNode(4);
        TreeNode rightTree5 = new TreeNode(5);
        TreeNode rightTree = new TreeNode(3);
        rightTree.left = rightTree4;
        rightTree.right = rightTree5;
        root.right = rightTree;
        Solution a = new Solution();
        System.out.println(a.findSubtree2(root).val);
    }

    ResultType maxResultType;
    TreeNode maxNode;

    class ResultType{
        public int sum;
        public int size;
        public ResultType(int sum, int size){
            this.sum = sum;
            this.size = size;
        }
    }
    /*
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        maxResultType = new ResultType(Integer.MIN_VALUE,1);
        maxNode = null;
        helper(root);
        return maxNode;
    }

    public ResultType helper(TreeNode root){

        if(root == null){
            return new ResultType(0,0);
        }

        ResultType leftTree = helper(root.left);
        ResultType rightTree = helper(root.right);
        ResultType rootTree = new ResultType(leftTree.sum+rightTree.sum+root.val, leftTree.size + rightTree.size + 1);

        if(rootTree.sum * maxResultType.size > rootTree.size * maxResultType.sum){
            maxResultType = rootTree;
            maxNode = root;
        }
        return rootTree;
    }

}