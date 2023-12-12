package task3;

public class LinkedList {
    Node head;
    public void add(String name, String address){
        Node newNode = new Node(name, address);
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
                temp = temp.next;   //will point to element to be removed, if it would point at null, it wouldn't exist
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
        //remove last element, set prev node point to null
        if(temp.next == null && index != 0){
            prev.next = null;
        }else if (temp.next != null && index != 0){ //set previous to point to node after the one to be removed
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
            System.out.println("Name: "+temp.name+", Address: "+temp.address);
            while(temp.next != null){
                temp = temp.next;
                System.out.println("Name: "+temp.name+", Address: "+temp.address);
            }
        }
    }

}
