package com.taehoon.codingtest.programers.solutions;

import java.util.ArrayList;
import java.util.List;

public class StackQueSolutions {

    public static void main(String[] args) {

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        developmentFunc(progresses, speeds);



    }



    /* 기능 개발  solution */
    public static int[] developmentFunc(int[] progresses, int[] speeds) {

        List<Integer> tempArray = new ArrayList<>();

        for ( int i = 0; i < progresses.length; i++ ) {
            int progress = progresses[i];
            int speed = speeds[i];

            progress += speed;
            int increaseCount = 1;
            while (progress < 100) {
                progress += speed;
                increaseCount++;
            }
            tempArray.add(increaseCount);
        }

        List<Integer> deployedList = new ArrayList<>();
        int deployCount;
        for ( int j = 0; j < tempArray.size(); j += deployCount ) {
            deployCount = 0;
            Integer workDay = tempArray.get(j);

            for ( int i = j; i < tempArray.size(); i++) {
                Integer nextTemp = tempArray.get(i);

                if (workDay.compareTo(nextTemp) < 0) {
                    break;
                }

                deployCount++;

            }
            deployedList.add(deployCount);
        }

        int [] answer = new int[deployedList.size()];
        for (int c = 0; c < deployedList.size(); c++ ) {
            answer[c] = deployedList.get(c);
        }

        return answer;
    }


}
