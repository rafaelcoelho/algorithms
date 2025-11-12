package com.personal.leetcode.sub.string;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SerializationUtils;

import java.util.ArrayDeque;
import java.util.HashMap;

import static com.personal.leetcode.sub.string.SubStringSeqSolution.findNumberOfSubSequences;

public class StringSubSequence {
    public static void main(String[] args) {
        System.out.println("Expected is 4 -> " + findNumberOfSubSequences("xxxabcde", new String[]{"a", "bb", "acd", "ace", "xxx"}));
        System.out.println("Expected is 1 -> " + findNumberOfSubSequences("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
    }
}


class SubStringSeqSolution {

    //Time complexity is O(NM)
    public static int findNumberOfSubSequences(final String base, final String[] words) {

        final char[] letters = base.toCharArray();
        final HashMap<Character, ArrayDeque<Integer>> tokens = new HashMap<>();

        for (int i = 0; i < letters.length; i++) {
            var ref = tokens.get(letters[i]);

            if (ref == null) {
                ArrayDeque<Integer> value = new ArrayDeque<>();
                value.add(i);
                tokens.put(letters[i], value);
            } else ref.add(i);
        }

        var matches = 0;

        for (String w : words) {
            var clonedTokens = SerializationUtils.clone(tokens);
            var result = 0;

            for (char c : w.toCharArray()) {
                var letterDeque = clonedTokens.get(c);

                if (ObjectUtils.isNotEmpty(letterDeque)) {
                    result = getUpdatedPosition(letterDeque, result);
                    if (result == -1) break;
                } else {
                    result = -1;
                    break;
                }
            }

            if (result != -1) matches++;
        }

        return matches;
    }

    //Time complexity is 0(1)
    private static int getUpdatedPosition(final ArrayDeque<Integer> seq, final int currentPos) {
        var pos = seq.pop();
        return pos >= currentPos ? pos : -1;
    }
}