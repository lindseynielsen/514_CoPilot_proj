import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayQueue is a FIFO (First In First Out) data structure that stores its elements
 * in an array (or something like it, like an {@link java.util.ArrayList}).
 * <p>
 * Can we use an {@link java.util.ArrayList} to directly represent a queue? A FIFO needs to push on one end,
 * and pop from the other. The tail of an {@link java.util.ArrayList} can support pop and push efficiently,
 * but the front supports neither efficiently.
 * <p>
 * Instead, we use an array for storage, and we represent the head and tail of the queue
 * with indices into that array. When one of the indices would fall off the end of the array,
 * it just goes back to the start of the array. That is why this pattern is called a "circular"
 * array. Read more about that <a href=../queue.html>here</a>.
 * 
 * <p>
 * We can think of the head and tail indices "chasing" each other around the circular
 * array. The head is the index of the next item to be removed, and the tail is the index
 * storage. When you add an item, the tail moves. When you take an item, the head moves.
 * <p>
 * If the head catches the tail, the queue is empty. If the tail catches the head, the queue is full.
 * <p>
 * That's a lot to take in, but it's easier to code than it sounds. Notice that the member variables
 * "removed" and "added" are counters recording the <i>total</i> operation count. To see where the head and
 * tail of the queue are, just compute:
 * {@code (removed % elements.length)} or {@code (added % elements.length)}
 * <p>
 * by {@code cspfrederick} and {@code garethhalladay} Fall17 <br>
 * inspired by Chris Wilcox
 * @param <E> the type of elements held in this collection
 * @see java.util.ArrayList
 */



 /*Overview
A Queue is a FIFO (First in First out) data structure meaning that the first data to be inserted is the first to be removed so we can maintain a certain priority. Queues in Computer Science are much like queues/lines in real life. For example, at an ice cream booth people line up and the first person in line is the first to get ice cream and the last person in line is served last. We could maintain chronological order.

Instead of using a linked list we are going to be using an array implemented with a circular queue. This class will also be generic unlike the last lab which implemented a queue that held strings.

Generics
The oracle documentation states that generics enable types (classes and interfaces) to be parameters when defining classes, interfaces, and methods.

Before generics were introduced into the language, the compiler had a much harder time identifying errors due to type restrictions and you had to cast your objects when pulling them from data structures such as Lists. An example of this:

without generics, needs cast:

List list = new ArrayList();
list.add(“hello”);
String s = (String) list.get(0);
with generics:

List<String> list = new ArrayList<String>();
list.add(“hello”);
String s = list.get(0);
Because our underlying data structures are generic you might try to instantiate a generic array like this:

E[] arr = new E[size];
This is not possible.

This is because when the code runs, the type E is "not known" (this is called type erasure). This idea works in many other languages, but it doesn’t work in Java. Other languages will compile each generic use into a custom class. For example, in C++ a vector of int, a vector of char, and vector of Shape would each end up having a custom class.

Instead, when instantiating a new generic array, you should use the following code:

@SuppressWarnings("unchecked")
E[] arr = (E[]) new Object[size];
NOTE
we add the @SuppressWarnings("unchecked") because this code will cause a warning. Unchecked casting is normally dangerous. Do you think there is a situation where this code could be dangerous?
Writing code that generates warnings can desensitize you to the bad idea of writing code that generates warnings. Don’t leave in warning-generating code unless you understand exactly why that code is there and why it is unavoidable. Generic code that uses arrays is one such justifiable circumstance; you are unlikely to encounter many others.

To learn more about generics, which look at the Oracle Java Tutorials here.

Circular Array Queues
During this lab we will be creating a circular array queue with a maximum capacity. This will give us an idea of how queues are implemented outside of academia. The capacity is a very realistic constraint.

Notice the notes in the aid below about using the modulo operator to find the next position to insert and remove, this will be very helpful. 

The following image is a visual aid as to how circular array queues work:

generic 
IMPORTANT OBSERVATION:
Notice that when there were items in the queue and some were removed from the front we did not have to shift all the elements down which could become quite annoying if the queue was large. Instead we simply keep track of where to insert the next item and where to remove the next item.

Implementing the Code:
You may implement the methods in whatever order makes sense to you but make sure to at least do the constructor first. The comments above each method provide ample documentation about how to implement them.
Another Note:
The IQueue interface and AQueue abstract class are completed for you. IQueue describes the methods a Queue must implement and AQueue deals with the duplicate methods like add/offer, remove/poll, peek/element() and throws the appropriate exceptions instead of failing silently. The TrainCar class is provided for testing purposes.

  */
public class ArrayQueue<E> extends AQueue<E> implements IQueue<E>{

    /**
     * the underlying array for the queue
     */
    protected E[] elements;

    /**
     * the total elements added (set back to zero if clear is called)
     */
    protected int added = 0;

    /**
     * the total elements removed (set back to zero if clear is called)
     */
    protected int removed = 0;

    /**
     * Creates a new queue backed by an array of length {@code maxSize}.
     * Use {@link #newArray(int)} to create the elements array.
     * @param maxSize the capacity of the queue
     * @see #newArray(int)
     */
    public ArrayQueue(int maxSize) {
        elements = newArray(maxSize);
    }

    /**
     * A helper method to create a new array of the generic type.
     * Read the information provided on <a href=../generics.html>generics</a>.
     * It walks you through the behavior of this small method.
     * @param size the size of the new array
     * @return an new instance of an array of type E
     */
    @SuppressWarnings("unchecked")
    protected E[] newArray(int size) {
        return (E[]) new Object[size];
    }

    /**
     * Adds an element to the queue. If the queue is full, return false,
     * otherwise add to the next available position in the queue.
     * 
     * otherwise add to the next available position in the queue.
     * <p>
     * The index of the next available position can be found by calculating
     * the remainder of the total number of elements added by the length of the array.
     * the remainder of the total number of elements added by the length of the array.
     * <p>
     * Don't forget to increment the added field!
     * 
     * @param e the element to add
     * 
     * @return true if the element can be added, false otherwise
     * 
     * @see #added
     */

    //  * Inserts the specified element into this queue if it is possible to do so
    //  * immediately without violating capacity restrictions.
    //  * @param e the element to add
    //  * @return true if the element was added, false if the queue was full
    //  */
    /*
     * Adds an element to the queue. If the queue is full, return false, otherwise add to the next available position in the queue. otherwise add to the next available position in the queue.

The index of the next available position can be found by calculating the remainder of the total number of elements added by the length of the array. the remainder of the total number of elements added by the length of the array.

Don't forget to increment the added field!

     */
    //System.out.println("Offering to Queue:");
    // System.out.println("     Offer(1) -> " + q.offer(1));
    // System.out.println("     Offer(2) -> " + q.offer(2));
    // System.out.println("     Offer(3) -> " + q.offer(3));
    @Override
    public boolean offer(E e) {
        if (added - removed == elements.length) {
            return false;
        }
        elements[added % elements.length] = e;
        added++;
        return true;
    }       
    

    /**
     * Removes the oldest element (the head) from the queue, and returns it.
     * If the queue is empty, return null.
     * <p>
     * The index of the oldest element can be determined by calculating the remainder
     * of the total elements removed by the length of the array.
     * <p>
     * Don't forget to increment the removed field!
     * <p>
     * @return the oldest element in the queue, or null if the queue is empty
     * @see #removed
     */

    // System.out.println("Polling and removing some elements:");
    // System.out.println("     poll() should be 1 -> " + q.poll());
    @Override
    public E poll() {
        if (added == removed) {
            return null;
        }
        E e = elements[removed % elements.length];
        removed++;
        return e;
    }      


    /**
     * Returns the oldest element in the queue (the element we would remove next),
     * but does not remove it.
     * If the queue is empty, return null.
     * <p>
     * The index of the oldest element can be determined by calculating the remainder
     * of the total elements removed by the length of the array.
     * @return the oldest element in the array, or null if the queue is empty
     */
    @Override
    public E peek() {
        if (added == removed) {
            return null;
        }
        return elements[removed % elements.length];
    }

    /**
     * Returns the number of elements in the queue. This method runs in O(1) time.
     * @return the number of elements in the queue
     */
    @Override
    public int size() {
      return added - removed;         
    }

    /**
     * Returns true if the queue is empty. This method runs in O(1) time.
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return added == removed;
    }

    /**
     * Removes all of the elements from the queue. This method runs in O(1) time.
     */
    @Override
    public void clear() {
        added = 0;
        removed = 0;
    }

    /**
     * Returns true if the queue is full. This method runs in O(1) time.
     * @return true if the queue is full, false otherwise
     */
    public boolean isFull() {
        return added - removed == elements.length;
    }
    /**
     * Removes the oldest element (the head) from the queue, and returns it.
     * If the queue is empty, return null.
     * <p>
     * The index of the oldest element can be determined by calculating the remainder
     * of the total elements removed by the length of the array.
     * <p>
     * Don't forget to increment the removed field!
     * <p>
     * @return the oldest element in the queue, or null if the queue is empty
     * @see #removed
     */


    @Override
    public boolean contains(Object o) {
        for (int i = removed; i < added; i++) {
            if (elements[i % elements.length].equals(o)) {
                return true;
            }
        }
        return false;
    }
    

    public static void main(String[] args) {
        IQueue<Integer> q = new ArrayQueue<>(10);
        
        System.out.println("Offering to Queue:");
        System.out.println("     Offer(1) -> " + q.offer(1));
        System.out.println("     Offer(2) -> " + q.offer(2));
        System.out.println("     Offer(3) -> " + q.offer(3));
        System.out.println("     size() should be 3 -> " + q.size());
        System.out.println("     contains(2) should be true -> " + q.contains(2));

        System.out.println("Adding more elements using add():");
        System.out.println("     add(4);  add(5); add(6); add(7); add(8); add(9); add(10);");
        q.add(4);  q.add(5); q.add(6); q.add(7); q.add(8); q.add(9); q.add(10);
        System.out.println("     size() should be 10 -> " + q.size());
        
        System.out.println("Trying to offer to a full queue:");
        System.out.println("     offer(11) should return false -> " + q.offer(11));
        System.out.println("     size() should still be 10 -> " + q.size());
        
        
        System.out.println("Polling and removing some elements:");
        System.out.println("     poll() should be 1 -> " + q.poll());
        System.out.println("     remove() should be 2 -> " + q.remove());
        System.out.println("Testing clear:");
        q.clear();
        System.out.println("     size() should be 0 -> " + q.size());
        
        System.out.println("Trying to poll from an empty queue:");
        System.out.println("     poll() should return null -> " + q.poll());
        System.out.println("     size() should still be 0 -> " + q.size());
        
        System.out.println("Testing contains() with TrainCar objects:");
        ArrayQueue<TrainCar> qCar = new ArrayQueue<>(10);
        qCar.offer(new TrainCar("Engine", "orange", 80523));
        qCar.offer(new TrainCar("Passenger", "blue", 24601));
        qCar.offer(new TrainCar("Caboose", "red", 12345));
        TrainCar toTest = new TrainCar("Caboose", "red", 12345);
        System.out.println("     contains(" + toTest + ") should be true -> " + qCar.contains(toTest));
        System.out.println();

        // final testing uncomment the following line to get comprehensive testing.
        //Note: zyBooks is not able to run 100000 tests or more.
        final int hundred_thousand = 100000;
        final int million = 1000000;
        
//        QueueTestProgram.printFailedTests(million,
//                                          ArrayBlockingQueue::new,

//                                          ArrayQueue::new);
       
    }

}
