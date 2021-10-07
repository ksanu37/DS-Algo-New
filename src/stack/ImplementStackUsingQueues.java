package stack;
/*
https://leetcode.com/problems/implement-stack-using-queues/
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.


Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False


The idea is to use two queues: q1 and q1
keep pushing to q1
when pop is to be performed, transfer everything but last to q2 and pop q1
after this, swap the names q1 and q2 {since q2 is in the state that q1 should be in}
 */

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    Queue<Integer> q1;
    Queue<Integer>q2;

    public ImplementStackUsingQueues() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        int res;
        if(q1.size() == 1){
            res = q1.peek();
            q1.remove();
        } else {
            while(q1.size() != 1){
                q2.add(q1.peek());
                q1.remove();
            }
            res = q1.peek();
            q1.remove();
        }
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return res;
    }

    public int top() {
        int res;
        if(q1.size() == 1){
            res = q1.peek();
        } else {
            while(q1.size() != 1){
                q2.add(q1.peek());
                q1.remove();
            }
            res = q1.peek();
        }
        return res;
    }

    public boolean empty() {
        if(q1.size()==0 && q2.size()==0)
            return true;

        return false;
    }
}
