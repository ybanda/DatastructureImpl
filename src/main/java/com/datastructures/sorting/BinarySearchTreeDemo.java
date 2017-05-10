package com.datastructures.sorting;
/**
 * Represents a node in the Binary Search Tree.
 */
class Node<T> {
  //The value present in the node.
  public int value;

  //The reference to the left subtree.
  public Node left;

  //The reference to the right subtree.
  public Node right;

  public Node(int value) {
    this.value = value;
  }

}

/**
 * Represents the Binary Search Tree.
 */
 class BinarySearch {

  //Refrence for the root of the tree.
  public Node root;

  public BinarySearch insert(int value) {
    Node node = new Node<>(value);

    if (root == null) {
      root = node;
      return this;
    }

    insertRec(root, node);
    return this;
  }

  private void insertRec(Node latestRoot, Node node) {

    if (latestRoot.value > node.value) {

      if (latestRoot.left == null) {
        latestRoot.left = node;
        return;
      } else {
        insertRec(latestRoot.left, node);
      }
    } else {
      if (latestRoot.right == null) {
        latestRoot.right = node;
        return;
      } else {
        insertRec(latestRoot.right, node);
      }
    }
  }

  /**
   * Returns the minimum value in the Binary Search Tree.
   */
  public int findMinimum() {
    if (root == null) {
      return 0;
    }
    Node currNode = root;
    while (currNode.left != null) {
      currNode = currNode.left;
    }
    return currNode.value;
  }

  /**
   * Returns the maximum value in the Binary Search Tree
   */
  public int findMaximum() {
    if (root == null) {
      return 0;
    }

    Node currNode = root;
    while (currNode.right != null) {
      currNode = currNode.right;
    }
    return currNode.value;
  }

  /**
   * Printing the contents of the tree in an inorder way.
   */
  public void printInorder() {
    printInOrderRec(root);
    System.out.println("");
  }

  /**
   * Helper method to recursively print the contents in an inorder way
   */
  private void printInOrderRec(Node currRoot) {
    if (currRoot == null) {
      return;
    }
    printInOrderRec(currRoot.left);
    System.out.print(currRoot.value + ", ");
    printInOrderRec(currRoot.right);
  }

  /**
   * Printing the contents of the tree in a Preorder way.
   */
  public void printPreorder() {
    printPreOrderRec(root);
    System.out.println("");
  }

  /**
   * Helper method to recursively print the contents in a Preorder way
   */
  private void printPreOrderRec(Node currRoot) {
    if (currRoot == null) {
      return;
    }
    System.out.print(currRoot.value + ", ");
    printPreOrderRec(currRoot.left);
    printPreOrderRec(currRoot.right);
  }

  /**
   * Printing the contents of the tree in a Postorder way.
   */
  public void printPostorder() {
    printPostOrderRec(root);
    System.out.println("");
  }

  /**
   * Helper method to recursively print the contents in a Postorder way
   */
  private void printPostOrderRec(Node currRoot) {
    if (currRoot == null) {
      return;
    }
    printPostOrderRec(currRoot.left);
    printPostOrderRec(currRoot.right);
    System.out.print(currRoot.value + ", ");

  }
}

public class BinarySearchTreeDemo {

  public static void main(String[] args) {
    BinarySearch bst = new BinarySearch();
    Integer[] inte = {40,25,78,10,3,17,32,30,38,78,50,93};
    for (int i = 0; i < inte.length; i++) {
		System.out.print(inte[i]+" ,");
	}
    System.out.println();
    bst .insert(inte[0])
        .insert(inte[1])
        .insert(inte[2])
        .insert(inte[3])
        .insert(inte[4])
        .insert(inte[5])
        .insert(inte[6])
        .insert(inte[7])
        .insert(inte[8])
        .insert(inte[9])
        .insert(inte[10])
        .insert(inte[11]);
    System.out.println("Inorder traversal");
    bst.printInorder();

    System.out.println("Preorder Traversal");
    bst.printPreorder();

    System.out.println("Postorder Traversal");
    bst.printPostorder();

    System.out.println("The minimum value in the BST: " + bst.findMinimum());
    System.out.println("The maximum value in the BST: " + bst.findMaximum());

  }
}
