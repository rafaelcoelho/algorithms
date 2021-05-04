package com.personal.rackingcode;

public class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public boolean isEmpty() {
        return top == null;
    }

    public T peek() {
        if (isEmpty())
            return null;
        
        return top.data;
    }
    public T pop() {
        if (isEmpty())
            return null;

        StackNode<T> tmp = top;
        top = top.next;

        return tmp.data;
    }

    public void push(T data) {
        StackNode<T> tmp = new StackNode<>(data);

        if (top != null) {
            tmp.next = top;
        }

        top = tmp;
    }

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("Rafael");
        stack.push("Carol");
        stack.push("Kariny");

        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}