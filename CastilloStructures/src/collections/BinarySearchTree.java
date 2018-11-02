package collections;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T>{
	
	private NodeBST<T> root;
	private int weight;

	public BinarySearchTree() {
		root = null;
		weight = 0;
	}



	@Override
	public void insert(T element) {
		if (root == null) {
			root = new NodeBST<T>(element);
			
		}
		else {
			root.insert(element);
			
		}
		weight++;
	}

	@Override
	public void delete(T element) throws NonExistentElement {
		if (root != null) {
			root = root.delete(element);
			weight--;			
		}
		else {
			throw new NonExistentElement("The element doesn't exist");
		}
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (root == null) ? true : false;
	}

	public NodeBST<T> getRoot() {
		return root;
	}

	public void setRoot(NodeBST<T> root) {
		this.root = root;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public T search(T element) {
		return  (root != null) ? root.search(element) : null;
		
	}

	@Override
	public ArrayList<T> inOrder() {
		ArrayList<T> elements = new ArrayList<>();
		if (root != null) {
			root.inorden(elements);
		}
		return elements;
	}
	
	

}
