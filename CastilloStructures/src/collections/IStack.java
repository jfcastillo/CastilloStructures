package collections;

public interface IStack<T> {
	void push(T elem);
	T top();
	void pop();
	int size();
	boolean isEmpty();
}
