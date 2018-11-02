package collections;

import java.util.ArrayList;

public class AVLTree<T extends Comparable<T>> implements IAVLTree<T>{
	private NodeAVL<T> root;
	private int weight;

	public AVLTree() {
		root = null;
		weight = 0;
	}

	@Override
	public void insert(T element) {
		if (root == null) {
			root = new NodeAVL<T>(element);
			weight++;	
		}
		else {
			root.insert(root, element);
			weight++;
		}
	}

	@Override
	public void delete(T element) throws NonExistentElement {
		if (root != null) {
			root = root.delete(root, element);
			weight--;			
		}
		else {
			throw new NonExistentElement("The element doesn't exist");
		}
		
	}

	@Override
	public T search(T element) {
		return  (root != null) ? root.search(element) : null;
	}

	@Override
	public boolean isEmpty() {
		return (root == null) ? true : false;
	}

	@Override
	public ArrayList<T> inOrder() {
		ArrayList<T> elements = new ArrayList<>();
		if (root != null) {
			root.inorden(elements);
		}
		return elements;
	}

	public NodeAVL<T> getRoot() {
		return root;
	}

	public void setRoot(NodeAVL<T> root) {
		this.root = root;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	

}
