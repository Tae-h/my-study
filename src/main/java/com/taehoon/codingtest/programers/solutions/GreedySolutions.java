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
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        gymSuit(n, lost, reserve);



    }


    /* 체육복 */
    public static int gymSuit (int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> tmpList = new ArrayList<>();
        for ( int i = n; i > 0; i-- ) {
            int num = i;

            if ( ! Arrays.stream(lost).anyMatch(item -> item == num)) {

                tmpList.add(num);

            } else {

                if ( Arrays.stream(reserve).anyMatch(item -> {
                    if (item == num + 1 || item == num - 1 ) {
                        for ( int j = 0; j < reserve.length; j++ ) {
                            if ( item == reserve[j] ) {
                                reserve[j] = 0;
                                break;
                            }
                        }
                        return true;
                    }
                    return false;
                }) ) {
                    tmpList.add(num);
                }
            }

        }
        answer = tmpList.size();
        return answer;
    }

}
