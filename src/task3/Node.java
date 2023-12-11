package task3;

public class Node{
    String name;
    String address;
    Node next;

    public Node(String name, String address){
        this.name = name;
        this.address = address;
        next = null;
    }
}