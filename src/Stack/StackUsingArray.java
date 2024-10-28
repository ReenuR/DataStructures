package Stack;

public class StackUsingArray {
    int[] a;
    int top;

    public StackUsingArray(){
        a = new int[100];
        top = -1;
    }

    public void push(int num) {
        //check if stack is already full
        if(top==a.length-1)
            System.out.println("Stack Overflow, You cannot add more elements");
        else
            a[++top] = num;
    }
    public Boolean isEmpty(){
        return top == -1 ? true:false;
    }

    public int pop(){
        if(top == -1){
            System.out.println("Stack Underflow!!");
            return -1;
        }
        else{
            int tempNum = a[top];
            top--;
            return tempNum;
        }
    }

    public int peek(){
        if(top == -1){
            return -1;
        }
        return a[top];
    }

}

