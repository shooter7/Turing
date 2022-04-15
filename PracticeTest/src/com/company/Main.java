package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] s=new String[]{"5", "-2","4", "C", "D", "9","+","+"};
        System.out.print(calculatePoints(s)+"");
    }

    public static int calculatePoints(String[] ops) {
        int result = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "D" -> list.add(2 * (list.get(list.size() - 1)));
                case "C" -> list.remove(list.get(list.size() - 1));
                case "+" -> list.add(
                        list.get(list.size() - 1) + list.get(list.size() - 2)
                );
                default -> list.add(Integer.valueOf(ops[i]));
            }
        }

        result=list.stream()
                .reduce(0, Integer::sum);
        return result;
    }
}
