/* Binary Search Tree Class
*  Made by Toby Patterson for CS165 at CSU
*  6/25/2020
*  A basic binary search tree of integers, without a remove method.
*/
/*
BSTTest.java is the main in zyBooks and is used for testing your code. Tree.java is the interface you will implement in BST.java.

Here is the jar file if you would like to code in another environment:L20.jar

The example code you will be working with for this lab is a binary search tree of Integers. This means that it will be a sorted tree, with each parent node having a left child smaller than it, and a right child larger.

The following tree will be used to demonstrate the various sorting algorithms:

binary tree example

Inorder
An inorder traversal will act recursively going in the order: left, root, right. This means for the above tree an inorder traversal would be:

10 22 25 30 232
The traversal calls itself giving the left node as the root node of the tree to traverse. Once it hits the base case (root == null), starts going back up the stack trace where it visits the root, and then recursively visits the right node. A recursive call on the right node will still hit the left node recursive call before going right again.

Postorder
Postorder will recursively visit the left and right nodes, however it will go in a different order than inorder. It's order is: left, right, root. The postorder traversal for the above tree is:

10 25 22 232 30
Preorder
Preorder traversal, like the other two, will recursively visit left and right nodes, but the root node being at the top of the call list. Preorder goes: root, left, right. The preorder traversal of the above tree is:

30 22 10 25 232.
Time for Code
Once you have an idea of how the search algorithms work, it may come somewhat naturally how to put them into code. BST.java contains a binary tree which has all of these traversal methods to be implemented. Wherever you find root in the algorithm is when you are operating on the root of the current subtree. The only operation you will do for this lab is print the node. Tip: you may want to use helper methods when you are implementing recursive methods. This can help you structure your code nicely for the traversals.

Submission
In Submit mode, select "Submit for grading" when you are ready to turn in your assignme
 */

public class BST implements Tree<Integer> {

    private TreeNode<Integer> root;
    private int size;

    public class TreeNode<Integer> {
        public Integer element;
        public TreeNode<Integer> rightChild;
        public TreeNode<Integer> leftChild;

        /* TODO: finish this constructor
        *  Think: what needs to be initialized, there are three member variables */
        public TreeNode(Integer element) {
            this.element = element;
            this.rightChild = null;
            this.leftChild = null;
        }
    }

    //private int size;

    public BST() {
        this.root = null;
        size = 0;
    }

    public BST(Integer item) {
        super();
        insert(item);
    }

    /* TODO: Insert all of items into this tree */
    public BST(Integer[] items) {
        super();
        for (Integer item : items) {
            insert(item);
        }
    }

    /* Does a binary search.
    *  TODO: complete this method */

    @Override
    public boolean search(Integer item) {
        TreeNode<Integer> current = root;
        while (current != null) {
            if (current.element == item) {
                return true;
            }
            else if (current.element > item) {
                current = current.leftChild;
            }
            else {
                current = current.rightChild;
            }
        }
        return false;
    }

    /* Inserts item into tree, return false if item is already in tree.
    *  Order of the tree is: root.element > left.element &&
    *                        root.element < right.element
    *  TODO: complete this method
    */
    @Override
    public boolean insert(Integer item) {
        if (root == null) {
            root = new TreeNode<Integer>(item);
            size++;
            return true;
        }
        else {
            TreeNode<Integer> current = root;
            while (current != null) {
                if (current.element == item) {
                    return false;
                }
                else if (current.element > item) {
                    if (current.leftChild == null) {
                        current.leftChild = new TreeNode<Integer>(item);
                        size++;
                        return true;
                    }
                    else {
                        current = current.leftChild;
                    }
                }
                else {
                    if (current.rightChild == null) {
                        current.rightChild = new TreeNode<Integer>(item);
                        size++;
                        return true;
                    }
                    else {
                        current = current.rightChild;
                    }
                }
            }
        }
        return false;
    }

    // for the next lab
//    @Override
//    public boolean remove(Integer item) {
//        return false;
//    }

    /* Getter method for the size of the tree
    *  TODO: complete this method
    */
    @Override
    public int size() {
        return size;
    }

    /* Does an inorder traversal of the tree, printing each visited node
    *  TODO: Complete this method
    */
    @Override
    public void inorder() {
        inorder(root);
    }

    public void inorder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        inorder(root.leftChild);
        System.out.print(root.element + " ");
        inorder(root.rightChild);
    }

    /* Does a postorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void postorder() {
        postorder(root);
    }

    public void postorder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        postorder(root.leftChild);
        postorder(root.rightChild);
        System.out.print(root.element + " ");
    }

    /* Does a preorder traversal of the tree, printing each visited node
     *  TODO: Complete this method
     */
    @Override
    public void preorder() {
        preorder(root);
    }

    public void preorder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.element + " ");
        preorder(root.leftChild);
        preorder(root.rightChild);


    }

    /* Prints true on empty tree, false otherwise
     *  TODO: Complete this method
     */
    @Override
    public boolean isEmpty() {
        if (root == null) {
            return true;
        }
        return false;
    }

    /* Returns the root node of the tree */
    public TreeNode<Integer> getRoot() {
        return root;
    }
}
