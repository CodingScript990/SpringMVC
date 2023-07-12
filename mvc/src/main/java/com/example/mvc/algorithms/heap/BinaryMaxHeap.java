package com.example.mvc.algorithms.heap;

import java.util.Collections;
import java.util.PriorityQueue;

// Heap
public class BinaryMaxHeap {
    private int[] heap; // 1차원 배열
    private int size; // 힙의 데이터 갯수

    // Constructor
    public BinaryMaxHeap() {
        heap = new int[32];
        size = 0;
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

    public static void main(String[] args) {
        BinaryMaxHeap maxHeap = new BinaryMaxHeap();

        for (int i = 0; i < 32; i++) {
            maxHeap.insert(i);
        }
        for (int i = 0; i < 32; i++) {
            System.out.println(maxHeap.remove());
        }

        int[] arr = new int[]{3, 4, 0, 5, 1, 2, 8, 6, 9};

        System.out.println("priority queue");
        // min heap을 사용하는것과 비슷한 PriorityQueue
        PriorityQueue<Integer> priorityQueueMin = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueueMin.offer(arr[i]);
        }
        while (!priorityQueueMin.isEmpty()) {
            System.out.println(priorityQueueMin.poll());
        }

        System.out.println("priority queue reverse");
        // max heap은 Collections.reverseOrder()를 사용할 수 있다.
        PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            priorityQueueMax.offer(arr[i]);
        }
        while (!priorityQueueMax.isEmpty()) {
            System.out.println(priorityQueueMax.poll());
        }
    }
}
