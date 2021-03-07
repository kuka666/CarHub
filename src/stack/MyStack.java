package stack;

import java.util.Stack;

public class MyStack<S> {

    Stack<String> stack = new Stack<>();
    String stackValues;

    public MyStack() {
    }

    public MyStack(String stackValues) {
        this.stackValues = stackValues;
    }

    public void push(String stackValues) {
        System.out.println(stack.push(stackValues));
    }

    public void pop() {
        System.out.println(stack.pop());
    }

    public String peek() {
        return stack.peek();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public boolean isFull(){
        if(isEmpty()){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<String>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack.peek());
        System.out.println(stack.isFull());
        stack.pop();
        stack.pop();
    }

}