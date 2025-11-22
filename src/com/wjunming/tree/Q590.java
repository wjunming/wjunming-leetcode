package com.wjunming.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.cn/problems/n-ary-tree-postorder-traversal/description/">590. N 叉树的后序遍历</a>
 */
public class Q590 {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    private void recursion(Node root, List<Integer> result) {
        if (root != null) {
            for (Node node : root.children) {
                recursion(node, result);
            }
            result.add(root.val);
        }
    }
}
