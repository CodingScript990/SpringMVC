package com.example.mvc.algorithms.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

// Heap
public class BinaryMaxHeapEx2 {
    private int[] heap; // 1차원 배열
    private int size; // 힙의 데이터 갯수

    // Constructor
    public BinaryMaxHeapEx2() {
        heap = new int[32];
        size = 0;
    }

    // arr는 힙이 아니라고 가정
    public BinaryMaxHeapEx2(int[] arr) {
        // TODO
        // 주어진 arr를 힙의 형태로 heap에 저장
        heap = Arrays.copyOf(arr, arr.length);
        size = heap.length;
        // 마지막 자식이 존재하는 노드
        int lastIdx = size - 1;
        // 마지막 자식의 부모
        int lastParentIdx = (lastIdx - 1) / 2;
        // 자식이 존재하는 노드 중에서 가장 나중에 존재하는 노드부터
        // siftDonw을 해주면 된다.
        for (int i = lastParentIdx; i >= 0; i--) {
            siftDown(i);
        }
    }

    // 삽입 연산
    public void insert(int item) {
        heap[size] = item;
        // TODO 비교하며 끌어올리기
        siftUp(size);
        size++;
    }

    // index 에 존재하는 원소를 자신의 부모와 비교해서 힙의 조건을 만족시키도록 교환을 반복적으로 진행
    private void siftUp(int index) {
        while (index > 0) {
            int parentIdx = (index - 1) / 2;

            // 힙의 조건을 만족하는 관계면 반복 중단
            if (heap[index] <= heap[parentIdx]) {
                break;
            }

            // 아니면 교한함
            int temp = heap[index];
            heap[index] = heap[parentIdx];
            heap[parentIdx] = temp;
            index = parentIdx;
        }
    }

    // 삭제 method
    public int remove() {
        // 로트 노드를 제거
        int root = heap[0];
        // 마지막 자식을 할당함
        heap[0] = heap[size - 1];
        size--;
        // TODO 아래로 내리기
        siftDown(0);
        return root;
    }

    // siftDown method
    private void siftDown(int index) {
        while (index < size) {
            int leftChild = 2 * index + 1; // left node
            int rightChild = 2 * index + 2; // right node
            // 최대 원소의 위치 저장용
            int maxIdx = index; // 최대값
            // 왼쪽 자식이 존재하며, 왼쪽 자식 값이 현재 최대 원소 (루트)보다 큰 경우
            if (leftChild < size && heap[leftChild] > heap[maxIdx]) {
                // 둘을 교환할 준비
                maxIdx = leftChild;
            }
            // 오른쪽 자식이 존재하며, 이때 왼쪽이 더 컷으면 maxIdx 가 갱신되었을 것이고,
            // 아니라면 그대로 루트가 있었을 것이며, 한번만 비교해도 둘중 더 큰 것과 비교가 됨
            if (rightChild < size && heap[rightChild] > heap[maxIdx]) {
                // 둘을 교환할 준비
                maxIdx = rightChild;
            }
            // 양쪽 자식과 비교했는데, 최댓값의 위치가 갱신되지 않은 경우 힙의 조건에 부합함
            if (maxIdx == index) break;

            int temp = heap[index];
            heap[index] = heap[maxIdx];
            heap[maxIdx] = temp;
            index = maxIdx; // 반복을 해주기 위한 작업
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        BinaryMaxHeapEx2 maxHeap = new BinaryMaxHeapEx2(
                new int[]{1, 21, 14, 6, 10, 2, 5, 6, 8}
        );

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.remove());
        }
    }
}
