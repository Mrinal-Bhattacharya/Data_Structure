package com.interviewbit.binarytree.example;

import com.interviewbit.binarytree.TreeNode;

import java.util.Stack;

public class NextGreaterNumberBST {
    public TreeNode getSuccessor(TreeNode a, int b) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode cur = a;
        while(cur!=null || !st.isEmpty()){
            while(cur!=null){
                st.push(cur);
                cur = cur.left;
            }

            TreeNode temp = st.pop();
            if(temp.val>b){
                return temp;
            }
            cur = temp.right;
        }
        return null;
    }
    public TreeNode getSuccessor2(TreeNode root, int data) {
        if( root == null ) return null;
        TreeNode temp = null ;
        while( root != null ){
            if( root.val > data )
            {
                temp = root;
                root = root.left;
            }
            else
                root = root.right;
        }
        return temp;
    }
}
