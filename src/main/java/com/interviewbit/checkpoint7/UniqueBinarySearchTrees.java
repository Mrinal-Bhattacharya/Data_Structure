package com.interviewbit.checkpoint7;

import com.interviewbit.binarytree.TreeNode;

import java.util.ArrayList;

public class UniqueBinarySearchTrees {
    public ArrayList<TreeNode> generateTrees(int A) {
        return generateTreesHelper(0, A);
    }

    private ArrayList<TreeNode> generateTreesHelper(final int start, final int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> leftSubtree = generateTreesHelper(start, i - 1);
            ArrayList<TreeNode> rightSubtree = generateTreesHelper(i + 1, end);
            for (int j = 0; j < leftSubtree.size(); j++) {
                TreeNode left = leftSubtree.get(j);
                for (int k = 0; k < rightSubtree.size(); k++) {
                    TreeNode right = rightSubtree.get(k);
                    TreeNode node = new TreeNode(i);        // making value i as root
                    node.left = left;              // connect left subtree
                    node.right = right;            // connect right subtree
                    list.add(node);
                }
            }
        }
        return list;
    }
}