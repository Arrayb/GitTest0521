package com.test;

//public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//        root.left = right;
//        root.right = left;
//        return root;
//    }
//    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(1);
//
//    }
//}
class TreeNode<T>
{
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right)
    {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}


