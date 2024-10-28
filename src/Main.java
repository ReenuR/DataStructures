import Stack.StackUsingLInkedList;

public class Main {
    public static void main(String [] args){

        StackUsingLInkedList stck = new StackUsingLInkedList();
        System.out.println(stck.peek());
        stck.push(1);
        stck.push(2);
        stck.push(3);
        stck.push(4);
        stck.push(5);
        while(!stck.isEmpty()){
            System.out.print(stck.pop() + " ");
        }
        System.out.println( stck.peek());

    }
}
