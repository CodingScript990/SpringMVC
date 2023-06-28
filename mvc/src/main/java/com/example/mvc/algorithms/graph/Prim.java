package com.example.mvc.algorithms.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prim {
    public int solution() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer neTokenizer = new StringTokenizer(reader.readLine());

        // 입력받을 정수형
        int nodeCount = Integer.parseInt(neTokenizer.nextToken());
        int edgeCount = Integer.parseInt(neTokenizer.nextToken());
        
        // 가중치가 저장된 인접 행렬 사용
        int[][] adjMatrix = new int[nodeCount][nodeCount];
        // for statement
        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer edgeTokenizer = new StringTokenizer(reader.readLine());

            int start = Integer.parseInt(edgeTokenizer.nextToken()); // 시작
            int end = Integer.parseInt(edgeTokenizer.nextToken()); // 끝
            int weight = Integer.parseInt(edgeTokenizer.nextToken()); // 가중치

            // 정보를 인접행열에 저장
            adjMatrix[start][end] = weight;
            adjMatrix[end][start] = weight;
        }
        // 방문정보 (선택정보)
        boolean[] visited = new boolean[nodeCount];
        // 현재 선택된 정점들에서 해당 정점까지 도달 가능한 가장 짧은 거리
        int[] dist = new int[nodeCount];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 어느 노드에서 다달했는지 정보를 저장
        int[] parent = new int[nodeCount];

        // 1. 임의의 정점 선택
        dist[0] = 0; // 0 만큼 이동
        parent[0] = -1; // 자기자신은 -1
        
        // 모든 정점을 선택할때까지 순회한다
        for (int i = 0; i < nodeCount; i++) {
            int minDist = Integer.MAX_VALUE; // 갔다온 정점의 최단 거리
            int idx = -1;
            // 2-1. 인접한 정점 중 최소 비용 간선으로 연결되는 정점을 찾는다
            for (int j = 0; j < nodeCount; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    // 선택 후보
                    minDist = dist[j];
                    idx = j;
                }
            }
            // 가장 가까운 곳 방문
            visited[idx] = true;
            // 2-2. 정점 정보를 바탕으로 도달 가능 정보를 갱신함
            // idx 로 부터 다른 정점들에 도달할 수 있는지를 확인하고 (adjMatrix) 그 정보를 바탕으로 dist 배열을 업데이트
            for (int j = 0; j < nodeCount; j++) {
                if (!visited[j]  // 1. 방문하지 않았고,
                        && adjMatrix[idx][j] != 0  // 2. 연결되어 있으며,
                        && dist[j] > adjMatrix[idx][j]) // 3. 본래 최단 거리보다 더 짧게 도달 가능할 때
                {
                    // dist, parent 갱신
                    dist[j] = adjMatrix[idx][j];
                    parent[j] = idx;
                }
            }
        }
        // Prim Algorithms 의 총 가중치는 dist 배열에 저장됨
        int totalWeight = 0;
        for (int i = 0; i < nodeCount; i++) {
            totalWeight += dist[i];
        }
        System.out.println(totalWeight);
        // 어떤 순서로 연결되었는지는 parent 에 담김
        System.out.println(Arrays.toString(parent));

        return totalWeight;
    }

    public static void main(String[] args) throws IOException {
        new Prim().solution();
    }
}
/*
// 간선 정보 해독[3]
8 11
0 1 41
0 2 14
0 3 13
1 4 27
2 5 21
3 5 33
3 7 22
4 6 11
4 7 17
5 6 35
6 7 19
 */