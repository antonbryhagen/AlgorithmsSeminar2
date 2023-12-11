package task2;

import java.util.EmptyStackException;

public class main {
    public static void main(String[] args) {

        /***********TASK 2a**************/
        System.out.println("TESTING QUEUE USING TWO STACKS");
        TwoStacksQueue twoStackQueue = new TwoStacksQueue();
        twoStackQueue.enqueue(1);
        twoStackQueue.enqueue(2);
        twoStackQueue.enqueue(3);
        System.out.println("First: "+twoStackQueue.getFirst());
        System.out.println(twoStackQueue.isEmpty());
        System.out.println(twoStackQueue.dequeue());
        System.out.println(twoStackQueue.dequeue());
        twoStackQueue.enqueue(4);
        System.out.println(twoStackQueue.dequeue());
        twoStackQueue.enqueue(5);
        System.out.println(twoStackQueue.dequeue());
        System.out.println(twoStackQueue.dequeue());

        System.out.println(twoStackQueue.isEmpty());

        /***********TASK 2b**************/
        System.out.println("TESTING QUEUE USING ONE STACK");
        OneStackQueue oneStackQueue = new OneStackQueue();
        oneStackQueue.enqueue(1);
        oneStackQueue.enqueue(2);
        oneStackQueue.enqueue(3);
        System.out.println("First: "+oneStackQueue.getFirst());
        System.out.println(oneStackQueue.isEmpty());
        System.out.println(oneStackQueue.dequeue());
        System.out.println(oneStackQueue.dequeue());
        oneStackQueue.enqueue(4);
        System.out.println(oneStackQueue.dequeue());
        oneStackQueue.enqueue(5);
        System.out.println(oneStackQueue.dequeue());
        System.out.println(oneStackQueue.dequeue());
        System.out.println(oneStackQueue.isEmpty());

        /***********TASK 2c**************/
        System.out.println("TESTING STACK USING TWO QUEUES");
        TwoQueuesStack twoQueuesStack = new TwoQueuesStack();
        twoQueuesStack.push(1);
        twoQueuesStack.push(2);
        twoQueuesStack.push(3);
        System.out.println("Top: "+twoQueuesStack.top());
        System.out.println(twoQueuesStack.isEmpty());
        System.out.println(twoQueuesStack.pop());
        System.out.println(twoQueuesStack.pop());
        twoQueuesStack.push(4);
        System.out.println(twoQueuesStack.pop());
        twoQueuesStack.push(5);
        System.out.println(twoQueuesStack.pop());
        System.out.println(twoQueuesStack.pop());
        System.out.println(twoQueuesStack.isEmpty());

        /***********TASK 2d**************/
        System.out.println("TESTING STACK USING ONE QUEUE");
        OneQueueStack oneQueueStack = new OneQueueStack();
        oneQueueStack.push(1);
        oneQueueStack.push(2);
        oneQueueStack.push(3);
        System.out.println("Top: "+oneQueueStack.top());
        System.out.println(oneQueueStack.isEmpty());
        System.out.println(oneQueueStack.pop());
        System.out.println(oneQueueStack.pop());
        oneQueueStack.push(4);
        System.out.println(oneQueueStack.pop());
        oneQueueStack.push(5);
        System.out.println(oneQueueStack.pop());
        System.out.println(oneQueueStack.pop());
        System.out.println(oneQueueStack.isEmpty());

    }
}
