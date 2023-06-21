package com.example.mvc.algorithms.tree;
// tree
public class TreeTraverse  {
    // Member Field
    private int nodes; // 노드 값
    private int[] arr; // 이진 트리를 표현하기 위한 배열

    // setArr method => arr
    // {0,1,2,3,4,5,6,7,8,9,10,11}
    public void setArr(int[] arr) {
        this.arr = arr;
        this.nodes = arr.length;
    }

    // 전위 순회 V[본인] -> L[왼쪽 자식] -> R[오른쪽 자식]
    // preorder(): preorder(V) -> preorder(L) -> preorder(R)
    public void traversePreorder(int node) { // 재귀함수
        if (node < this.nodes && arr[node] != 0) {
            System.out.print(arr[node] + ", "); // 방문
            this.traversePreorder(node * 2); // 왼쪽 자식(i * 2)을 루트로 다시 preorder 호출
            this.traversePreorder(node * 2 + 1); // 오른쪽 자식(i * 2 + 1)을 루트로 다시 preorder 호출
        }
    }

    // 중위 순회 V[본인] -> L[왼쪽 자식] -> R[오른쪽 자식]
    // inorder(): preorder(L) -> System.out.print(V) -> preorder(R)
    public void traverseInorder(int node) { // 재귀함수
        if (node < this.nodes && arr[node] != 0) {
            this.traverseInorder(node * 2); // 왼쪽 자식(i * 2)을 루트로 다시 preorder 호출
            System.out.print(arr[node] + ", "); // 방문
            this.traverseInorder(node * 2 + 1); // 오른쪽 자식(i * 2 + 1)을 루트로 다시 preorder 호출
        }
    }

    // 후위 순회  L[왼쪽 자식] -> R[오른쪽 자식] -> V[본인]
    // postorder(): preorder(L) -> preorder(R) -> System.out.print(V)
    public void traversePostorder(int node) { // 재귀함수
        if (node < this.nodes && arr[node] != 0) {
            this.traversePostorder(node * 2); // 왼쪽 자식(i * 2)을 루트로 다시 preorder 호출
            this.traversePostorder(node * 2 + 1); // 오른쪽 자식(i * 2 + 1)을 루트로 다시 preorder 호출
            System.out.print(arr[node] + ", "); // 방문
        }
    }

    // main method
    public static void main(String[] args) {
        TreeTraverse tree = new TreeTraverse();
        tree.setArr(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});

        // 처음 방문점은 root node
        tree.traversePreorder(1);
        System.out.println("[전위 순회] ");

        // 중위 순회
        tree.traverseInorder(1);
        System.out.println("[중위 순회]");

        // 후위 순회
        tree.traversePostorder(1);
        System.out.println("[후위 순회]");
    }
}
