package com.personal.leetcode.array;

public class MissingPositive {
    public static void main(String[] args) {
        System.out.println("Missing value is: " + firstMissingPositive(new int[]{2147483647}));
        System.out.println("Missing value is: " + firstMissingPositive(new int[]{0,10,2,1}));
        System.out.println("Missing value is: " + firstMissingPositive(new int[]{20,19,18,-1,0,1,-0}));
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
}
