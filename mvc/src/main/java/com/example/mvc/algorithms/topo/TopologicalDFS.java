package com.example.mvc.algorithms.topo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 위상정렬 => DFS
public class TopologicalDFS {
    private List<List<Integer>> adjList;
    private int nodes;

    public void topologicalSort() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        // 정점 갯수 기록
        nodes = Integer.parseInt(infoToken.nextToken());
        // 간선 갯수 기록
        int edges = Integer.parseInt(infoToken.nextToken());
        adjList = new ArrayList<>();
        // 인접 리스트 초기화
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        // 그래프 입력받기
        for (int i = 0; i < edges; i++) {
            StringTokenizer edgeToken = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(edgeToken.nextToken());
            int end = Integer.parseInt(edgeToken.nextToken());
            adjList.get(start).add(end);
        }

        dfs();
    }

    // nodes : 정점의 갯수, adjList : 인접 리스트
    private void dfs() {
        // 싸이클 감지를 위해 inProcess 추가
        boolean[] visited = new boolean[nodes];
        boolean[] inProcess = new boolean[nodes];
        Stack<Integer> resultReversed = new Stack<>();
        boolean success = true;
        for (int i = 0; i < nodes; i++) {
            if (!visited[i])
                success = dfsRecursive(i, visited, inProcess, resultReversed);
            if (!success) break;
        }
        List<Integer> result = new ArrayList<>();
        if (success)
            while (!resultReversed.empty())
                result.add(resultReversed.pop());

        System.out.println(result);
    }

    private boolean dfsRecursive(
            int next,
            boolean[] visited,
            boolean[] inProcess,
            Stack<Integer> resultReversed
    ) {
        // 일단 방문 정점을 방문 및 처리 중으로 표시
        visited[next] = true;
        inProcess[next] = true;

        for (int neighbor: adjList.get(next)) {
            // 처리 중 (인접 정점이 남은 정점)인 정점을 만나면 이는 싸이클이다.
            if (inProcess[neighbor]) return false;
                // 미방문 정점을 만나면 다음 재귀
            else if (!visited[neighbor])
                // 재귀 중 false 는 싸이클의 존재를 의미
                if(!dfsRecursive(neighbor, visited, inProcess, resultReversed))
                    return false;
        }
        // for의 종료는 모든 인접 정점의 방문을 의미, 기록한다.
        resultReversed.push(next);
        // 처리가 끝났으니 처리 중 배열은 false 로
        inProcess[next] = false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        new TopologicalDFS().topologicalSort();
    }
}
/*
정점, 간선
7 8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
 */

/*
7 9
0 1
0 2
1 3
1 4
2 3
2 6
3 5
4 3
4 5
 */

/*
불가
7 9
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
3 0
 */