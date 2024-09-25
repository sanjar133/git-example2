package doublylinkedlist;

import java.util.NoSuchElementException;

public class MyDoublyLinkedList<T> {
   private static class Node<T> {
      private T val;
      private Node<T> next;
      private Node<T> prev;

      public Node(T val) {
         this.val = val;
      }
   }

   private Node<T> first;
   private Node<T> last;

   private int size = 0;

   public void add(T val) {
      Node<T> node = new Node<T>(val);
      if (first == null) {
         first = last = node;
         size ++;
         return;
      }

      last.next = node;
      node.prev = last;
      last = node;
      size ++;
   }

   public void addFirst(T val) {
      Node<T> node = new Node<T>(val);
      if (first == null) {
         first = last = node;
         size ++;
         return;
      }

      first.prev = node;
      node.next = first;
      first = node;
      size ++;
   }

   public void removeFirst(){
      if (first == null) {
         throw new NoSuchElementException("linked list is empty");
      }
      Node<T> temp = first.next;
      temp.prev = null;
      first.next = null;
      first = temp;
      size --;
   }

   public void removeLast() {
      if (first == null) {
         throw new NoSuchElementException("linked list is empty");
      }

      Node<T> preLast = last.prev;
      last.prev.next = null;
      last.prev = null;
      last = preLast;
      size --;
   }
   public void addIndex(int index, T val) {
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException();
      }

      if (index == 0) {
         addFirst(val);
         return;
      }

      if (index == size) {
         add(val);
         return;
      }

      Node<T> node = new Node<>(val);
      Node<T> current = first;
      for (int i = 0; i < index - 1; i++) {
         current = current.next;
      }
      node.prev = current;
      node.next = current.next;
      current.next.prev = node;
      current.next = node;

      size++;
   }

   public void print() {
      Node<T> temp = first;

      System.out.print("[");
      while (temp != null) {
         System.out.print(temp.val + " ");
         temp = temp.next;
      }
      System.out.println("]");
   }

   public int size() {
      return size;
   }
}
