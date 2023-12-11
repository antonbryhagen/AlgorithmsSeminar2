package task2;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;


public class OneQueueStack {
    Queue<Integer> queue;
    public OneQueueStack(){
        queue = new LinkedList<>();
    }

    public void push(int n) {

        int currentSize = queue.size();

        try{
            queue.add(n);
        }catch(OutOfMemoryError oome){ //no more memory to create a node for the queue, overflow
            System.out.println("WARNING: OVERFLOW");
            throw new OutOfMemoryError();
        }
        for (int i = 0; i < currentSize; i++){
            queue.add(queue.remove());
        }
    }

    public int pop(){
        if(queue.isEmpty()){
            System.out.println("WARNING: UNDERFLOW");
            throw new EmptyStackException();
        }else{
            return queue.remove();
        }
    }
    public int top(){
        if(queue.isEmpty()){
            System.out.println("WARNING: UNDERFLOW");
            throw new EmptyStackException();
        }else{
            return queue.peek();
        }
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
