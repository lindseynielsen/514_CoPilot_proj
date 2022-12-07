package cs165;

import java.util.*;

public class BPlusTree {
    enum Type {
        LEAF,
        INDEX
    }

    /* Do not change this class! */
    private static class Node {
        ArrayList<Integer> keys;
        ArrayList<Node> children;
        boolean isLeaf;

        Node(Type nt) {
            isLeaf = nt == Type.LEAF;

            keys = new ArrayList<>();
            children = new ArrayList<>();
        }

        // Do not change the toString methods!
        private String toString(int depth) {
            StringBuilder s = new StringBuilder();
            String padding = "";
            for (int i = 0; i < depth; i++) {
                padding += "  ";
            }
            s.append(padding + (isLeaf ? "LEAF NODE\n" : "INDEX NODE\n"));
            s.append(padding);
            for (int i = 0; i < keys.size(); i++) {
                s.append(String.format("key %d = %d, ",  i, keys.get(i)));
            }
            s.deleteCharAt(s.length() - 2);
            s.append("\n");
            if (!children.isEmpty()) {
                for (int i = 0; i < children.size(); i++) {
                    s.append(padding + "child " + i + " =\n");
                    s.append(children.get(i).toString(depth + 1));
                }
            }
            return s.toString();
        }

        public String toString() {
            return toString(0);
        }
    }

    /*
     * Our B+ Implementation
Let's take a quick tour of the code in the lab, which will explain how our B+ tree is set up in Java.

You should notice the Node class right away. For the sake of simplicity, this Node class represents both index nodes and leaf nodes. To help you tell when a Node is being used as an index or as a leaf, it holds a boolean called isLeaf. Whenever you make a Node, you will have to specify the type by passing either Type.LEAF or Type.INDEX to the constructor, which will set this boolean accordingly.

Remember that leaf nodes are where the actual data is, and index nodes just contain keys to help you find the data. The keys are a lot like road signs pointing you in the right direction at each intersection - they're not your destination, but they let you know where to go to get there. The leaf nodes, or more specifically, the data in them, are your actual destination.

Since the same class is being used to represent leaf and index nodes, note that the index node's keys and the leaf node's data are both stored in the keys ArrayList. Don't let that confuse you!

For a little more clarity, this is what a simple B+ tree might look like, with some of the parts labelled:

An example B+ tree with order 3.

This is a tree of order 3, meaning it can a maximum of 2 keys in each node and a minimum of 1. In the code, the order of the tree is stored as part of the BPlusTree class and set in the constructor, meaning you have access to it everywhere.

Notice how each node has a list of keys and a list of children. For leaf nodes, the list of children is unused - for index nodes, the list of children contains references to each of the child nodes.

Keeping the Invariants
You probably already know the basic idea of adding to a B+ tree, but I'd like to walk through a fairly complicated example step-by-step so we have a better idea of how to actually program it. While we do this, I'll point out some considerations for how these steps might look in Java. Taking the tree above, let's insert the key 17, and watch the resulting chaos unfold.
The previous tree with 17 inserted.

The first thing we need to do is figure out where the 17 should go. Our strategy will be to recursively search through the tree, following the correct child pointers until we arrive at a leaf node.

Starting at the root, we find the root is not a leaf node, so we turn to examining the keys. There are two keys: 15 and 20. This means that the first child pointer will bring us to leaf nodes containing values below 15 - not good. The second child pointer will bring us to leaf nodes containing values greater than or equal to 15, but less than 20 - hey, that sounds like us.

Following that child pointer, we arrive at a leaf node. Awesome! Let's insert our 17 in sorted order. Since the keys are stored in array lists, this is as simple as saying node.keys.add(17) and then node.keys.sort(null) (or perhaps Collections.sort(node.keys)).

The previous tree with the node 17 was inserted in splitting.

If this insert didn't bring the node above its max capacity of 2, we would be done. However, with the 17, the node exceeded its max capacity, and it must be split into two nodes. A new leaf node is created, and the lower half of the original node's keys are moved into the new one, rounded down. In this case, we removed the 15, created a new leaf node, and shuffled the 15 into that new node.

Before the split, the middle key of the node was 17. Therefore, we need to raise that key up to the parent node, and insert it in sorted order. We also need to add a new child pointer in the parent for the new node we just created. The new child pointer needs to go just before the one we originally followed, since the original child pointer is now pointing to the "larger" of the two nodes, and the new child pointer is pointing to the "smaller" of the two.

The previous tree with the parent node split in two.

Of course, you may have noticed the parent is now over capacity, so it also has to split into two nodes. A similar procedure is in order; we split the keys and the child pointers in half, giving one half to a freshly-created index node and leaving the other half in the original node. However, this time, the middle key is not kept in either of the nodes. It still moves up to the parent node and is inserted in sorted order, but it doesn't stay in the left or right split nodes. This is the only difference between splitting and index and a leaf node, but it's a very important one.

17 was the middle key in this case, so it leaves both split nodes and moves up to the parent... node? Well, we just split the root node, which by definition has no parent! What now?

We have to tend to a special case here, which is that when the root node splits, we must create a new root. We wanted to insert 17, so our new root has 17 as its only key, and two child pointers pointing to both of the split nodes. A new root is created to replace the split root, and the insert is done.

Finally, we're done. Order and balance have been restored to the tree, and 17 is now part of the bottom-layer leaf nodes.

Hopefully, this gives you some sense of how to approach the insert. Be careful, deliberate, and plan out your approach. I would highly recommend doing this recursively with a helper method, as this makes it easier to keep track of each node's parent (when a function working on a node returns, it returns into another instance of the function that was working on the node's parent - so if your recursive insert returns something, it can essentially communicate with its parent!)

Wrapping Up
Inside the lab code is the void insert(int key) function. When someone calls this, it should add the key to the tree and return nothing. You may write as many helper functions or other methods as you see fit, but do not modify any code given to you, and do not add to or modify the Node class or the toString() methods.

You should always store the root of the tree in the root variable in the BPlusTree class. The root is initialized to an empty leaf node - your first few inserts should add to this leaf node, which should split once it becomes too full, creating a new index node which then becomes the root. This means small trees will be just a single leaf node.

A recursive toString method is given to the BPlusTree which shows the entire tree in text. Print the tree to help you see what it's doing as you add to it.

The main method contains some simple test code. In BPlusTest, there are three different trees you will be tested on. To test tree 1, type in a '1' for your input, and to test tree 2, type in a '2' for your input, and type a '3' for tree 3. A successful implementation will produce this output when you test tree 1:

INDEX NODE
key 0 = 15 
child 0 =
  INDEX NODE
  key 0 = 5, key 1 = 10 
  child 0 =
    LEAF NODE
    key 0 = 0, key 1 = 1, key 2 = 2, key 3 = 4 
  child 1 =
    LEAF NODE
    key 0 = 5, key 1 = 7, key 2 = 8, key 3 = 9 
  child 2 =
    LEAF NODE
    key 0 = 10, key 1 = 11, key 2 = 13 
child 1 =
  INDEX NODE
  key 0 = 18, key 1 = 20 
  child 0 =
    LEAF NODE
    key 0 = 15, key 1 = 16, key 2 = 17 
  child 1 =
    LEAF NODE
    key 0 = 18, key 1 = 19 
  child 2 =
    LEAF NODE
    key 0 = 20, key 1 = 23, key 2 = 25, key 3 = 26 
We have added some comments in the code to help you understand the algorithms, and we have some helper methods you may want to use in your code as well. Keep in mind that we are always available to answer your questions. We are happy to help with anything. Good luck.
     */

    int order;
    Node root;

    public BPlusTree(int order) {
        this.order = order;
        root = new Node(Type.LEAF); // The root is initially a leaf node!
    }
   /* YOUR CODE HERE
     * This is a difficult task to insert into a B+ tree as you have to take into account how and when to split nodes.
     * Because of this we have provided some pseudo code for you to implement, as well as a structure of helper methods.
     * You are welcome to go off and implement it your own way if you wish. In fact if you finish the lab early we encourage it.
     *      if insertHelper returns true given (key,root):
     *          make a new root of type Index
     *          add the the current root to the children of the new root
     *          call splitChild to split root, provided that newRoot is now root's parent 
     *          make root be the newRoot
     */
 
    public void insert(int key) {
        // YOUR CODE HERE
        insertHelper(key, root);
        if (insertHelper(key, root)) {
            Node newRoot = new Node(Type.INDEX);
            newRoot.children.add(root);
            splitChild(newRoot, root);
            root = newRoot;
        }
    }

    /* YOUR CODE HERE
    *   This is a helper method to the insert. It will be a recursive method going down each index node until it can add
    *   to a leaf node.
    *           if the node is a leaf:
    *                add the key to the keys list of the node
    *                sort the keys
    *                return  the keys size > order - 1 (if the node should be split)
    *           else:
    *               get the key child(hint: use the Method you wrote)
    *               if insertHelper of key, keyChild:
    *                   split the child (Think about what the parent and child are here)
    *                   return  the keys size > order - 1 (if the node should be split)
    *
    * */
    private boolean insertHelper(int key, Node node){
        // YOUR CODE HERE
        if (node.isLeaf) {
            node.keys.add(key);
            Collections.sort(node.keys);
            return node.keys.size() > order - 1;
        } else {
            Node keyChild = getKeyChild(key, node);
            if (insertHelper(key, keyChild)) {
                splitChild(node, keyChild);
                return node.keys.size() > order - 1;
            }
        }
        return false;
    
    }
        //TODO
    private Node getKeyChild(int key, Node parent){
        return parent.children.get(getFirstIndexGreaterThanKey(parent,key));
    }
  /* YOUR CODE HERE
     * This is a helper function that will allow you to get the first index in the nodes keys list that is greater then the key given
     *  set the start index to 0;
     *       for (index is less then node's keys size; add one to the index)
     *           if the key at the current index is greater then key:
     *               break
     * return index
    *
    * */
    private int getFirstIndexGreaterThanKey(Node node,int key){
        // YOUR CODE HERE
        int index = 0;
        for (int i = 0; i < node.keys.size(); i++) {
            if (node.keys.get(i) > key) {
                break;
            }
            index++;
        }
        return index;
    }
    /*YOUR CODE HERE
    * This is perhaps the most difficult method of this lab, so we have given you a pretty detailed layout of how to do it. Feel free to come to helpdesk if you have questions.
    * NOTE: if you don't want to follow our framework please do not feel like you have to.
    * */
    private void splitChild(Node child, Node parent) {
        if (child.isLeaf) { //Splitting Leaf node
			
			//split is going to hold the upper half of child's  nodes
            Node split = new Node(Type.LEAF);
            
			//TODO: remove the last half of the keys on child and add them to split(hint: remember that this is full so size(child.keys) > order - 1))
            for (int i = (order - 1) / 2; i < child.keys.size(); i++) {
                split.keys.add(child.keys.get(i));
            }
            for (int i = (order - 1) / 2; i < child.keys.size(); i++) {
                child.keys.remove(i);
            }
            
			//TODO get the index where split node needs to be added to parent's children (hint: getFirstIndexGreaterThenKey)
            int index = getFirstIndexGreaterThanKey(parent, split.keys.get(0));

            
			//TODO add first key in split node to parent keys at index
            parent.keys.add(index, split.keys.get(0));
            
			//TODO add split node to children of parent at index +1
            parent.children.add(index + 1, split);
            
        } else { //Splitting Index node
            Node split = new Node(Type.INDEX);
        
            //TODO get removedkey from child keys at size/2, this is the middle key of the index node so we push it up opposed to copying it up like in a leaf split
            int removedKey = child.keys.get((order - 1) / 2);
			
			//TODO removed last half of keys and children of child node and add them to split node
            for (int i = (order - 1) / 2; i < child.keys.size(); i++) {
                split.keys.add(child.keys.get(i));
            }
            for (int i = (order - 1) / 2; i < child.keys.size(); i++) {
                child.keys.remove(i);
            }
            for (int i = (order - 1) / 2 + 1; i < child.children.size(); i++) {
                split.children.add(child.children.get(i));
            }
            for (int i = (order - 1) / 2 + 1; i < child.children.size(); i++) {
                child.children.remove(i);
            }
            
			// TODO take the pointer of the last child in the 'child' node and move it to the children of the split node(to clarify: this should remove the last child and add it to split)
            split.children.add(child.children.get(child.children.size() - 1));
            child.children.remove(child.children.size() - 1);
			
			//TODO get index where the split node to be added to parent(hint: getFirstIndexGreaterThanKey)
            int index = getFirstIndexGreaterThanKey(parent, split.keys.get(0));
            
			//TODO add  removed key to parent keys at index
            parent.keys.add(index, removedKey);
            
			//TODO add split node to children of parent at index +1
            parent.children.add(index + 1, split);
        }
    }
    /* YOUR CODE HERE
    * This method will print the tree in a level order traversal. It will print each level on a new line.
    * */
    public void printTree() {
        // YOUR CODE HERE
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            for (int i = 0; i < node.keys.size(); i++) {
                System.out.print(node.keys.get(i) + " ");
            }
            System.out.println();
            if (!node.isLeaf) {
                for (int i = 0; i < node.children.size(); i++) {
                    queue.add(node.children.get(i));
                }
            }
        }
    }
    /* YOUR CODE HERE
    * This method will print the tree in a level order traversal. It will print each level on a new line.
    * */
    public void printTree2() {
        // YOUR CODE HERE
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            for (int i = 0; i < node.keys.size(); i++) {
                System.out.print(node.keys.get(i) + " ");
            }
            System.out.println();
            if (!node.isLeaf) {
                for (int i = 0; i < node.children.size(); i++) {
                    queue.add(node.children.get(i));
                }
            }
        }
    }
    /* YOUR CODE HERE
    * This method will print the tree in a level order traversal. It will print each level on a new line.
    * */
    public void printTree3() {
        // YOUR CODE HERE
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            for (int i = 0; i < node.keys.size(); i++) {
                System.out.print(node.keys.get(i) + " ");
            }
            System.out.println();
            if (!node.isLeaf) {
                for (int i = 0; i < node.children.size(); i++) {
                    queue.add(node.children.get(i));
                }
            }
        }
    }    

    // For debugging purposes.
    public String toString() {
        return root.toString();
    }

    public static void main(String[] args) {
        BPlusTree bpt = new BPlusTree(5);

        bpt.insert(18);
        bpt.insert(23);
        bpt.insert(17);
        bpt.insert(2);

        // If you're having trouble, it's typically a good idea to check the
        // state of the tree after a few inserts.
        // Feel free to print the tree whenever you want, by invoking
        // System.out.println(bpt);

        bpt.insert(26);
        bpt.insert(5);
        bpt.insert(1);
        bpt.insert(8);

        bpt.insert(20);
        bpt.insert(4);
        bpt.insert(16);
        bpt.insert(10);

        bpt.insert(9);
        bpt.insert(0);
        bpt.insert(11);
        bpt.insert(15);

        bpt.insert(19);
        bpt.insert(13);
        bpt.insert(7);
        bpt.insert(25);

        System.out.println(bpt);
    }
}
