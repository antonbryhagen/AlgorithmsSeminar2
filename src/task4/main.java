package task4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class main{

    public static void main(String[] args) {
        josephusMyLinkedList(5, 1);
    }

    public static void josephusArrayList(int n, int m){
        ArrayList<Integer> people = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            people.add(i);
        }
        int pointer = m; //first to lose
        while(people.size() != 1){
            people.remove(pointer);
            pointer += m;
            if(pointer >= people.size()){
                pointer = pointer - people.size();
            }
        }
        System.out.println("WINNER: "+people.get(0));
    }

    public static void test(int n, int m){
        ArrayList<Integer> people = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            people.add(i);
        }
        for(int i = m; i < people.size(); i+=m){
            if(people.size() == 1){
                break;
            }
            System.out.println("REMOVING: "+people.get(i));
            people.remove(i);
            if(i+m >= people.size()){
                i = i - people.size();
            }
        }
        System.out.println("WINNER: "+people.get(0));
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
        System.out.println("WINNER: "+people.get(0));

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
        System.out.println("WINNER: "+people.get(0).person);

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
        System.out.println("WINNER: "+people.get(0));

    }

}

