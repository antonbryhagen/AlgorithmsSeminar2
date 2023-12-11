package task4;

public class MyLinkedList {
    Node head;
    public void add(int person){

        Node newNode = new Node(person);
        if(this.head == null){
            this.head = newNode;
        }else{
            Node last = this.head;
            while(last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
    }

    public void remove(int index){

        if(index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node temp = this.head;
        Node prev = this.head;
        for(int i = 0; i < index; i++){
            if(temp.next != null){
                prev = temp;
                temp = temp.next;
            }else{
                //error, out of bounds
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
        }
        if(index == 0 && temp.next == null){
            this.head = null;
        }else if(index == 0){
            this.head = temp.next;
        }
        if(temp.next == null && index != 0){
            prev.next = null;
        }else if (temp.next != null && index != 0){
            prev.next = temp.next;
        }
    }

    public Node get(int index){
        if(index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node temp = this.head;
        for(int i = 0; i < index; i++){
            if(temp.next != null){
                temp = temp.next;
            }else{
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
        }
        return temp;
    }

    public void printList(){
        Node temp = head;
        if(temp != null){
            System.out.println("Person: "+temp.person);
            while(temp.next != null){
                temp = temp.next;
                System.out.println("Person: "+temp.person);
            }
        }
    }

}
