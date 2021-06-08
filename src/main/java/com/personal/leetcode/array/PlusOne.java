package com.personal.leetcode.array;

class PlusOne {
    public int[] plusOne(int[] digits) {

        int[] result;
        boolean flag = false;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            
            if (digits[i] > 9) {
                flag = true;
                digits[i] = 0;
            } else {
                flag = false;
                break;
            }
        }

        if (flag)
            result = new int[digits.length + 1];
        else
            return digits;

        result[0] += 1;

        return result;
    }
}