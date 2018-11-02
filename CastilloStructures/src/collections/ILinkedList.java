package collections;

public interface ILinkedList<T> {	
	void add(T elem);
	void remove(T elem);
	int size();
	boolean exist(T elem);
	T get(int pos);
	boolean isEmpty();
	T search(T elem);
	
}
