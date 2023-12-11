package task2;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class TwoQueuesStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public TwoQueuesStack(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int n){
        try{
            queue1.add(n);
        }catch(OutOfMemoryError oome){ //no more memory to create a node for the queue, overflow
            System.out.println("WARNING: OVERFLOW");
            throw new OutOfMemoryError();
        }

    }

    public int pop(){
        if(queue1.isEmpty()){
            System.out.println("WARNING: UNDERFLOW");
            throw new EmptyStackException();    //Exeption thrown when attempting to access/pop from empty stack
        }else{
            while(queue1.size() != 1){
                queue2.add(queue1.remove());
            }
            int poppedElement = queue1.remove();
            Queue<Integer> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
            return poppedElement;
        }
    }

    public int top(){
        if(queue1.isEmpty()){
            System.out.println("WARNING: UNDERFLOW");
            throw new EmptyStackException();    //Exeption thrown when attempting to access/pop from empty stack
        }else{
            while(queue1.size() != 1){
                queue2.add(queue1.remove());
            }
            int topOfStack = queue1.remove();
            queue2.add(topOfStack);
            Queue<Integer> tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
            return topOfStack;
        }
    }

    public boolean isEmpty(){
        return queue1.isEmpty();
    }
}
