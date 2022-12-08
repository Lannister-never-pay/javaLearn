package com.DataStructure;

import com.leetcode.leetCode1130;

/**
 * @author lannisite
 * @program AVL
 * @description 描述
 * @date 2022/11/30 18:06
 */

public class AVL {

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




    public int depth(TreeNode root){
        if(root==null)return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }





}
