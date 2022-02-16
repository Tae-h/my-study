package com.taehoon.codingtest.programers.solutions;

import java.util.*;

public class FullSearchSolutions {


    static HashSet<Integer> set= new HashSet<>();
    static String[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2}; // return [1,2,3]
        //int[] answers = {1,2,3,4,5}; // return [1,2,3]

        //mockExam(answers);

        String numbers = "011";
        findDecimals(numbers);



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

    public static int findDecimals(String numbers) {
        int answer = 0;
        arr = new String[numbers.length()];
        visited = new boolean[numbers.length()];

        for ( int i = 0; i < numbers.length(); i++){
            arr[i] = String.valueOf(numbers.charAt(i));
        }
        recursion("", 0);

        answer= set.size();
        return answer;
    }

    //재귀: 가능한 숫자 조합을 찾고 소수여부에 따라 set에 추가
    public static void recursion(String str, int idx){
        int num;
        if(!Objects.equals(str, "")) {
            num= Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }

        if(idx== arr.length) return;

        for(int i=0; i<arr.length; i++){
            if(visited[i]) continue;
            visited[i]= true;
            recursion(str+arr[i], idx+1);
            visited[i]= false;
        }
    }//rec

    public static boolean isPrime(int num){ //소수 판별

        if ( num == 1 || num == 0 ) return false;

        for ( int i = 2; i <= Math.sqrt(num); i++ ) {
            if ( num % i == 0 ) return false;
        }

        return true;
    }

}
