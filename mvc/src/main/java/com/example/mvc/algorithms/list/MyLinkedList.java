package com.example.mvc.algorithms.list;

public class MyLinkedList {
    // Member Field
    private Node start;

    // Node => 정적 멤버 클래스
    private static class Node {
        // Member Field
        private int data; // 값을 받아오는 Field
        private Node link; // 자신을 기준으로 그 다음 무엇이 들어올지를 작업해주기 위한 것

        // Constructor => data 만 받아오는 생성자
        public Node(int data) {
            this.data = data;
        }

        // Constructor => data, link 둘다 받아오는 생성자
        public Node(int data, Node link) {
            this.data = data;
            this.link = link;
        }
    }

    // add method => 제일 뒤에 data 추가하는 작업
    public void add(int data) {
        // 1. start == null (LinkedList 가 비어있음을 말함)
        if (start == null) start = new Node(data);

        // 2. 아니라면, link 가 null 인 노드가 나올때까지
        else {
            // Node type head 변수는 start 의 값을 대입함
            Node head = start;
            // head 에 link 가 null 이 아닌 경우
            while (head.link != null) {
                head = head.link; // head 에게 head.link 값을 대입함
            }
            // while statement 가 끝났을 때, head.link == null 이다(마지막 노드이다)
            head.link = new Node(data);
        }
    }
    // remove : idx 번째 data 를 회수 및 node 제거를 말함
    // remove method
    public int remove(int idx) {
        // 0 이 아닐 때 경우
        if (idx == 0) {
            // int type val 변수 는 start.data 의 값을 대입함
            int val = start.data;
            // start 는 start.link 의 값을 대입함
            start = start.link;
            // val 의 값을 반환함
            return val;
        }
        else {
            // int type i 변수는 0을 대입함
            int i = 0;
            // Node type head 변수는 start 의 값을 대입함
            Node head = start;
            // Node type prev 변수는 start 의 값을 대입함
            Node prev = start;

            // while statement
            while (i < idx) {
                // prev 에게 head 값을 대입함
                prev = head;
                // head 에게 head.link 값을 대입함
                head = head.link;
                i++; // 증감식
            }
            // head 의 값에서 빠진 부분을 prev 에게 값을 넣어준다는 의미
            prev.link = head.link;
            // head 의 data 값을 반환함
            return head.data;
        }
    }

    // toString method
    @Override
    public String toString() {
        // StringBuilder instance
        StringBuilder builder = new StringBuilder("[");
        // Node type head 변수는 start 의 값을 대입함
        Node head = start;
        // while statement => head 값이 null 이 아니라면?
        while (head != null) {
            // builder 는 head 의 data 값을 추가
            builder.append(head.data);
            // if statement => link 가 null 이 아니라는건 뒤에 원소가 더 있다는 의미
            if (head.link != null) {
                // 원소가 있다면 , 기호를 추가해준다는 의미
                builder.append(", ");
            }
            // head 에게 head.link 값을 대입함
            head = head.link;
        }
        // builder 에서 닫는 기호를 추가 하여 마무리 짓겠다는 의미를 표현
        builder.append("]");
        // builder 의 toString 메서드를 반환함
        return builder.toString();
    }

    // main method
    public static void main(String[] args) {
        // MyLinkedList instance
        MyLinkedList linkedList = new MyLinkedList();

        // linkedList add value
        linkedList.add(1); // [1]
        linkedList.add(2); // [1,2]
        linkedList.add(3); // [1,2,3]

        // output => [1,2,3]
        System.out.println("linkedList: " + linkedList);

        System.out.println("linkedList remove[0]: " + linkedList.remove(0)); // 결과: 1
        System.out.println("linkedList remove[1]: " + linkedList.remove(1)); // 결과: 3
        System.out.println("linkedList remove[0]: " + linkedList.remove(0)); // 결과: 2

    }
}
