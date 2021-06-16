package com.personal.leetcode.array;

public class MissingPositive {
    public static void main(String[] args) {
        // System.out.println("Missing value is: " + firstMissingPositive(new int[]{2147483647}));
        // System.out.println("Missing value is: " + firstMissingPositive(new int[]{0,10,2,1}));
        // System.out.println("Missing value is: " + firstMissingPositive(new int[]{20,19,18,-1,0,1,-0}));

        System.out.println("Missing - sorting 1 -> value is: " + firstMissingPositive_sorting(new int[]{2147483647}));
        System.out.println("Missing - sorting 3 -> value is: " + firstMissingPositive_sorting(new int[]{0,10,2,1}));
        System.out.println("Missing - sorting 2 -> value is: " + firstMissingPositive_sorting(new int[]{20,19,18,-1,0,1,-0}));
        System.out.println("Missing - sorting 3 -> value is: " + firstMissingPositive_sorting(new int[]{0,0,0,0,0,-1,1,1,5,6,2}));
        System.out.println("Missing - sorting 2 -> value is: " + firstMissingPositive_sorting(new int[]{1}));
        System.out.println("Missing - sorting 1 -> value is: " + firstMissingPositive_sorting(new int[]{7,8,9,11,12}));
        System.out.println("Missing - sorting 1 -> value is: " + firstMissingPositive_sorting(new int[]{100,-1}));
        System.out.println("Missing - sorting 3 -> value is: " + firstMissingPositive_sorting(new int[]{1,2,0}));
        System.out.println("Missing - sorting 2 -> value is: " + firstMissingPositive_sorting(new int[]{-10,-3,-100,-1000,-239,1}));
    }

    public static int firstMissingPositive(int[] nums) {
        long max = 0L;
        java.util.HashSet<Integer> set = new java.util.HashSet<>(nums.length);

        for (int v : nums) {
            if (v > max) max = v;
            set.add(v);
        }

        for (int i = 1; i <= max + 1; i++) {
            if (!set.contains(i)) return i;
        }

        return -1;
    }

    public static int firstMissingPositive_sorting(int[] nums) {
        java.util.Arrays.sort(nums);
        int next = 1;
        int prev = -1;

        if (nums.length == 1) {
            if (nums[0] != 1) return 1;
            if (nums[0] == 1) return 2;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] < 1) continue;
            if (nums[j] == prev) continue;

            if (nums[j] != next) return next;

            prev = nums[j];
            next++;
        }

        return next;
    }
}
