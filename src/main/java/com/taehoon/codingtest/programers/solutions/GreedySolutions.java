package com.taehoon.codingtest.programers.solutions;

import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class GreedySolutions {

    public static void main(String[] args) {
        /*
        n	lost	reserve	return
        5	[2, 4]	[1, 3, 5]  5
        5	[2, 4]	[3]	       4
        3	[3]	    [1]	       2
         */
        int n = 3;
        int[] lost = {3};
        int[] reserve = { 3 };
        //gymSuit(n, lost, reserve);

        String name = "JBBAAB"; // return 56
       // joyStick(name);

        String number = "1231234";
        //makeBigNumber(number, 3);

        //int[] people = {50, 60, 50, 40};
        int[] people = {70, 80, 50};

        lifeBoat(people,100); // return 3;
    }


    /* 체육복 */
    public static int gymSuit (int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        // 도난당한 학생에게 체육복 빌려주는 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }

    /* 조이스틱 */
    public static int joyStick(String name) {
        int answer = 0;
        System.out.println(name);
        int lrMove = name.length() - 1; // default 좌우 이동 최대 횟수
        /* N이 기준임 */
        for ( int i = 0; i < name.length(); i++ ) {
            int strLength = name.length();
            /* 둘 중에 최솟값 으로  */
            answer += Math.min('Z' - name.charAt(i) + 1, name.charAt(i) - 'A');

            // 좌우 횟수
            int idxA = i + 1; // <-- 'A' 일 경우 인덱스
            while ( idxA < strLength && name.charAt(idxA) == 'A' ) {
                idxA++;
            }

            System.out.println(lrMove + ", " + i + (strLength - idxA) + Math.min(i, strLength - idxA));
            lrMove = Math.min(lrMove, i + (strLength - idxA) + Math.min(i, strLength - idxA) ); //2 , 4-2

            /*
            * idxA: 연속되 A의 마지막 위치
            * strLength - idxA : 총 길이에서 현재 바로 다음에 연속된 A가 지나고 남은 문자 갯수
            * i : 현재까지의 이동 횟수
            * i + i(온만큼 돌아감) + strLength - idxA  : 현재까지 왔다가 다시 돌아가서 남은 거 까지 가는 이동 횟수
            * Math.min(i, strLength - idxA) :
            * strLength - idxA 가 i 보다 큰 경우() 에는 굳이 다시 되돌아갈 필요 없이 [남은 이동해야 하는 횟수] -> (strLength - idxA)만 더해주면 된다.
            * */

        }
        System.out.println("move: " + lrMove);
        answer += lrMove;
        System.out.println("result: " + answer);
        return answer;
    }

    /* 큰 수 만들기 */
    public static String makeBigNumber(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int idx = 0;
        char num;

        /* number.length() - k 자리수 만큼 돌림 */
        for ( int i = 0; i < number.length() - k; i++ ) { // number.length - k 자릿수 만큼 만들어야 함
            num = '0';
            /* 실질적 for 문 */
            for ( int j = idx; j <= k + i; j++ ) {
                if ( num < number.charAt(j) ) {
                    num = number.charAt(j);
                    idx = j + 1;
                }
            }
            answer.append(num);
        }

        return answer.toString();
    }

    /* 구명보트 */
    public static int lifeBoat(int[] people, int limit) {
        System.out.println(Arrays.toString(people));
        int boat = 0; // 보트 갯수
        // 50, 60, 50, 40 아.. 젠장.. 문제좀 똑바로 읽을걸... 2명이었어....

        int j = 0;
        Arrays.sort(people);
        for ( int i = people.length - 1;  j <= i; i-- ) {

            if ( (people[i] + people[j]) > limit ) { // 가장 큰 수 + 가장 작은수 점 점 격차 줄임
                boat++; // i 순번만 태워 보냄
            } else {
                boat++;
                j++;
            }
        }

        System.out.println("boat: " + boat);

        return boat;
    }

}
