package com.personal.leetcode.array;

class Solution {

    //O(n) of time complexity
    //O(1) of space complexity
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int v1 = nums[0];
        int pos = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (v1 == nums[i]) continue;
            
            nums[pos] = nums[i];
            v1 = nums[i];
            pos++;
        }
        
        return pos;
    }
}