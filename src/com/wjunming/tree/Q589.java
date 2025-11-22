package com.wjunming.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/n-ary-tree-preorder-traversal/description/">589. N 叉树的前序遍历</a>
 */
public class Q589 {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    private void recursion(Node root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            for (Node node : root.children) {
                recursion(node, result);
            }
        }
    }
}
