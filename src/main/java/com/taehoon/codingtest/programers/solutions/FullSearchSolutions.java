package com.taehoon.codingtest.programers.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullSearchSolutions {

    public static void main(String[] args) {

        int[] answers = {1,3,2,4,2}; // return [1,2,3]
        //int[] answers = {1,2,3,4,5}; // return [1,2,3]

        mockExam(answers);

    }

    public static int[] mockExam(int[] answers) {
        int[] score = {0, 0, 0};
        // 사람 a,b,c
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for ( int i = 0; i < answers.length; i++  ) {
            if ( answers[i] == a[i % a.length] ) {
                score[0]++;
            }

            if ( answers[i] == b[i % b.length] ) {
                score[1]++;
            }

            if ( answers[i] == c[i % c.length] ) {
                score[2]++;
            }
        }

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]) );

        List<Integer> list = new ArrayList<>();
        if ( maxScore == score[0] ) list.add(1);
        if ( maxScore == score[1] ) list.add(2);
        if ( maxScore == score[2] ) list.add(3);

        return list.stream().mapToInt(item -> item.intValue()).toArray();
    }

}
