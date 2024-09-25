package doublylinkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> myDoublyLinkedList = new MyDoublyLinkedList<Integer>();
        myDoublyLinkedList.add(110);
        myDoublyLinkedList.add(10);
        myDoublyLinkedList.add(1);
        myDoublyLinkedList.add(170);

        myDoublyLinkedList.addFirst(20);
        myDoublyLinkedList.addIndex(2, 20);
        myDoublyLinkedList.print();
        List list = new ArrayList<Integer>();
        Stack stack = new Stack();
    }
}
