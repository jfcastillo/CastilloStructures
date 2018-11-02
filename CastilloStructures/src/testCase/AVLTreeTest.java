package testCase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import collections.AVLTree;
import collections.NonExistentElement;

class AVLTreeTest {
	private AVLTree<Integer> avl;
	public void setupStage1() {
		avl = new AVLTree<>();
		avl.insert(2);
		avl.insert(10);
		avl.insert(1);
		avl.insert(8);
		avl.insert(5);
		
	}

	@Test
	public void testInsert() {
		setupStage1();	
		avl.insert(4);
		avl.insert(3);
		int elements = 7;
		assertEquals(elements, avl.getWeight());
	}
	
	@Test
	public void testSearch() {
		setupStage1();
		int found = avl.search(5);
		
		assertEquals(5, found);
	}
	
	@Test
	public void testInOrden() {
		setupStage1();
		ArrayList<Integer> ar = avl.inOrder();
		int com = 0;
		for (int i = 1; i < ar.size(); i++) {
			assertTrue(ar.get(com) < ar.get(i));
			com++;
				
		}		
	}
	
	@Test
	public void testDelete() throws NonExistentElement {
		setupStage1();
		avl.delete(2);
		ArrayList<Integer> ar = avl.inOrder();
		System.out.println(avl.inOrder().toString());
//		for (int i = 0; i < ar.size(); i++) {
//			System.out.println(ar.get(i));
//		}
	}

}
