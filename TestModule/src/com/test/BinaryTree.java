package com.test;

import java.util.LinkedList;

public class BinaryTree<T>
    /**
     * @author 许湘扬
     * @email  547139255@qq.com
     * @detail 先序创建 各种遍历 二叉树
     */
    /*
     * 先序创建、输出 二叉树
     * 先序 二叉树
     *
     * 创建参考自：http://www.cnblogs.com/llhthinker/p/4906631.html
     * 遍历参考自：http://blog.csdn.net/sjf0115/article/details/8645991
     */
    {
        /*
         * 先序创建二叉树
         * 返回：根节点
         */
        public TreeNode<T>  creatBinaryPre(LinkedList<T> treeData)
        {
            TreeNode<T> root=null;
            T data=treeData.removeFirst();
            if (data!=null)
            {
                root=new TreeNode<T>(data, null, null);
                root.left=creatBinaryPre(treeData);
                root.right=creatBinaryPre(treeData);
            }
            return root;
        }
        /*
         * 先序遍历二叉树（递归）
         */
        public void PrintBinaryTreePreRecur(TreeNode<T> root)
        {
            if (root!=null)
            {
                System.out.print(root.data);
                PrintBinaryTreePreRecur(root.left);
                PrintBinaryTreePreRecur(root.right);
            }
        }
        /*
         * 中序遍历二叉树（递归）
         */
        public void PrintBinaryTreeMidRecur(TreeNode<T> root)
        {
            if (root!=null)
            {
                PrintBinaryTreeMidRecur(root.left);
                System.out.print(root.data);
                PrintBinaryTreeMidRecur(root.right);
            }
        }
        /*
         * 后序遍历二叉树（递归）
         */
        public void PrintBinaryTreeBacRecur(TreeNode<T> root)
        {
            if (root!=null)
            {
                PrintBinaryTreeBacRecur(root.left);
                PrintBinaryTreeBacRecur(root.right);
                System.out.print(root.data);
            }
        }
        /*
         * 先序遍历二叉树（非递归）
         * 思路：对于任意节点T，访问这个节点并压入栈中，然后访问节点的左子树，
         *      遍历完左子树后，取出栈顶的节点T，再先序遍历T的右子树
         */
        public void PrintBinaryTreePreUnrecur(TreeNode<T> root)
        {
            TreeNode<T> p=root;//p为当前节点
            LinkedList<TreeNode> stack=new LinkedList<>();
            //栈不为空时，或者p不为空时循环
            while(p!=null || !stack.isEmpty())
            {
                //当前节点不为空。访问并压入栈中。并将当前节点赋值为左儿子
                if (p!=null)
                {
                    stack.push(p);
                    System.out.print(p.data);
                    p=p.left;
                }
                //当前节点为空：
                //  1、当p指向的左儿子时，此时栈顶元素必然是它的父节点
                //  2、当p指向的右儿子时，此时栈顶元素必然是它的爷爷节点
                //取出栈顶元素，赋值为right
                else
                {
                    p=stack.pop();
                    p=p.right;
                }
            }
        }
        /*
         * 中序遍历二叉树（非递归）
         *
         * 思路：先将T入栈，遍历左子树；遍历完左子树返回时，栈顶元素应为T，
         *       出栈，访问T->data，再中序遍历T的右子树。
         */
        public void PrintBinaryTreeMidUnrecur(TreeNode<T> root)
        {
            TreeNode<T> p=root;//p为当前节点
            LinkedList<TreeNode> stack=new LinkedList<>();

            //栈不为空时，或者p不为空时循环
            while(p!=null || !stack.isEmpty())
            {
                //当前节点不为空。压入栈中。并将当前节点赋值为左儿子
                if (p!=null)
                {
                    stack.push(p);
                    p=p.left;
                }
                //当前节点为空：
                //  1、当p指向的左儿子时，此时栈顶元素必然是它的父节点
                //  2、当p指向的右儿子时，此时栈顶元素必然是它的爷爷节点
                //取出并访问栈顶元素，赋值为right
                else
                {
                    p=stack.pop();
                    System.out.print(p.data);
                    p=p.right;
                }
            }
        }
        /*
         * 后序遍历二叉树（非递归）
         *
         */
        public void PrintBinaryTreeBacUnrecur(TreeNode<T> root)
        {
            class NodeFlag<T>
            {
                TreeNode<T> node;
                char tag;
                public NodeFlag(TreeNode<T> node, char tag) {
                    super();
                    this.node = node;
                    this.tag = tag;
                }
            }
            LinkedList<NodeFlag<T>> stack=new LinkedList<>();
            TreeNode<T> p=root;
            NodeFlag<T> bt;
            //栈不空或者p不空时循环
            while(p!=null || !stack.isEmpty())
            {
                //遍历左子树
                while(p!=null)
                {
                    bt=new NodeFlag(p, 'L');
                    stack.push(bt);
                    p=p.left;
                }
                //左右子树访问完毕访问根节点
                while(!stack.isEmpty() && stack.getFirst().tag=='R')
                {
                    bt=stack.pop();
                    System.out.print(bt.node.data);
                }
                //遍历右子树
                if (!stack.isEmpty())
                {
                    bt=stack.peek();
                    bt.tag='R';
                    p=bt.node;
                    p=p.right;
                }
            }
        }
        /*
         * 层次遍历二叉树（非递归）
         */
        public void PrintBinaryTreeLayerUnrecur(TreeNode<T> root)
        {
            LinkedList<TreeNode> queue=new LinkedList<>();
            TreeNode<T> p;
            queue.push(root);
            while(!queue.isEmpty())
            {
                p=queue.removeFirst();
                System.out.print(p.data);
                if (p.left!=null)
                    queue.addLast(p.left);
                if (p.right!=null)
                    queue.addLast(p.right);
            }
        }
    }

