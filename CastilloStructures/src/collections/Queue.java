package collections;

public class Queue<T> implements IQueue<T> {

	private Node<T> first;
	private Node<T> last;
	private int size;

	public Queue() {
		first = null;
		last = null;
		size = 0;

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first == null;
	}

	public T peek() {
		T p = null;
		if (isEmpty()) {
			p = first.getInfo();
		}
		return p;
	}

	@Override
	public void enQueue(T element) {
		Node<T> oLast = new Node(element);

		if (isEmpty()) {
			first = oLast;
		} else {
			last.setNext(oLast);
		}

		last = oLast;
		size++;
	}

	@Override
	public Node<T> deQueue() {

		Node<T> retu = new Node<T>(first.getInfo());

		first = first.getNext();
		size--;

		return retu;

	}

	@Override
	public Node<T> front() {
		return first;
	}

}
