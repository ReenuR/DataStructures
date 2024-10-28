package LinkedList;

public class Main {
    public static void main(String [] args){
        LinkedList list =  new LinkedList();

        list.append(1);
        list.printList();
        list.append(2);
        list.prepend(3);
        list.printList();
        list.append(4);
        list.printList();
        list.deleteByPosition(0);
        list.printList();
        list.append(5);
        list.printList();
        list.deleteByValue(2);
        list.printList();

    }
}
