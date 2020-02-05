package com.interviewbit.binarytree.traversal;

import java.util.ArrayList;
import java.util.Stack;

import com.interviewbit.binarytree.TreeNode;

public class PreOrder {

    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> S = new Stack<TreeNode>();
        if(a == null) return res;
        TreeNode curr = a;
        S.push(curr);

        while(S.size() > 0){
            curr = S.pop();
            res.add(curr.val);
            if(curr.right != null) S.push(curr.right);
            if(curr.left != null) S.push(curr.left);
        }
        return  res;
    }

	public ArrayList<Integer> preorderTraversalRec(final TreeNode A) {
		final ArrayList<Integer> ans = new ArrayList<>();
		this.preorderTraversalHelper(A, ans);
		return ans;
	}

	public void preorderTraversalHelper(final TreeNode node, final ArrayList<Integer> ans) {
		if (node != null) {
			ans.add(node.val);
			this.preorderTraversalHelper(node.left, ans);
			this.preorderTraversalHelper(node.right, ans);
		}
	}
}
