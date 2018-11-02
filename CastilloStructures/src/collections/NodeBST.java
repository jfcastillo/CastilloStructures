package collections;

import java.util.ArrayList;

public class NodeBST <T extends Comparable<T>>{
	
	private T element;
	
	private NodeBST<T> left;
	private NodeBST<T> right;

	public NodeBST(T element) {
		this.element = element;
		left = null;
		right = null;		
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public NodeBST<T> getLeft() {
		return left;
	}

	public void setLeft(NodeBST<T> left) {
		this.left = left;
	}

	public NodeBST<T> getRight() {
		return right;
	}

	public void setRight(NodeBST<T> rigth) {
		this.right = rigth;
	}

	public void insert(T elementToAdd) {
		int compare = element.compareTo(elementToAdd);
		if (compare == 0) {
//			if (left == null) {
//				left = new NodeBST<T>(element);				
//			}
//			else {
//				left.insert(element);
//			}
			System.out.println("El elemento ya existe");
		}
		else if (compare > 0) {
			if (left == null) {
				left = new NodeBST<T>(elementToAdd);				
			}
			else {
				left.insert(elementToAdd);
			}
		}
		else {
			if (right == null) {
				right = new NodeBST<T>(elementToAdd);
			}
			else {
				right.insert(elementToAdd);
			}
		}
	}
	
	public NodeBST<T> delete(T element) throws NonExistentElement{
		int result =  this.element.compareTo(element);
		if (result == 0) {
			if (left == null) {
				return right;
			}
			else if (right == null) {
				return left;
			}
				
			else {
				element = left.getHigher();
				left = left.delete(element);
				return this;
			}
			
		}
		else if (result > 0) {
			if (left == null) {
				throw new NonExistentElement("The element doesn't exist");				
			}
			else {
				left = left.delete(element);
				return this;
			}
			
		}
		else {
			if (right == null) {
				throw new NonExistentElement("The element doesn't exist");				
			}
			else {
				right = right.delete(element);
				return this;
			}
		}
	}
	public T search(T elementToSearch) {
		int result = element.compareTo(elementToSearch);
		if (result == 0) {
			return element;
		}
		else if(result > 0) {
			return (left != null) ? left.search(elementToSearch) : null;
		}
		else {
			return (right != null) ? right.search(elementToSearch) : null;
		}
	}
	public ArrayList<T> inorden(ArrayList<T> elements )
    {
       
        if( left != null ) {
        	left.inorden( elements );
        }
//        System.out.println(element);
        elements.add( element );
        
        if( right != null ) {
        	right.inorden( elements );
        }
        return elements;
    }
	
	public NodeBST<T> higherElement(){
		return (right == null) ? this : right.higherElement();
	}
	public NodeBST<T> lessElement(){
		return (left == null) ? this : left.lessElement();
	}
	public T getHigher() {
		NodeBST<T> node = higherElement();
		return (node == null) ? null : node.getElement();
	}
	public T getLess() {
		NodeBST<T> node = lessElement();
		return (node == null) ? null : node.getElement();
	}
}
