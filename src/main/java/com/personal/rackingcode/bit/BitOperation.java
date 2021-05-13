package com.personal.rackingcode.bit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BitOperation {

    static class BitInteger{
        int value;
        static int INTEGER_SIZE = 3;

        BitInteger(int value) {
            this.value = value;
        }

        int fetch(int column) {
            return (value >> column) % 2;
        }
    }

    public static void main(String[] args){
        List<BitInteger> numbers = new LinkedList<>();
        numbers.add(new BitInteger(0b000)); //0x00
        numbers.add(new BitInteger(0b001)); //0x01
        numbers.add(new BitInteger(0b010)); //0x02
//        numbers.add(new BitInteger(0b011)); //0x03
        numbers.add(new BitInteger(0b100)); //0x04
        numbers.add(new BitInteger(0b101));  //0x05
        numbers.add(new BitInteger(0b110)); //0x06
        numbers.add(new BitInteger(0b111)); //0x07

        System.out.println("findMissing(numbers) = " + findMissing(numbers));
    }

    static int findMissing(List<BitInteger> elements) {
        return findMissing(elements, 0);
    }

    static int findMissing(List<BitInteger> elements, int column) {
        if (column >= BitInteger.INTEGER_SIZE) return 0;

        List<BitInteger> zeros = new ArrayList<>();
        List<BitInteger> ones = new ArrayList<>();
        for (BitInteger el : elements) {
            if (el.fetch(column) == 0x00) {
                zeros.add(el);
            } else {
                ones.add(el);
            }
        }

        if (zeros.size() <= ones.size()) {
            int v = findMissing(zeros, column + 1);
            return (v << 1);
        } else {
            int v = findMissing(ones, column + 1);
            return (v << 1) | 1;
        }
    }
}
