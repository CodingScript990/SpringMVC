package com.example.mvc.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    // 최단 거리를 돌려준다
    public int solution(int[][] maze) {
        // BFS 로직을 활용하는데, 다음에 접근할 수 있는 칸을 maze 의 가로, 세로 크기 이내의 인접한 칸을 기준으로 판단함
        // int[]를 담는 Queue, {x, y, 여태까지 이동거리}
        Queue<int[]> visitNext = new LinkedList<>();
        // 미로에서 이미 도달한 적 있는 칸임을 나타내기 위한 visited 이차원 배열
        boolean[][] visited = new boolean[6][6];
        visitNext.offer(new int[]{5, 0, 0});
        // 응답을 담기위한 answer 변수
        int answer = -1;
        // BFS 시작
        // Queue 가 비어있지 않은 동안?
        while (!visitNext.isEmpty()) {
            // 다음에 갈 곳을 Queue 에서 꺼냄
            int[] next = visitNext.poll();
            // 현재 도달한 x = 0
            int nowX = next[0];
            // 현재 도달한 y = 1
            int nowY = next[1];
            // 실제 이동거리
            int steps = next[2];
            // 현재 칸이 3 이라면,
            if (maze[nowX][nowY] == 3) {
                answer = steps;
                break;
            }
            // 방문한 x, y 의 값이 true 이면
            visited[nowX][nowY] = true;

            // 4개의 방향을 확인함
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (
                        // 1. 미로의 범위를 벗어나진 않는지?
                        checkBounds(nextX, nextY) &&
                                // 2. 미로에서 진행 가능한 칸인지?(0 or 3)
                                (maze[nextX][nextY] == 0 || maze[nextX][nextY] == 3) &&
                                // 3. 아직 방문한적 없는지?
                                !visited[nextX][nextY])
                    // Queue 에 방문하는 대상으로 기록
                    visitNext.offer(new int[]{nextX, nextY, steps + 1});
            }
        }
        return answer;
    }

    // 미로의 범위 내에 있는지 검사하는 메서드
    private boolean checkBounds(int x, int y) {
        return -1 < x && x < 6 && -1 < y && y < 6;
    }

    public static void main(String[] args) {
        // 2가 시작점, 3이 목적지
        int answer = new Maze().solution(
                new int[][]{
                        {0, 0, 0, 0, 0, 3},
                        {1, 0, 1, 1, 1, 0},
                        {1, 0, 0, 0, 1, 0},
                        {1, 0, 1, 0, 1, 0},
                        {0, 0, 1, 0, 0, 0},
                        {2, 1, 1, 0, 1, 1}
                }
        );
        // output
        System.out.println(answer);
    }
}
