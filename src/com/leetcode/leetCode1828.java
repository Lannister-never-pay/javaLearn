package com.leetcode;

/**
 * @author lannisite
 * @program leetCode1828
 * @description 描述
 * @date 2023/1/24 22:13
 */

public class leetCode1828 {

    public int[] countPoints(int[][] points, int[][] queries) {

        int[] ans = new int[queries.length];
        for(int i=0;i< ans.length;i++){
            ans[i]=0;
        }
        for(int i=0;i< queries.length;i++){
            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];
            for(int j=0;j< points.length;j++){
                int x0 = points[j][0];
                int y0 = points[j][1];
                if(r*r>=(x-x0)*(x-x0)+(y-y0)*(y-y0)){
                    ans[i]++;
                }
            }
        }

        return ans;
    }


}
