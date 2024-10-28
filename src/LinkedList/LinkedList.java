package LinkedList;

import java.util.Optional;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /*Operations of a Singly Linked List
        Insertion: 1. At the beginning (Prepend) 2. At the end (Append()) 3.At a specific position(insert())
        Deletion: 1. By value 2.By position
        Traversal: -Print the list
        Searching: - By value
        Updating: - Modify a node's value at a specific position
        Reversal: - Reverse the linked list*/

    public void prepend(int data){
        Node node = new Node(data);
        if(length == 0){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head = node;
        }
        length ++;
    }
    public void append(int data){
        Node node = new Node(data);
        if(length == 0){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
        length ++;
    }

    public boolean insert(int index, int data){
        if(index < 0 || index > length)
            return false;
        if(index == 0) {prepend(data); return true;}
        if(index == length){append(data); return  true;}
        Optional<Node> previousNodeOpt = get(index -1);

        if(previousNodeOpt.isPresent()){
            Node node = new Node(data);
            Node prevNode = previousNodeOpt.get();
            Node temp = prevNode.next;
            prevNode.next = node;
            node.next = temp;
            length ++;
            return  true;
        }
        return false;
    }

    /**Deletes the node with a given value.
     *
     * @param value The value to be deleted from the linked list.
     * @return The deleted node if found, or null if the value is not found.
     */
    public Optional<Node> deleteByValue(int value){

        if(head == null)
            return Optional.empty();

        // Handle deletion of head node
        if(head.data == value){
            Node deletedNode = head;
            head = head.next; // update head to the next node
            length -- ;
            return Optional.of(deletedNode);
        }

        Node current = head.next;
        Node previous = head;

        while (current != null ){
            if(current.data == value){
                previous.next = current.next;
                length --;
                return Optional.of(current);
            }
            previous = current;
            current = current.next;
        }
        return Optional.empty();
    }

    public Optional<Node> deleteByPosition(int index){

        if(index < 0 || index >= length )
            return Optional.empty();

        //Deleting first element
        if(index == 0){
            Node deletedNode = head;
            head = head.next;
            length--;
            return Optional.of(deletedNode);
        }
        Node previous = head;
        Node current = head.next;

        // Traverse to the node before the target position
        for(int i = 1; i<index; i++){
            previous = current;
            current = current.next;
        }

        if(current == null){
            return Optional.empty();
        }

        previous.next = current.next;
        length--;
        return Optional.of(current);
    }

    public boolean set(int index, int data){

        //check if LinkedList is empty
        if(length == 0 ){
            return false;
        }
        if(index < 0 || index >= length){
            return false;
        }

        Node current = head;

        for(int i = 0; i<index; i++){
            current = current.next;
        }

        if(current != null){
            current.data = data;
            return true;
        }
        return false;
    }

    public Optional<Node> get(int index){
        if(length == 0 || index < 0 || index >= length){
            return Optional.empty();
        }

        Node current  = head;
        for(int i =0; i<index; i++){
            current = current.next;
        }
        if(current != null)
            return Optional.of(current);

        return Optional.empty();
    }

    public void printList(){
        if(length == 0){
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while(current != null){
            System.out.print("{" + current.data + "} "  );
            current = current.next;
        }
        System.out.println("");
    }

}
