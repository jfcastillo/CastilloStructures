package testCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import collections.BinarySearchTree;

class BinarySearchTreeTest {
	private BinarySearchTree<Integer> bst;
	
	public void setupStage1() {
		bst = new BinarySearchTree<>();
		bst.insert(10);
		bst.insert(2);
		bst.insert(8);
		bst.insert(5);
	}
	
	public void testInsert() {
		setupStage1();
		bst.insert(3);
		bst.insert(1);
		int elements = 6;
		assertEquals(6, bst.getWeight());
	}

	

}
