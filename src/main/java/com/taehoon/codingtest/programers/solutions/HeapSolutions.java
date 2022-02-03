package com.taehoon.codingtest.programers.solutions;

import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HeapSolutions {

    public static void main(String[] args) {

        int[] scovilles = {1, 2, 3, 9, 10,5, 20, 15, 200, 12};
        //int[] scovilles = {9, 10, 12};
        int K = 100;
        // return 2;
        //System.out.println( scovilles. );
        //moreSpicy(scovilles, K);
        solution(scovilles, K);
    }

    public static int solution(int[] scoville, int K) {

        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int aScoville : scoville) {
            heap.offer(aScoville);
        }
        while (heap.peek() <= K) {
            if (heap.size() == 1) {
                return -1;
            }
            int a = heap.poll();
            int b = heap.poll();

            int result = a + (b * 2);

            heap.offer(result);
            answer ++;
        }
        return answer;

    }


    /* 더 맵게 */
    public static int moreSpicy(int[] scovilles, int K) {
        //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        int answer = 0;

        while ( !scovilleCheck(scovilles, K) ) {
            Arrays.sort(scovilles);

            int newScoville = scovilles[0] + (scovilles[1] * 2);

            scovilles = newScovilleArr(scovilles, newScoville);
            answer++;
        }

        if ( answer < 0 ) {
            answer = -1;
        }
        System.out.println(answer);
        return answer;
    }

    private static int[] newScovilleArr(int[] scovilles, int newScoville) {
        int[] newScovilleArr = new int[scovilles.length - 1];
        newScovilleArr[0] = newScoville;

        for ( int i = 1; i < newScovilleArr.length; i++ ) {
            newScovilleArr[i] = scovilles[i + 1];
        }
        System.out.println("new Arr: " + Arrays.toString(newScovilleArr));
        return newScovilleArr;
    }

    /* 스코빌 배열 체크 */
    private static Boolean scovilleCheck(int[] scovilles, int K) {
        for (int i = 0; i < scovilles.length; i++ ) {
            int scoville = scovilles[i];
            if ( scoville < K ) {
                return false;
            }
        }

        return true;
    }


}
