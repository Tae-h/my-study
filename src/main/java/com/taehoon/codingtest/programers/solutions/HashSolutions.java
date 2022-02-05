package com.taehoon.codingtest.programers.solutions;


import java.util.Arrays;

/**
 * 해시 문제
 */
public class HashSolutions {

    public static void main(String[] args) {

        /*String[] participants = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completions = {"josipa", "filipa", "marina", "nikola"};*/
        String[] participants = {"mislav", "stanko", "mislav", "ana"};
        String[] completions = {"stanko", "ana", "mislav"};

        //System.out.println("answer:: " + completions[3]);

        String remains = notFinishedPlayer(participants, completions);
        System.out.println(remains);

        /* 전화번호 목록 예시
            ["119", "97674223", "1195524421"]	false
            ["123","456","789"]	true
            ["12","123","1235","567","88"]	false
         */
        //String[] phoneBook = {"119", "97674223", "1195524421"};
        //String[] phoneBook = {"123","456","789"};
        String[] phoneBook = {"12","123","1235","567","88"};
        phoneNumberList(phoneBook);




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

    /* 전화번호 목록 */
    public static boolean phoneNumberList(String[] phone_book) {
        boolean answer = true;

        String phoneNum = null;
        Arrays.sort(phone_book);
        for ( int i = 0; i < phone_book.length - 1; i ++ ) {

            phoneNum = phone_book[i];
            if ( phone_book[ i + 1 ].startsWith(phoneNum) ) {
                answer = false;
                break;
            }

        }

        return answer;
    }



}
