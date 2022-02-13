package com.taehoon.codingtest.programers.solutions;

import java.util.*;

public class SortSolutions {

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        //return  {5, 6, 3};

        //kthNumber(array, commands);
        int [] numbers = {6, 10, 2}; // return "6210"
        //biggestNumber(numbers);

        int[] citations = {3, 0, 6, 1, 5}; // return 3
        getHIndex(citations);
    }

    /* k번째 수 */
    public static int[] kthNumber(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for ( int i = 0; i < commands.length; i++ ) {
            int[] command = commands[i];
            int[] tmpArr = Arrays.copyOfRange(array, command[0] - 1, command[1]);

            Arrays.sort(tmpArr);
            answer[i] = tmpArr[command[2] - 1];
        }

        return answer;
    }


    /* 가장 큰 수 */
    public static String biggestNumber(int[] numbers) {
        String answer = "";

        String[] arr = new String[numbers.length];

        for ( int i = 0; i < numbers.length; i++ ) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b); // true 면 a값 리턴
            }
        });

        if ( "0".equals(arr[0]) ) {
            return "0";
        }

        for (String a : arr) {
            answer += a;
        }

        return answer;
    }

    /**
     * H-index Solution 이게 무슨말이여????
     * n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index 입니다.
     * @param citations 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations
     * @return h-index
     */
    public static int getHIndex(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for ( int i = 0; i < citations.length; i++  ) {
            int citation = citations[i]; // 논문
            int H = citations.length - i;

            System.out.println(H);
            if (citation >= H) {
                System.out.println(citation + ", " + H);
                answer = H;
                break;
            }
        }

        return answer;
    }















}
