package com.personal.leetcode.array;

class PlusOne {
    public int[] plusOne(int[] digits) {

        int[] result;
        boolean flag = false;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += 1;
            
            if (digits[i] > 9) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }

        if (flag)
            result = new int[digits.length + 1];
        else
            result = new int[digits.length];

        for (int i = digits.length - 1, j = result.length - 1; i >= 0; i--, j--) {
            result[j] = digits[i];
        }

        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] > 9) {
                result[i] = 0;
                continue;
            }

            if (flag) result[i] += 1;
            break;
        }

        return result;
    }
}