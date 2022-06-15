import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/one-week-preparation-kit-queue-using-two-stacks/problem

public class Solution {
    
    public static class QueueOfStacks<T> {
        private Stack<T> stack1 = new Stack<T>();
        private Stack<T> stack2 = new Stack<T>();
        
        public T peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }
        
        public void enqueue(T value) {
            stack1.push(value);
        }
        
        public T dequeue() {
            peek();
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        QueueOfStacks<Integer> queue = new QueueOfStacks<>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            switch(operation) {
                case 1: // enqueue
                    queue.enqueue(scan.nextInt());
                    break;
                case 2: // dequeue
                    queue.dequeue();
                    break;
                case 3: // peek
                    System.out.println(queue.peek());
                    break;
            }
        }
        scan.close();
    }
}
