package com.example.mvc.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// n번째 큰 수
public class BaekJoon2075 {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        // 우선순위 Queue 를 만듬
        // 최소 값이 먼저 나오는 우선순위 Queue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            // 숫자 입력을 지속적으로 받으면서
            StringTokenizer numberToken = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                priorityQueue.offer(Integer.parseInt(numberToken.nextToken()));
                // 우선순위 Queue 의 크기 일정하게 유지함
                if (priorityQueue.size() > n)
                // n 개의 숫자만 남기고 작은 숫자를 우선순위 Queue 에서 빼고 있기 때문에
                // 최종적으로 남는 숫자 N 개는 큰 숫자 N 개
                    priorityQueue.poll();
            }
        }

        return priorityQueue.peek();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new BaekJoon2075().solution());
    }
}
