package stack;

/*
https://leetcode.com/problems/implement-queue-using-stacks/
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.


Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

The idea is to make the dequeue operation Heavy:
--> Take two stacks s1 and s2
--> Push elements to s1
--> when dequeue is called, check if s2 is empty, if yes --> transfer elements from s1 to s2 and return the top element
--> If s2 is not empty, then return the top element from s2


 */

import java.util.Stack;

public class ImplementQueueUsingStack {
    public Stack<Integer> s1;
    public Stack<Integer> s2;

    public ImplementQueueUsingStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        if(s1.empty() && s2.empty())
            return true;

        return false;
    }
}
