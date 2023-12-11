package task2;

import java.util.NoSuchElementException;
import java.util.Stack;

public class TwoStacksQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public TwoStacksQueue(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int n){
        try{
            stack1.push(n);
        }catch(OutOfMemoryError oome){      //OutOfMemoryError occurs when JVM is out of space and can't expand the stack. One might think it is stackoverflow, but that is for the call stack, not the datastructure
            System.out.println("WARNING: OVERFLOW");
            throw new OutOfMemoryError();
        }

    }

    public int dequeue(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            System.out.println("WARNING: UNDERFLOW");
            throw new NoSuchElementException(); //Exception thrown when attempting to access/dequeue from an empty queue
        }
        if(stack2.isEmpty()){
            while(stack1.size() != 0){
                stack2.push(stack1.pop());
            }
        }
        int firstInQueue = stack2.pop();
        return firstInQueue;
    }

    public int getFirst(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            System.out.println("WARNING: UNDERFLOW");
            throw new NoSuchElementException ();
        }
        if(stack2.isEmpty()){
            while(stack1.size() != 0){
                stack2.push(stack1.pop());
            }
        }
        int firstInQueue = stack2.peek();
        return firstInQueue;
    }

    public boolean isEmpty(){
        return stack1.size() == 0 && stack2.size() == 0;
    }
}
