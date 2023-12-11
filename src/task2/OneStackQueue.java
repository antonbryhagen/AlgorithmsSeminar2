package task2;

import java.util.NoSuchElementException;
import java.util.Stack;

public class OneStackQueue {
    Stack<Integer> stack;
    public OneStackQueue(){
        stack = new Stack<>();
    }

    public void enqueue(int n){
        try{
            stack.push(n);
        }catch(OutOfMemoryError oome){ //OutOfMemoryError occurs when JVM is out of space and can't expand the stack. One might think it is stackoverflow, but that is for the call stack, not the datastructure
            System.out.println("WARNING: OVERFLOW");
            throw new OutOfMemoryError();
        }

    }

    public int dequeue(){
        if(stack.size() == 1){
            return (stack.pop());
        } else if (stack.isEmpty()) {
            System.out.println("WARNING: UNDERFLOW"); //Exception thrown when attempting to access/dequeue from an empty queue
            throw new NoSuchElementException();
        } else{
            int temp = stack.pop();
            int result = dequeue();
            stack.push(temp);
            return result;
        }
    }

    public int getFirst(){
        if (stack.isEmpty()){
            System.out.println("WARNING: UNDERFLOW"); //Exception thrown when attempting to access/dequeue from an empty queue
            throw new NoSuchElementException();
        }else{
            return stack.firstElement();
        }
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
