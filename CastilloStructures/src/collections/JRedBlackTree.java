package collections;



public interface JRedBlackTree<T extends Comparable<T>> {
	
	public void insert(NodeRBT<T>son);
	public NodeRBT<T> search(NodeRBT<T>son,T element);
	public NodeRBT<T> min(NodeRBT<T> node);
	public NodeRBT<T> max(NodeRBT<T> node);
	public NodeRBT<T> successor(NodeRBT<T> son);
	public NodeRBT<T> predecessor(T key);
	public void delete(NodeRBT<T> son);
	
	

}
