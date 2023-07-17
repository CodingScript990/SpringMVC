package com.example.mvc.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// 국회의원 선거
public class BaekJoon1417 {

    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 입력부
        int candidates = Integer.parseInt(reader.readLine());
        // 첫줄이 내 득표수
        int myVote = Integer.parseInt(reader.readLine());
        // 제일 많은 득표자의 표를 먼저 뺐어야 함(Max 우선순위)
        PriorityQueue<Integer> otherVote = new PriorityQueue<>(Collections.reverseOrder());
//        PriorityQueue<Integer> otherVote = new PriorityQueue<>((th, ot) -> th - ot);
        // 다솜이 빼고 나머지 표
        for (int i = 0; i < candidates - 1; i++) {
            otherVote.offer(Integer.parseInt(reader.readLine()));
        }

        // 알고리즘
        int answer = 0;
        // 단일 후보가 아닌 경우에만 계산을 진행함
        if (!otherVote.isEmpty())
            // 나머지 후보들 득표중 최댓값이 나보다 작아질 때 까지
            while (otherVote.peek() >= myVote) {
                // 최대 득표자의 득표 수
                int votes = otherVote.poll();
                // 그 사람의 지지자를 한명 매수함
                otherVote.offer(votes - 1);
                // 뺐은 표는 내 것으로
                myVote++;
                // 매수 진행 횟수
                answer++;
            }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new BaekJoon1417().solution());
    }
}
