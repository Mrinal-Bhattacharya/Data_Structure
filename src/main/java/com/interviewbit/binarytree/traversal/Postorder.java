package com.interviewbit.binarytree.traversal;

import com.interviewbit.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Postorder {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(A);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left == null && node.right == null){
                result.add(node.val);
                stack.pop();
            }
            if(node.right!=null){
                stack.push(node.right);
                node.right = null;
            }
            if(node.left !=null){
                stack.push(node.left);
                node.left = null;
            }

        }
        return result;
    }
    public ArrayList<Integer> postorderTraversalRec(final TreeNode A) {
        final ArrayList<Integer> ans = new ArrayList<>();
        this.postorderTraversalHelper(A, ans);
        return ans;
    }

    public void postorderTraversalHelper(final TreeNode node, final ArrayList<Integer> ans) {
        if (node != null) {
            this.postorderTraversalHelper(node.left, ans);
            this.postorderTraversalHelper(node.right, ans);
            ans.add(node.val);
        }
    }
}
