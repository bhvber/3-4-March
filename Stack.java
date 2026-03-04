import java.util.*;

class Stack {
    private List<Integer> list = new ArrayList<>();
    void push(int x) { list.add(0, x); }
    int pop() { return list.remove(0); }
    int peek() { return list.get(0); }
    boolean isEmpty() { return list.isEmpty(); }
}

