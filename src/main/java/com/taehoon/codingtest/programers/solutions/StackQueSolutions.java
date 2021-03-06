package com.taehoon.codingtest.programers.solutions;

import java.util.*;

public class StackQueSolutions {

    public static void main(String[] args) {

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        //developmentFunc(progresses, speeds);

        //int[] priorities = {2, 1, 3, 2};
        //int location = 2; // return 1
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0; //return
        //printerSolution(priorities, location);


        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeights = {7,4,5,6};

        //bridgeTruck(bridgeLength, weight, truckWeights);


        int[] prices = {1, 2, 3, 2, 3}; // return [4, 3, 1, 1, 0]
        stockPrice(prices);



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

    public static int printerSolution(int[] priorities, int location) {
        int answer = 0;

        /* 우선순위 역순위 큐 */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for ( int item : priorities ) {
            pq.offer(item);
        }

        // 기존 배열의 index [location] 위치에 있는 숫자가 출력 되는 순서
        while ( !pq.isEmpty() ) {
            //pq.poll() 맨 앞의 데이터 한개씩 뺌
            System.out.println(pq);
            for ( int i = 0; i < priorities.length; i++ ) {
                System.out.println(priorities[i] + ", " + pq.peek() );
                if ( priorities[i] == pq.peek() ) {
                    answer++;
                    pq.poll(); // 공통 부분 제거
                    if ( location == i ) {
                        System.out.println(answer);
                        return answer;
                    }
                }

            }

        }

        return answer;
    }

    /* 다리를 지나는 트럭 */
    public static int bridgeTruck(int bridgeLength, int weight, int[] truck_weights) {

        Queue<Integer> bridge = new LinkedList<>();

        int time = 0; // 걸리는 시간
        int totalWeight = 0; // 다리위의 토탈 무게

        for ( int truck : truck_weights ) {

            // 다리를 건널때 까지 while
            while (true) {

                if ( bridge.isEmpty() ) {
                    bridge.add(truck);
                    totalWeight += truck;
                    time++;
                    break;
                } else if ( bridge.size() == bridgeLength ) { // 다리 길이랑 다리위의 개수랑 같으면 -->
                    totalWeight -= bridge.poll();
                } else {

                    if ( totalWeight + truck <= weight ) {
                        bridge.add(truck);
                        totalWeight += truck;
                        time++;
                        break;
                    } else {
                        bridge.add(0); // 다 건널수 있게 0으로 채워줌
                        time++;
                    }
                }
            }

        }


        return time + bridgeLength;
    }


    public static int[] stockPrice(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Integer> queue = new LinkedList<>();
        for ( int price : prices ) {
            queue.offer(price);
        }
        System.out.println(queue);
        int index = 0;
        while ( !queue.isEmpty() ) {
            int price = queue.poll();
            int second = 0;
            System.out.println(price+ ", " + queue.toString());
            for ( int q : queue ) {
                if ( q >= price ) {
                    second++;
                } else {
                    second++;
                    break;
                }
            }
            answer[index] = second;
            index++;
        }


        System.out.println(Arrays.toString(answer));
        return answer;
    }






















}
