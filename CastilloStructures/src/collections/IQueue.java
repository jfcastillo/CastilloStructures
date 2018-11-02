package collections;

public interface IQueue<E> {
	
	public boolean isEmpty();
	public void enQueue(E element);
	public Node<E> deQueue();
	public Node<E> front();
	

}
