package validBinarySearchTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ValidBinarySearchTree {

	public class Node {
		Node leftChild;
		Node rightChild;
		int key;

		Node(int key) {
			this.leftChild = null;
			this.rightChild = null;
			this.key = key;
		}

	}
	Node root;

	static int maximumValue = Integer.MAX_VALUE;
	static int minimumValue = Integer.MIN_VALUE;
	public void addNode(int key) {
		Node newNode = new Node(key);
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}

				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}

			}
		}
	}
	
	public boolean checkIfTreeIsBinarySearchTree(Node node)
	{
		return isBST(node, minimumValue, maximumValue);
	}
	
	public boolean isBST(Node node,int min, int max)
	{
		if(node==null)
		{
			return true;
		}
		//for tree to be BST its node should not breach min and max constraints
		if(node.key<min || node.key>max)
		{
			return false;
		}
		
		//check recursively for the left and right child
		return isBST(node.leftChild,min,node.key-1) && isBST(node.rightChild, node.key+1, max);
		
	}

	public static void main(String args[]) throws Exception {
	       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	       

	

	      
	        bufferedReader.close();
	     
	}
}
