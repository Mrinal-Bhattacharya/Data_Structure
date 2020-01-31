package com.interviewbit.graph.bfs;

import com.interviewbit.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (A == null) return result;

        int currentLevelNum = 1;
        int nextLevelNum = 0;
        queue.offer(A);
        ArrayList<Integer> levelList = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currentLevelNum--;
            levelList.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
                nextLevelNum++;
            }

            if (node.right != null) {
                queue.offer(node.right);
                nextLevelNum++;
            }

            if (currentLevelNum == 0) {
                currentLevelNum = nextLevelNum;
                nextLevelNum = 0;
                result.add(new ArrayList<Integer>(levelList));
                levelList.clear();
            }

        }

        return result;
    }

}
