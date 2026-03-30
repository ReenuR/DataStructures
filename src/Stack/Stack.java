package Stack;

public class Stack {
    int top;
    int arr[];

    public Stack(){
        top=-1;
        arr=new int[]{};
    }
    public Stack(int size){
        top=-1;
        arr=new int[size];
    }
    public void push(int x){
        arr[++top] = x;
    }
    public int pop(){
        int num = arr[top--];
        return  num;
    }
    public int peek(){
        if(isEmpty())
            return -1;
        else
            return arr[top];
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public static void main(String[] args) {
        int size =5;
        Stack stack = new Stack(size);
        for(int i=1; i<=size; i++){
            stack.push(i);
        }
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        for(int i=0; i<size; i++){
            System.out.println(stack.pop());
        }
        System.out.println(stack.isEmpty());

    }
}

