package com.taehoon.codingtest.programers.solutions;

import java.util.Random;

public class PriSearchSolutions {

    static int count = 0;
    public static void main(String[] args) {

        int [] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        targetNumberSolution(numbers, target);



    }


    /**
     * 타겟 넘버 솔루션
     * @param numbers
     * @param target
     * @return
     */
    public static int targetNumberSolution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);

        return count;
    }

    // dfs:  Depth First Search
    public static void dfs(int[] numbers, int target, int depth, int sum) {

        if ( depth == numbers.length ) {
            if ( sum == target ) { // 이때 카운트 증가
                count++;
            }
        } else {

            dfs(numbers, target, depth + 1, sum + numbers[depth]);
            dfs(numbers, target, depth + 1, sum - numbers[depth]);
        }

    }



}
