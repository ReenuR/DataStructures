package Stack;

class Node{
    int num;
    Node next;

    public Node(int x){
        num = x;
        next =null;
    }
}
public class StackLL {
    Node top = null;

    public static void main(String[] args) {
        StackLL stack =  new StackLL();

        assert stack.isEmpty() : "Stack should be empty initially";

        for(int i=1; i<=5; i++){
            stack.push(i);
        }
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }

    private int pop() {
        if(top == null)
            return 0;
        int num = top.num;
        top = top.next;
        return num;
    }

    private boolean isEmpty() {
        return top == null;
    }

    private int peek() {
        return isEmpty()? -1: top.num;
    }

    public void push(int num){
        Node node = new Node(num);
        if(top==null)
            top = node;
        else{
            node.next = top;
            top = node;
        }
    }
}
