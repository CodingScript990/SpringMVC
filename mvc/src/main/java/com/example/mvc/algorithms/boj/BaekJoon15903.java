package com.example.mvc.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 카드 합체 놀이
public class BaekJoon15903 {

    public long solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer infoToken = new StringTokenizer(reader.readLine());

        int cardCount = Integer.parseInt(infoToken.nextToken());
        int actions = Integer.parseInt(infoToken.nextToken());

        StringTokenizer cardToken = new StringTokenizer(reader.readLine());
        // 우선순위 Queue 에 넣어줌
        PriorityQueue<Long> smallesCards = new PriorityQueue<>();
        for (int i = 0; i < cardCount; i++) {
            smallesCards.offer(Long.parseLong(cardToken.nextToken()));
        }

        // 두개의 숫자를 뽑아서 합한 뒤, 다시 우선순위 Queue 에 두번 넣어줌
        for (int i = 0; i < actions; i++) {
            long first = smallesCards.poll();
            long second = smallesCards.poll();
            // 두번 넣음
            smallesCards.offer(first + second);
            smallesCards.offer(first + second);
        }
        // 정답을 구함
        long answer = 0;

        while (!smallesCards.isEmpty()) {
            answer += smallesCards.poll();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new BaekJoon15903().solution());
    }
}
