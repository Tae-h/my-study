package com.taehoon.codingtest.programers.solutions;


import java.util.Arrays;
import java.util.Objects;

/**
 * 해시 문제
 */
public class HashProblems {

    public static void main(String[] args) {

        /*String[] participants = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completions = {"josipa", "filipa", "marina", "nikola"};*/
        String[] participants = {"mislav", "stanko", "mislav", "ana"};
        String[] completions = {"stanko", "ana", "mislav"};

        //System.out.println("answer:: " + completions[3]);

        String remains = notFinishedPlayer(participants, completions);
        System.out.println(remains);
    }

    /*  완주하지 못한선수 */
    public static String notFinishedPlayer(String[] participants, String[] completions) {
        String answer = "";
        Arrays.sort(participants);
        Arrays.sort(completions);
        int i;
        for ( i = 0; i < completions.length; i++ ) {

            if ( !participants[i].equals( completions[i] ) ) {
                answer = participants[i];
                return answer;
            }

        }

        answer = participants[i];
        return answer;
    }



}
