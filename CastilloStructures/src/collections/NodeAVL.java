package collections;

import java.util.ArrayList;

public class NodeAVL<T extends Comparable<T>> {
	private T element;
	private NodeAVL<T> father;
	private NodeAVL<T> right;
	private NodeAVL<T> left;
	private int height;
	

	public NodeAVL(T element) {
		this.element = element;
		
		right = null;
		left = null;
	}


	public T getElement() {
		return element;
	}


	public void setElement(T element) {
		this.element = element;
	}


	public NodeAVL<T> getRight() {
		return right;
	}


	public void setRight(NodeAVL<T> right) {
		this.right = right;
	}


	public NodeAVL<T> getLeft() {
		return left;
	}


	public void setLeft(NodeAVL<T> left) {
		this.left = left;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}
	
	
	public NodeAVL<T> getFather() {
		return father;
	}


	public void setFather(NodeAVL<T> father) {
		this.father = father;
	}



	public int height(NodeAVL<T> node) {
		return node == null ? -1 : node.getHeight();
	}



	public NodeAVL<T> insert(NodeAVL<T> node,T elem) {
		if (node == null) {
			node = new NodeAVL<T>(elem);
		}
		
		else if (node.getElement().compareTo(elem) > 0) {
			node.left = insert(node.getLeft(), elem);
			if (height(node.getLeft()) - height(node.getRight()) == 2) {
				if (node.getElement().compareTo(elem) > 0) {
					node = rotateLeft(node);
				}
				else {
					node = doubleRotateLeft(node);
				}
			}
		}
		else if (node.getElement().compareTo(elem) < 0) {
			node.right = insert(node.getRight(), elem);
			if (height(node.getRight()) - height(node.getLeft()) == 2) {
				if (node.getElement().compareTo(elem) < 0) {
					node = rotateRight(node);
				}
				else {
					node = doubleRotateRight(node);
				}
			}
		}
		else if (node.getElement().compareTo(elem)== 0)  {
			
		}
		else {
			node.setHeight(max (height(node.getLeft()), height(node.getRight())) + 1);
		}
		return node;
	}
	public NodeAVL<T> doubleRotateLeft(NodeAVL<T> node) {
		node.setLeft(rotateRight(node.getLeft()));
		return rotateLeft(node);
	}


	public NodeAVL<T> doubleRotateRight(NodeAVL<T> node) {
		node.setRight(rotateLeft(node.getRight()));
		return rotateRight(node);
	}


	public NodeAVL<T> rotateRight(NodeAVL<T> node1) {

		
		NodeAVL<T> node2 = node1.getRight();
		
		node1.setRight(node2.getLeft());
		node2.setLeft(node1);
		
		node1.setHeight(max (height(node1.getLeft()), height(node1.getRight()))+1);
		
		node2.setHeight(max (height(node2.getRight()), node1.getHeight())+1);
		return node1;
	}
	public NodeAVL<T> rotateLeft(NodeAVL<T> node2){
		NodeAVL<T> node1 = node2.getLeft();
		node2.setLeft(node1.getRight());
		node1.setRight(node2);		
		node1.setHeight(max (height(node2.getLeft()) , height(node2.getRight()))+1);
		node2.setHeight(max (height(node1.getLeft()), node2.getHeight())+1);
		return node1;
	}
	public int max(int hl, int hr) {
		return hl > hr ? hl : hr;
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
	
//	public NodeAVL<T> minValueNode(NodeAVL<T> node){
//		NodeAVL<T> current = node;
//		while (current.getLeft() != null) {
//			current = current.getLeft();			
//		}
//		return current;
//	}
	public T getMinValue(NodeAVL<T> node)
    {
		NodeAVL current = node;  
		  
        /* loop down to find the leftmost leaf */
        while (current.left != null)  
        current = current.left;  
  
        return (T) current.getElement();
    }
	
//	public NodeAVL<T> delete(NodeAVL<T> node, T key) throws NonExistentElement{
//		int compare = this.getElement().compareTo(key);
//		if (compare > 0) {
//			if (left == null) {
//				throw new NonExistentElement("The element doesn't exist");				
//			}
//			else {
//				left = left.delete(left, key);
//				return this;
//			}
//		}
//		else if (compare < 0){
//			if (right == null) {
//				throw new NonExistentElement("The element doesn't exist");				
//			}
//			else {
//				right = right.delete(right, key);
//				return this;
//			}
//		}
//		else {
//			if ((left == null) || (right == null)) {
//				NodeAVL<T> temp = null;
//				if (temp == left) {
//					temp = right;
//				}
//				else {
//					temp = left;
//				}
//				
//				if (temp == null) {
//					temp = father;
//					father = null;
//				}
//				else
//					temp = father;
//			}
//			else {
//				NodeAVL<T> temp = minValueNode(right);
//				this.setElement(temp.getElement());
//				right = delete(right, temp.getElement());
//			}
//		}
//		if (father == null) {
//			return father;
//		}
//		
//	}
	
	 public NodeAVL<T> delete(NodeAVL<T> node, T key) throws NonExistentElement
	    {
	       
	        if (node == null) return null;
	         
	        int compare = this.getElement().compareTo(key);
			if (compare > 0) {
				if (left == null) {
					throw new NonExistentElement("The element doesn't exist");				
				}
				else {
					node.left = left.delete(node.left, key);
					return this;
				}
			}
			else if (compare < 0){
				if (right == null) {
					throw new NonExistentElement("The element doesn't exist");				
				}
				else {
					node.right = right.delete(node.right, key);
					return this;
				}
			}
	         
	        else 
	        {
	           
	            if (node.left == null)
	            {
	                node = node.right;
	            }
	            else if (node.right == null)
	            {
	                node = node.left;
	            }
	             
	            
	            else
	            {
	                T inorderSuccessorValue = getMinValue(node.right);
	                node.setElement(inorderSuccessorValue);
	                node.right = delete(node.right, inorderSuccessorValue);
	            }
	        }
	 
	        
	        if (node == null)
	        {
	            return null;
	        }
	         
	        
	        updateHeight(node);
	         
	        
	        int balance = getBalance(node);
	         
	        if (balance > 1) 
	        {
	            if (getBalance(node.left) >= 0) 
	            {
	                node = rotateRight(node);
	            }
	            else 
	            {
	                node.left = rotateLeft(node.left);
	                node = rotateRight(node);
	            }
	        }
	         
	        else if (balance < -1) 
	        {
	            if (getBalance(node.right) <= 0) 
	            {
	                node = rotateLeft(node);
	            }
	            else 
	            {
	                node.right = rotateRight(node.right);
	                node = rotateLeft(node);
	            }
	        }
	        return node;
	    }

	public int getBalance(NodeAVL<T> node) {
		if (node == null) {
			return 0;
		}
		int balance;

		balance = height(node.left) - height(node.right);

		return balance;
	}
	public void updateHeight(NodeAVL<T> node)
    {
        if (node == null) return;
         
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }
     
}
