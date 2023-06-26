package com.example.mvc.algorithms.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
// DFS
public class RecursiveDFS {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer : 입력받은 문자열을 ' ' (또는 지정된 delimiter)를 기준으로 나눠서 한 단어씩 반환해주는 도구임
        StringTokenizer graphTokenizer = new StringTokenizer(reader.readLine()); // 8 10
        // StringTokenizer.nextToken : 다음 단어를 가져오기
        int maxNodes = Integer.parseInt(graphTokenizer.nextToken()); // 8
        int edges = Integer.parseInt(graphTokenizer.nextToken());    // 10

        // 인접행렬 표현 => 2차원 배열
        // 만약 노드가 1부터 N + 1 까지라면, 계산할때 매번 -1을 해주거나 인접 행렬을 한번 더 늘리거나
        int[][] adjMatrix = new int[maxNodes][maxNodes]; // 0 - 7까지 표현가능한 인접 행렬
        // for statement => edges length[간선의 갯수만큼 반복해서 입력을 받는 작업]
        for (int i = 0; i < edges; i++) {
            // 다음줄을 단어 단위로 나눠주는 Tokenizer 임
            StringTokenizer edgeTokenizer = new StringTokenizer(reader.readLine());
            // 입력 줄의 첫 번째 숫자
            int startNode = Integer.parseInt(edgeTokenizer.nextToken());
            // 입력 줄의 두번째 숫자
            int endNode = Integer.parseInt(edgeTokenizer.nextToken());
            // 유향 그래프의 경우 아래줄만[34번째]
            adjMatrix[startNode][endNode] = 1;
            // 무향 그래프의 경우 아래줄도 함께
            adjMatrix[endNode][startNode] = 1;
        }

        boolean[] visited = new boolean[maxNodes];
        List<Integer> visitedOrder = new ArrayList<>();

        recursive(0, maxNodes, adjMatrix, visited, visitedOrder);

        System.out.println(visitedOrder);
    }

    // 재귀호출 => DFS 를 했을 때 정점 방문 순서 기록
    public void recursive(
            // 다음 (이빈 호출)에서 방문할 곳
            int next,
            // 원활한 순회를 위한 maxNodes
            int maxNodes,
            // 인접 정점 정보(그래프 정보)
            int[][] adjMatrix,
            // 여태까지 방문한 정점 정보
            boolean[] visited,
            // 구하고자 하는 목적에 따라 다름 => 방문 순서 기록을 위한 리스트
            List<Integer> visitOrder
    ) {
        visited[next] = true;
        visitOrder.add(next);
        // 반복문에서 재귀호출 한다.
        for (int i = 0; i < maxNodes; i++) {
            // 연결이 되어있으며, 방문한적 없을 때
            if (adjMatrix[next][i] == 1 && !visited[i]) recursive(i, maxNodes, adjMatrix, visited, visitOrder);
        }
    }

    // main method
    public static void main(String[] args) throws IOException {
        new RecursiveDFS().solution();
    }
}
/*
8 10
0 1
0 2
0 3
1 3
1 4
2 5
3 4
4 7
5 6
6 7
// 10개의 줄에 걸쳐서 간신의 연결한 정점들 (간선 정보)
 */
