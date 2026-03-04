import java.util.*;

class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

class IntList {
    private Node head;

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) last = last.next;
        last.next = newNode;
    }

    void print() {
        for (Node curr = head; curr != null; curr = curr.next)
            System.out.print(curr.data + " ");
        System.out.println();
    }

    void deleteNegatives() {
        // Проверяем наличие отрицательных
        boolean hasNeg = false;
        for (Node curr = head; curr != null; curr = curr.next)
            if (curr.data < 0) { hasNeg = true; break; }

        if (hasNeg) {
            // Удаляем отрицательные
            while (head != null && head.data < 0) head = head.next;
            if (head == null) return;

            Node prev = head;
            for (Node curr = head.next; curr != null; curr = curr.next) {
                if (curr.data < 0) prev.next = curr.next;
                else prev = curr;
            }
        } else {
            // Удаляем 10-й
            if (head == null) return;
            Node prev = null, curr = head;
            for (int i = 1; curr != null && i < 10; i++) {
                prev = curr;
                curr = curr.next;
            }
            if (curr != null) {
                if (prev == null) head = curr.next;
                else prev.next = curr.next;
            }
        }
    }
}

class Task1 {
    public static void main(String[] args) {
        IntList list = new IntList();
        Random rand = new Random();

        for (int i = 0; i < 23; i++)
            list.add(rand.nextInt(201) - 100);

        System.out.println("Исходный:");
        list.print();

        list.deleteNegatives();

        System.out.println("Результат:");
        list.print();
    }
}