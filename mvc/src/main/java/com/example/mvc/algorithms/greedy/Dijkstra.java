package com.example.mvc.algorithms.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 냅색 알고리즘
public class Dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int nodes = Integer.parseInt(tokenizer.nextToken());
        int edges = Integer.parseInt(tokenizer.nextToken());
        int start = Integer.parseInt(reader.readLine());

        // 인접행렬, 연결되어 있을 경우 함수, 없을 경우 음수(-1)
        int[][] adjMatrix = new int[nodes][nodes];
        for (int[] row : adjMatrix) {
            Arrays.fill(row, -1);
        }

        // 인접행렬 초기화
        for (int i = 0; i < edges; i++) {
            StringTokenizer edgTokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(edgTokenizer.nextToken());
            int to = Integer.parseInt(edgTokenizer.nextToken());
            int cost = Integer.parseInt(edgTokenizer.nextToken());

            adjMatrix[from][to] = cost;
        }

        // 방문정보 visited
        boolean[] visited = new boolean[nodes];
        // 현재까지의 최소 거리 정보 List
        int[] dist = new int[nodes]; // 준비단계
        // 1. 모든 정점까지 아직 도달할 길이 없으므로, 무한대 (또는 최대)로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 2. 시작 정점까지의 거리는 0
        dist[start] = 0;
        
        // dist 시작
        // 반복 기준 : 아직 방문한 점이 남아있을때?
        // => 노드의 갯수만큼 반복
        for (int i = 0; i < nodes; i++) {
            // 이번에 방문할 정점을 선택
            // => 현재 정점들 까지의 최단경로 정보 중 가장 가까운 정렬
            // [최소값 비교용 찾기]
            int minDist = Integer.MAX_VALUE;
            // 최소 거리 노드 index 저장용 변수
            int minDistNode = -1;
            // dist 배열을 검사해서 미방문 최단거리 정점을 조사함
            for (int j = 0; j < nodes; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minDistNode = j;
                }
            }
            // 더이상 도달 가능한 미방문 노드가 없다는 의미
            if (minDistNode == -1) break;
            // 최종 선택된 노드를 방문처리함
            visited[minDistNode] = true;

            for (int j = 0; j < nodes; j++) {
                // 연결되어 있지 않은 경우 (-1)
                if (adjMatrix[minDistNode][j] == -1) continue;
                int cost = adjMatrix[minDistNode][j];
                // 인접노드가 현재 가지는 최소비용 (dist[j])
                // 현재 방문한 노드까지의 최소비용 + 현재노드에서 인접 노드까지 가는 최소비용
                // 좀 더 작은값을 dist[j]에 저장함
                if (dist[j] > dist[minDistNode] + cost) dist[j] = dist[minDistNode] + cost;
            }
        }
        // 최종 출력
        System.out.println(Arrays.toString(dist));
    }
}

/*
6 8
0
0 1 10
0 2 15
1 3 12
1 5 15
2 4 10
3 4 2
3 5 1
5 4 5
 */

/*
5 6
0
4 0 1
0 1 2
0 2 3
1 2 4
1 3 5
2 3 6
*/

/*
5 6
4
4 0 1
0 1 2
0 2 3
1 2 4
1 3 5
2 3 6
*/