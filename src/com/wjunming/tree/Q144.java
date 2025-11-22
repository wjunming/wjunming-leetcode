package com.wjunming.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/description/">144. 二叉树的前序遍历</a>
 */
public class Q144 {

    /**
     * 递归
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    private void recursion(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            recursion(root.left, result);
            recursion(root.right, result);
        }
    }

    /**
     * 迭代
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }
}
