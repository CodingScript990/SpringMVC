package com.example.mvc.algorithms.tree;
// BST => 이진 탐색 트리
public class BinarySearchTree {
    // static class
    private static class Node {
        // member field
        private int key;
        private Node left;
        private Node right;

        // Constructor
        public Node(int key) {
            this.key = key;
            left = null;
            right = null;
        }
    }

    // Node type root reference value add
    private Node root;

    // BinarySearchTree 빈 생성자 add
    public BinarySearchTree() {
        this.root = null;
    }

    // Insert Method add
    public void insert(int key) {
        root = insertNode(root, key);
    }

    // 삽입 메서드에서 재귀호출할 메서드
    public Node insertNode(Node node, int key) {
        // node 가 null 이다 -> 부모 노드의 자식 노드가 null 이었다
        // 삽입한다는 의미
        if (node == null) {
            node = new Node(key);
            return node;
        }

        // 탐색에 성공한 경우 더 확인하지 않을 때
        if (node.key == key) return node;

        // 현재 노드보다 데이터가 작을 경우 왼쪽 트리로 이동
        if (key < node.key) node.left = insertNode(node.left, key); // left 값을 반환(재귀호출)

        // 현재 노드보다 데이터가 클 경우 오른쪽 트리로 이동
        else if (key > node.key) node.right = insertNode(node.right, key); // right 값을 반환(재귀호출)

        // 삽입이 일어나지 않았을 경우, 본래의 자식을 그대로 반환[일관성 유지]
        return node;
    }
    // 탐색 메서드
    public boolean search(int key) {
        return searchNode(root, key);
    }

    // 탐색 재귀함수
    private boolean searchNode(Node node, int key) {
        // 현재 노드가 null 인 경우
        if (node == null) return false;

        // 탐색 성공일 경우
        if (key == node.key) return true;

        // 재귀호출
        // 현재 노드보다 데이터가 더 작을 경우 => 왼쪽 서브트리 탐색 결과 반환
        if (key < node.key) return searchNode(node.left, key);

        // 현재 노드보다 데이터가 더 클 경우 => 오른쪽 서브트리 탐색 결과 반환
        else return searchNode(node.right, key);
    }

    // 중위 순회
    public void inorderTraversal() {
        inorder(root);
    }

    // inorder method
    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // main method
    public static void main(String[] args) {
        // int array
        int[] data = new int[]{50, 30, 70, 20, 40, 60, 80};
        // tree
        BinarySearchTree bst = new BinarySearchTree();

        // for statement
        for (int i = 0; i < data.length; i++) {
            bst.insert(data[i]);
        }

        System.out.println("--- 중위순회 ---");
        bst.inorderTraversal();
        System.out.println();

        System.out.println(bst.search(40));
        System.out.println(bst.search(55));
        System.out.println(bst.search(80));
    }
}
