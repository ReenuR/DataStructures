package Stack;

public class StackUsingLInkedList {

    private Node top;
    private int height;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }
    public StackUsingLInkedList(){
    }

    public void push(int num){
        Node node = new Node(num);
        if(top == null){
            top = node;
        }else {
            node.next = top;
            top = node;
        }
        height ++;
    }
    public int pop(){
        int num;
        if(top == null){
            return  -1;
        }
        else{
            num = top.value;
            top = top.next;
        }
        return num;
    }
    public boolean isEmpty(){
        return top == null ? true : false;
    }
    public  int peek(){
        if(top == null)
            return  -1;
        return top.value;
    }
}
