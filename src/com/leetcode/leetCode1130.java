package com.leetcode;

import org.junit.Test;

/**
 * @author lannisite
 * @program leetCode1130
 * @description 描述
 * @date 2022/11/30 16:38
 */

public class leetCode1130 {

    /**
     * Definition for a binary tree node.
     * */
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return build(nums,0,nums.length-1);
        }


        public TreeNode build(int nums[],int left,int right){
            if(left>right)return null;
            int mid = (left+right)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = build(nums,left,mid-1);
            root.right = build(nums,mid+1,right);
            return root;
        }


        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root==null)return false;
            return dfs(targetSum,0,root);
        }

        public boolean dfs(int t,int sum,TreeNode root){
            if(root==null&&sum==t)return true;
            else if(root==null)return false;
            return ((dfs(t,sum+root.val,root.left)&&((root.right==null|root.left!=null)))|(dfs(t,sum+ root.val,root.right)&&(root.left==null|root.right!=null)));
        }



    }

    @Test
    public void Test(){
         Solution s = new Solution();
        System.out.println(s.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }


}
