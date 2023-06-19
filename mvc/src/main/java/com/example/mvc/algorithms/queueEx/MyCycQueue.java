package com.example.mvc.algorithms.queueEx;

// 원형 Queue
public class MyCycQueue {
    // Member Field
    private final int size = 4; // 원형 Queue 사이즈
    private final int offset = size + 1; // size + 1 을 대입
    private final int[] arr = new int[offset]; // 배열 크기

    // 0 부터 시작함
    private int front = 0;
    private int rear = 0;

    // Constructor
    public MyCycQueue() {}

    // Data Add => enQueue method
    public void enQueue(int x) {
        // 다음에 data 가 들어가는 곳 : (rear + 1) % (size + 1)
        // 다음에 Data 가 나올 곳과 일치 할 경우 : Full
        if ((rear + 1) % offset == front) {
            throw new RuntimeException("Queue is full");
        }
        // rear 에 할당
        rear = (rear + 1) % offset;
        // arr 는 x에게 할당
        arr[rear] = x;
    }

    // Data 회수 => deQueue method
    public int deQueue() {
        // Data 가 비어있는 경우?
        if (front == rear) {
            throw new RuntimeException("Queue is empty");
        }
        // front 에 할당함
        front = (front + 1) % offset;
        // arr 는 front 의 값을 반환해줌
        return arr[front];
    }

    // boolean type 으로 판별[data 가 full 인가 비어있는가]
    public boolean isEmpty() {
        return front == rear;
    }
}
