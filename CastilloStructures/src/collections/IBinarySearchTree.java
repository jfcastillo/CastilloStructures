package collections;

import java.util.ArrayList;

public interface IBinarySearchTree <T> {
	void insert(T element);
	void delete (T element) throws NonExistentElement;
	T search (T element);
	boolean isEmpty();
	ArrayList<T> inOrder();
}
