package collections;

public class Node<T> {
	
	private Node<T> next;
	private T info;
	
	public Node(T elem){
		info = elem;
	}
	public boolean NodoEnlazadoSimple() {
		return true;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public void disconectNext() {
		next = next.next;
	}
	
}
