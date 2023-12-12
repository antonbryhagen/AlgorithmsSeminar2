package task4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class main{

    public static void main(String[] args) {
        long start;
        long stop;
        long runTime = 0;
        long totalTime;
        int passes = 3;
        String currentAlgo = "";
        for(int j = 0; j < 4; j++){
            //test all 4 methods
            for (int k = 100; k <= 100000; k*=10){
                //test each method with inputs 100, 1000, 10000, 100000 and passes 3
                totalTime = 0; //reset totaltime before testing new input
                for(int i = 0; i < 10; i++){
                    //make 10 measurements and use average time to compare
                    switch(j){
                        case 0:
                            currentAlgo = "ArrayList";
                            start = System.nanoTime();
                            josephusArrayList(k, passes);
                            stop = System.nanoTime();
                            runTime = stop-start;
                            break;
                        case 1:
                            currentAlgo = "ArrayList with Iterator";
                            start = System.nanoTime();
                            josephusArrayListIterator(k, passes);
                            stop = System.nanoTime();
                            runTime = stop-start;
                            break;
                        case 2:
                            currentAlgo = "MyLinkedList";
                            start = System.nanoTime();
                            josephusMyLinkedList(k, passes);
                            stop = System.nanoTime();
                            runTime = stop-start;
                            break;
                        case 3:
                            currentAlgo = "LinkedList with Iterator";
                            start = System.nanoTime();
                            josephusLinkedListIterator(k, passes);
                            stop = System.nanoTime();
                            runTime = stop-start;
                            break;
                    }
                    //add run time to totaltime
                    totalTime+=runTime;
                }
                //calculate average run time from the 10 iterations (totaltime divided by 10)
                System.out.println("Average runtime using "+currentAlgo + " with input "+k+" persons and "+passes+" passes: "+(totalTime/10));
            }
        }
    }

    public static void josephusArrayList(int n, int m){
        ArrayList<Integer> people = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            people.add(i);
        }
        boolean offsetStart = false;
        if (m >= people.size()){
            offsetStart = true;
        }
        for(int i = m; i < people.size() || offsetStart; i+=m){
            if(people.size() == 1){
                break;
            }
            if(offsetStart){
                offsetStart = false;
                while(i >= people.size()){
                    i = i - people.size();
                }
            }
            //System.out.println("REMOVING: "+people.get(i));
            people.remove(i);
            //"remove" all overlaps
            while(i+m >= people.size()){
                i = i - people.size();
            }
        }
        //System.out.println("WINNER: "+people.get(0));
    }

    public static void josephusArrayListIterator(int n, int m){
        ArrayList<Integer> people = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            people.add(i);
        }

        Iterator<Integer> iterator = people.iterator();
        int counter = 0;
        while(iterator.hasNext()){
            iterator.next();
            if(people.size() == 1){
                break;
            }
            if(counter == m){
                counter = 0;
                iterator.remove();
            }else{
                counter++;
            }
            if(!iterator.hasNext()){
                iterator = people.iterator();
            }
        }
        //System.out.println("WINNER: "+people.get(0));

    }

    public static void josephusMyLinkedList(int n, int m){
        MyLinkedList people = new MyLinkedList();
        for(int i = 1; i <= n; i++){
            people.add(i);
        }
        int counter = 0;
        int currentIndex = 0;
        Node currentNode = people.head;
        while (people.head.next != null) {
                if(counter == m){
                    people.remove(currentIndex);
                    counter = 0;
                }else{
                    counter++;
                    currentIndex++;
                }
                if(currentNode.next == null){
                    currentNode = people.head;
                    currentIndex = 0;
                }else{
                    currentNode = currentNode.next;
                }
        }
        //System.out.println("WINNER: "+people.get(0).person);

    }

    public static void josephusLinkedListIterator(int n, int m){
        LinkedList<Integer> people = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            people.add(i);
        }
        Iterator<Integer> iterator = people.iterator();
        int counter = 0;
        while(iterator.hasNext()){
            iterator.next();
            if(people.size() == 1){
                break;
            }
            if(counter == m){
                counter = 0;
                iterator.remove();
            }else{
                counter++;
            }
            if(!iterator.hasNext()){
                iterator = people.iterator();
            }
        }
        //System.out.println("WINNER: "+people.get(0));

    }

}

