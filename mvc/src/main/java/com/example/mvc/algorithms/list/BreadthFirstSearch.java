package com.example.mvc.algorithms.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public void solution() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maxNodes = Integer.parseInt(reader.readLine());
        // 인접 정보 저장용
        int[][] adjMap = new int[maxNodes + 1][maxNodes + 1];
        // 간접 정보
        String[] edges = reader.readLine().split(" ");
        // for statement
        for (int i = 0; i < edges.length / 2; i++) {
            // 양방향 간선 표현하기 위함
            int leftNode = Integer.parseInt(edges[i * 2]);  // 0, 2, 4, ...
            int rightNode = Integer.parseInt(edges[i * 2 + 1]); // 1, 3, 5, ...

            adjMap[leftNode][rightNode] = 1;
            adjMap[rightNode][leftNode] = 1;
        }
        // BFS
        // 다음 방문 대상 기록용 Queue
        Queue<Integer> toVisit = new LinkedList<>();
        List<Integer> visitedOrder = new LinkedList<>();
        // 방문 기록용 boolean[]
        boolean[] visited = new boolean[maxNodes + 1];

        int next = 1; // next value 를 1로 초기화
        toVisit.offer(next);

        // Queue 가 비어있지 않은 동안 반복함
        while (!toVisit.isEmpty()) {
            // 다음 방문 정점 회수
            next = toVisit.poll();
            // 이미 방문 했다면 다음 반복으로 시도
            if (visited[next]) continue;

            // 방문됐다를 표시함
            visited[next] = true;
            // 방문한 순서를 기준으로 기록
            visitedOrder.add(next);

            // 다음 방문 대상을 검색함
            for (int i = 0; i < maxNodes + 1; i++) {
                // adjMap[next]가 담고 있는 배열은 idx 번째가 1인 경우 idx 에 연결되어있다는 의미임[방문하지 않은 것도 추가]
                if (adjMap[next][i] == 1 && !visited[i]) toVisit.offer(i);
            }
        }
        // 출력함
        System.out.println(visitedOrder);
    }

    // main method
    public static void main(String[] args) throws IOException {
        new BreadthFirstSearch().solution();
    }
}
/*
    입력 예제 :
    7
    1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7
*/
