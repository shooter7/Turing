package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] a = {5, 6, 10, 3, 6};
        System.out.println(solution(a));
    }

    public static int solution(int[] A) {
        boolean shorter = false;
        HashSet<Integer> result=new HashSet<>();

        if (A.length == 0 || A.length == 1) return 0;

        if (A[0] == A[1]) {
            result.add(1);
            A[1] = A[0] - 1;
            shorter = true;
        } else if (A[0] > A[1]) {
            shorter = true;
        }

        for (int i = 1; i < A.length - 1; i++) {
            if (shorter) {
                if (A[i] >= A[i + 1]) {
                    result.add(i);
                    A[i] = A[i + 1] - 1;
                }
            } else {
                if (A[i] <= A[i + 1]) {
                    result.add(i+1);
                    A[i + 1] = A[i] - 1;
                }
            }
            shorter = !shorter;
        }

        return result.size();
    }
}
