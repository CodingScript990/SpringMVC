package com.example.mvc.algorithms.queueEx;

// 원형 Queue
class MyCycQueueTest {
    public static void main(String[] args) {

        // 인스턴스화
        MyCycQueue queue = new MyCycQueue();

        // 1,2,3,4 의 값을 넣어줌
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        // output => 1 이 출력됨
        System.out.println("원형 Queue1 : " + queue.deQueue());

        // 5의 값을 넣어줌
        queue.enQueue(5);

        // output => 2,3 이 출력됨
        System.out.println("원형 Queue2 : " + queue.deQueue());
        System.out.println("원형 Queue3 : " + queue.deQueue());

        // 6,7 값을 넣어줌
        queue.enQueue(6);
        queue.enQueue(7);

        // output => 4,5,6 이 출력됨
        System.out.println("원형 Queue4 : " + queue.deQueue());
        System.out.println("원형 Queue5 : " + queue.deQueue());
        System.out.println("원형 Queue6 : " + queue.deQueue());

        // 8의 값을 넣어줘도 선형 Queue 와 다른게 Error 가 나지 않음을 볼 수 있음
        queue.enQueue(8);
    }
}