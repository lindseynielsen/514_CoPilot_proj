package cs165.lab9;

/** Linked List Lab
 * Made by Toby Patterson 5/29/2020
 * For CS165 at CSU
 */

public class MyLinkedList implements MiniList<Integer>{
    /* Private member variables that you need to declare:
     ** The head pointer
     ** The tail pointer
     */
    private Node head;
    private Node tail;
    private int size;

    public class Node {
        // declare member variables (data and next)
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    
        // make class variables data and next
        // finish these constructors
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
            // set member variables
        }
    }

    // Initialize the linked list (set head and tail pointers)
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(Integer item) {
        // add item to the end of the list
        // return true if successful
        // return false if unsuccessful
        if (head == null) {
            head = new Node(item);
            tail = head;
            size++;
            return true;
        }
        else {
            tail.next = new Node(item);
            tail = tail.next;
            size++;
            return true;
        }
    }

    @Override
    public void add(int index, Integer element) {
        // add element at index
        // if index is out of bounds, throw an IndexOutOfBoundsException
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            head = new Node(element, head);
            size++;
        }
        else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = new Node(element, temp.next);
            size++;
        }

    }

    @Override
    public Integer remove() {
        // remove the first element in the list
        // return the element that was removed
        // if the list is empty, throw an IndexOutOfBoundsException
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        else {
            int temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
   
    }

    @Override
    public Integer remove(int index) {
        // remove the element at index
        // return the element that was removed
        // if index is out of bounds, throw an IndexOutOfBoundsException
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            int temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
        else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            int temp2 = temp.next.data;
            temp.next = temp.next.next;
            size--;
            return temp2;
        }

    }

    @Override
    public boolean remove(Integer item) {
        // remove the first instance of item in the list
        // return true if successful
        // return false if unsuccessful
        if (head == null) {
            return false;
        }
        else if (head.data == item) {
            head = head.next;
            size--;
            return true;
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data == item) {
                    temp.next = temp.next.next;
                    size--;
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

    }


    @Override
    public void clear() {
        // clear the list
        head = null;
        tail = null;
        size = 0;

    }

    @Override
    public boolean contains(Integer item) {
        // return true if item is in the list
        // return false if item is not in the list
        if (head == null) {
            return false;
        }
        else {
            Node temp = head;
            while (temp != null) {
                if (temp.data == item) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }


    }

    @Override
    public Integer get(int index) {
        // return the element at index
        // if index is out of bounds, throw an IndexOutOfBoundsException
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }


    }

    @Override
    public int indexOf(Integer item) {
        // return the index of the first instance of item in the list
        // return -1 if item is not in the list
        if (head == null) {
            return -1;
        }
        else {
            Node temp = head;
            int index = 0;
            while (temp != null) {
                if (temp.data == item) {
                    return index;
                }
                temp = temp.next;
                index++;
            }
            return -1;
        }


    }

    @Override
    public boolean isEmpty() {
        // return true if the list is empty
        // return false if the list is not empty
        if (head == null) {
            return true;
        }
        else {
            return false;
        }


    }                   


    @Override
    public int size() {
        // return the size of the list
        return size;

    }

    // Uncomment when ready to test
   @Override
   public String toString() {
       String ret = "";
       Node curr = head;
       while (curr != null) {
           ret += curr.data + " ";
           curr = curr.next;
       }
       return ret;
   }

}