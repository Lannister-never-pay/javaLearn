package com.leetcode;

import org.junit.Test;

import java.util.Queue;

/**
 * @author lannisite
 * @program leetCode1129
 * @description 描述
 * @date 2022/11/29 22:42
 */

public class leetCode1129 {

    /**
     * Definition for a binary tree node.
     * */
      public class TreeNode1 {
          int val;
          TreeNode1 left;
          TreeNode1 right;
          TreeNode1(int x) { val = x; }
      }

      class Solution1 {
        public boolean isBalanced(TreeNode1 root) {
            if(root==null)return true;
            else if(Math.abs(Depth(root.left)-Depth(root.right))>1)return false;
            else return isBalanced(root.right)&&isBalanced(root.left);
        }

        public Integer Depth(TreeNode1 root){
            if(root==null)return 0;
            else return Math.max(Depth(root.right),Depth(root.left))+1;
        }
    }


     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    class Solution {
        public int minDepth(TreeNode root) {
            if(root==null)return 0;
            if(root.left==null||root.right==null)return Math.max(minDepth(root.left),minDepth(root.right))+1;
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        }
    }




}
