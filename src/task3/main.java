package task3;

public class main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("ANTON", "STREET 1");
        linkedList.add("JOHN", "ROAD 5");
        linkedList.printList();
        System.out.println("------");
        Node n1 = linkedList.get(0);
        System.out.println("0: "+n1.name);

        Node n2 = linkedList.get(1);
        System.out.println("1: "+n2.name);

        linkedList.remove(0);
        System.out.println("------");
        linkedList.printList();
        System.out.println("------");

        n1 = linkedList.get(0);
        System.out.println("0: "+n1.name);

    }
}