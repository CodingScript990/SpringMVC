package com.example.mvc.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ProgrammersDFSToBFS {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // 방문했는지를 파악하는 작업 
        boolean[] visited = new boolean[n];
        // 모든 컴퓨터(정점)을 순회함
        for (int i = 0; i < n; i++) {
            // 이 컴퓨터가 속한 네트워크를 확인한적 없다면?
            // 이 컴퓨터를 방문한적 없다고 나온다면?
            if (!visited[i]) {
                // DFS 또는 BFS
                // 아직 방문하지 않은 i 부터 탐색
                network(i, n, computers, visited);
                answer++; // 네트워크 하나 완성
            }
        }
        return answer;
    }

    // network method
    public void network(
            int computer, // 몇번 컴퓨터부터 확인 예정인지?
            int n, // 컴퓨터의 갯수
            int[][] computers, // 컴퓨터 연결 정보
            boolean[] visited)  // 컴퓨터 방문 정보
    {
        Queue<Integer> toVisit = new LinkedList<>();
        toVisit.offer(computer);
        // while statement
        while (!toVisit.isEmpty()) {
            int next = toVisit.poll();
            // for statement
            for (int i = 0; i < n; i++) {
                // computers[next][i] == i : 연결되어 있음
                // !visited[i] : 방문한적 없음
                if (computers[next][i] == 1 && !visited[i]) {
                    toVisit.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int answer = new ProgrammersDFSToBFS().solution(3, new int[][] {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        });
        System.out.println(answer);
    }
}
