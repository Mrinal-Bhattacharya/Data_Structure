package com.interviewbit.binarytree.traversal;

import com.interviewbit.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Inorder {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null) return ans;
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = A;
        while (curr != null || s.size() > 0){
            while (curr !=  null){
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }
    public ArrayList<Integer> inorderTraversalRec(final TreeNode A) {
        final ArrayList<Integer> ans = new ArrayList<>();
        this.inorderTraversalHelper(A, ans);
        return ans;
    }

    public void inorderTraversalHelper(final TreeNode node, final ArrayList<Integer> ans) {
        if (node != null) {
            this.inorderTraversalHelper(node.left, ans);
            ans.add(node.val);
            this.inorderTraversalHelper(node.right, ans);
        }
    }
}
