package com.example.mvc.algorithms.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 선수과목
public class BaekJoon14567 {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        int lectures = Integer.parseInt(infoToken.nextToken());
        int preReqs = Integer.parseInt(infoToken.nextToken());

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < lectures + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < preReqs; i++) {
            StringTokenizer reqToken = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(reqToken.nextToken());
            int end = Integer.parseInt(reqToken.nextToken());
            adjList.get(start).add(end);
        }
        // 1. 진입 차수 정리
        int[] inDegrees = new int[lectures + 1];
        for (List<Integer> neighbors : adjList) {
            for (int neighbor : neighbors) {
                inDegrees[neighbor]++;
            }
        }

        // 2. 진입 차수에 따른 시작 정점 결정
        //    현재 정점까지 얼마나 걸리는지?
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i < lectures; i++) {
            if (inDegrees[i] == 0) queue.offer(new int[]{i, 1}); // 1학기에 들을 수 있음을 말함
        }

        // 3. Queue 를 가지고 순회, Queue 에 담기는 시점에 방문하고 있던 정점의
        //    소요시간 정보를 같이 담음
        int[] firstSem = new int[lectures + 1];
        while (!queue.isEmpty()) {
            int[] lecture = queue.poll();
            int node = lecture[0]; // 이번학기
            int semester = lecture[1]; // 다음학기

            firstSem[node] = semester; // 첫 시험[이번학기] = 다음학기

            for (int nextLec : adjList.get(node)) {
                inDegrees[nextLec]--;
                if (inDegrees[nextLec] == 0) {
                    queue.offer(new int[]{nextLec, semester + 1});
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < lectures; i++) {
            answer.append(firstSem[i]).append(' ');
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new BaekJoon14567().solution();
    }
}
