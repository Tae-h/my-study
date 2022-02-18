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
        gymSuit(n, lost, reserve);



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

}
