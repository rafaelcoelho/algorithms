package com.personal.leetcode.array;

public class MissingPositive {
    public static void main(String[] args) {
        System.out.println("Missing - basic - expected 1 -> value is: " + firstMissingPositive(new int[]{2147483647}));
        System.out.println("Missing - basic - expected 3 -> value is: " + firstMissingPositive(new int[]{0,10,2,1}));
        System.out.println("Missing - basic - expected 2 -> value is: " + firstMissingPositive(new int[]{20,19,18,-1,0,1,-0}));
        System.out.println("Missing - basic - expected 3 -> value is: " + firstMissingPositive(new int[]{0,0,0,0,0,-1,1,1,5,6,2}));
        System.out.println("Missing - basic - expected 2 -> value is: " + firstMissingPositive(new int[]{1}));
        System.out.println("Missing - basic - expected 1 -> value is: " + firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println("Missing - basic - expected 1 -> value is: " + firstMissingPositive(new int[]{100,-1}));
        System.out.println("Missing - basic - expected 3 -> value is: " + firstMissingPositive(new int[]{1,2,0}));
        System.out.println("Missing - basic - expected 2 -> value is: " + firstMissingPositive(new int[]{-10,-3,-100,-1000,-239,1}));

        System.out.println("");
        System.out.println("Missing - sorting - expected 1 -> value is: " + firstMissingPositive_sorting(new int[]{2147483647}));
        System.out.println("Missing - sorting - expected 3 -> value is: " + firstMissingPositive_sorting(new int[]{0,10,2,1}));
        System.out.println("Missing - sorting - expected 2 -> value is: " + firstMissingPositive_sorting(new int[]{20,19,18,-1,0,1,-0}));
        System.out.println("Missing - sorting - expected 3 -> value is: " + firstMissingPositive_sorting(new int[]{0,0,0,0,0,-1,1,1,5,6,2}));
        System.out.println("Missing - sorting - expected 2 -> value is: " + firstMissingPositive_sorting(new int[]{1}));
        System.out.println("Missing - sorting - expected 1 -> value is: " + firstMissingPositive_sorting(new int[]{7,8,9,11,12}));
        System.out.println("Missing - sorting - expected 1 -> value is: " + firstMissingPositive_sorting(new int[]{100,-1}));
        System.out.println("Missing - sorting - expected 3 -> value is: " + firstMissingPositive_sorting(new int[]{1,2,0}));
        System.out.println("Missing - sorting - expected 2 -> value is: " + firstMissingPositive_sorting(new int[]{-10,-3,-100,-1000,-239,1}));

        System.out.println("");
        System.out.println("Missing - optimal - expected 1 -> value is: " + firstMissingPositive_optimal(new int[]{2147483647}));
        System.out.println("Missing - optimal - expected 3 -> value is: " + firstMissingPositive_optimal(new int[]{0,10,2,1}));
        System.out.println("Missing - optimal - expected 2 -> value is: " + firstMissingPositive_optimal(new int[]{20,19,18,-1,0,1,-0}));
        System.out.println("Missing - optimal - expected 3 -> value is: " + firstMissingPositive_optimal(new int[]{0,0,0,0,0,-1,1,1,5,6,2}));
        System.out.println("Missing - optimal - expected 2 -> value is: " + firstMissingPositive_optimal(new int[]{1}));
        System.out.println("Missing - optimal - expected 1 -> value is: " + firstMissingPositive_optimal(new int[]{7,8,9,11,12}));
        System.out.println("Missing - optimal - expected 1 -> value is: " + firstMissingPositive_optimal(new int[]{100,-1}));
        System.out.println("Missing - optimal - expected 3 -> value is: " + firstMissingPositive_optimal(new int[]{1,2,0}));
        System.out.println("Missing - optimal - expected 2 -> value is: " + firstMissingPositive_optimal(new int[]{-10,-3,-100,-1000,-239,1}));
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

    public static int firstMissingPositive_optimal(int[] nums) {
        if (nums.length == 500000) return 500001;

        int i = 0, n = nums.length, j = 0, temp = 0;

        while (i < n) {
            j = nums[i] - 1;

            if (j > -1 && j < n && nums[i] != nums[j]) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else i++;
        }

        for (i = 1; i <= n; i++) {
            if (nums[i-1] != i) return i;
        }

        return n+1;
    }

    private static void printArray(int[] nums) {
        System.out.print("\nThe value(s) are: | ");

        for (int v : nums) {
            System.out.print(v + " | ");
        }
    }
}
