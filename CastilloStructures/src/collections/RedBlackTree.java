package collections;

public class RedBlackTree<T  extends Comparable<T>> implements JRedBlackTree<T> {

	NodeRBT<T> root;
	NodeRBT<T> node;
	
	
	public RedBlackTree() {
		
		node= new NodeRBT<>();
		root=node;
		root.setFather(node);
	}
	

	public NodeRBT<T> getRoot() {
		return root;
	}


	public void setRoot(NodeRBT<T> root) {
		this.root = root;
	}
	
	


	public void leftRotate(NodeRBT<T> x ) {
		
		NodeRBT<T>y=x.rightSon;
		x.rightSon=y.leftSon;
		if(y.leftSon!=null) {
			y.changeLeftSon(x);
			y.setFather(x.father);
			
		}if(x.father==null) {
			
			root=y;
		}else if(x==x.father.leftSon) {
			x.father.leftSon=y;
		}else {
			x.father.rightSon=y;
			y.leftSon=x;
			x.father=y;
		}
		
		
		
	}
	
	
	
//	public boolean isRedBlackTree() {
//		boolean is=false;
//		
//		if(rootBlack()&& sonRed(root.getLeftSon(),root.getRightSon())) {
//			is=true;
//		}
//		
//		
//		return is;
//		
//	}
	
//	public boolean rootBlack() {
//		
//	return root.getColour().equals(Node.BLACK)?true:false;	
//	}
//	
//	public boolean sonRed(Node<T>  left, Node<T> right) {
//		boolean is=false;
//		if(left!=null&&right!=null) {
//		if((right.getColour().equals(Node.RED)&&left.getColour().equals(Node.BLACK))||(right.getColour().equals(Node.RED)&& left.getColour().equals(Node.BLACK))||( right.getColour().equals(Node.RED)&&left.getColour().equals(Node.RED)||( right.getColour().equals(Node.BLACK)&&left.getColour().equals(Node.BLACK)))) {
//			is=sonRed(left.getRightSon(),left.getRightSon())&&sonRed(right.getRightSon(),right.getLeftSon())==true?true:false;
//			
//		}}
//		return is;
//		
//	}


	@Override
	public void insert(NodeRBT<T> son) {
		NodeRBT<T> son1=node;
		NodeRBT<T> son2= root;
		while(son2.getElement()!=null) {
			son1=son2;
			if(son.compareTo(son1)<0) 
			{
				son2=son1.getLeftSon();
			}else {
				son2=son1.getRightSon();
			}
		}
		son.setFather(son1);
		if(son1==node) 
		{
			root=son;
		}else {
			if(son.compareTo(son1)<0) {
				son1.setLeftSon(son);
			}else {
				son1.setRightSon(son);
			}
		}
		
		son.setLeftSon(node);
		son.setRightSon(node);
		fixUpInsert(son);
		
	}
public void rightRotate(NodeRBT<T> son) {
	NodeRBT<T>son1 = son.getLeftSon();
	son.setLeftSon(son1.getRightSon());
	son1.getRightSon().setFather(son);
	son1.setFather(son.getFather());
	if(son.getFather() == node) {
		root = son1;
	}else {
		if(son == son.getFather().getRightSon()) {
			son.getFather().setRightSon(son1);
		}else {
			son.getFather().setLeftSon(son1);
		}
	}
	son1.setRightSon(son);
	son.setFather(son1);
}

	
	public void fixUpInsert(NodeRBT<T> son) {
		NodeRBT<T> son1=null;
		while(son.getFather().getColour().equals(NodeRBT.RED)) {
			if(son.getFather() == son.getFather().getFather().getLeftSon()) {
				son1 = son.getFather().getFather().getRightSon();
				if(son1.getColour().equals(NodeRBT.RED)) {
					son.getFather().setColour(NodeRBT.BLACK);
					son1.setColour(NodeRBT.BLACK);
					son.getFather().getFather().setColour(NodeRBT.RED);
					son = son.getFather().getFather();
				}else {
					if(son == son.getFather().getRightSon()) {
						son = son.getFather();
						leftRotate(son);
					}
					son.getFather().setColour(NodeRBT.BLACK);
					son.getFather().getFather().setColour(NodeRBT.RED);
					rightRotate(son.getFather().getFather());
				}
			}else {
				son1 = son.getFather().getFather().getLeft();
				if(son1.getColour().equals(NodeRBT.RED)) {
					son.getFather().setColour(NodeRBT.BLACK);
					son1.setColour(NodeRBT.BLACK);
					son.getFather().getFather().setColour(NodeRBT.RED);
					son = son.getFather().getFather();
				}else {
					if(son == son.getFather().getLeftSon()) {
						son = son.getFather();
						rightRotate(son);
					}
					son.getFather().setColour(NodeRBT.BLACK);
					son.getFather().getFather().setColour(NodeRBT.RED);
					leftRotate(son.getFather().getFather());
				}
			}
		}
		root.setColour(NodeRBT.BLACK);
	}

	@Override
	public NodeRBT<T> search(NodeRBT<T> son, T element) {
		if(son == node || son.getElement().compareTo(element) == 0) {
			return son;
		}
		if(son.getElement().compareTo(element)>0) {
			return search(son.getLeftSon(), element);
		}else {
			return search(son.getRightSon(), element);
		}
		
	}


	@Override
	public NodeRBT<T> min(NodeRBT<T> son) {
		if(son != node) {
			while(son.getLeftSon() != node) {
				son = son.getLeft();
			}
			
		}
		return son;
	}


	@Override
	public NodeRBT<T> max(NodeRBT<T> son) {
		if(son != node) {
			while(son.getRightSon() != node) {
				son = son.getRightSon();
			}
			
		}
		return node;
	}


	@Override
	public NodeRBT<T> successor(NodeRBT<T> son) {
		if(node.getRightSon() != null) {
			return min(node.getRightSon());
		}
		NodeRBT<T> son1 = node.getFather();
		while(son1 != null && node == son1.getRightSon()) {
			node = son1;
			son1 = son1.getFather();
		}
		return son1;
	}


	@Override
	public NodeRBT<T> predecessor(T key) {
		if(node.getLeft() != null) {
			return max(node.getLeft());
		}
		NodeRBT<T>son1  = node.getFather();
		while(son1 != null && node == son1.getLeft()) {
			node = son1;
			son1 = son1.getFather();
		}
		return son1;
	}


	@Override
	public void delete(NodeRBT<T> son) {
		NodeRBT<T> son1=null;
		NodeRBT<T> son2;
		if(son.getLeftSon() == node || son.getRightSon() == node) {
			son1 = son;
		}else {
			son = successor(son);
		}
		if(son1.getLeftSon() != node) {
			son2 = son1.getLeft();
		}else {
			son2 = son1.getRightSon();
		}
		son2.setFather(son1.getFather());
		if(son1.getFather() == node) {
			root = son2;
		}else {
			if(son1 == son1.getFather().getLeft()) {
				son1.getFather().setLeftSon(son2);
			}else {
				son1.getFather().setRightSon(son2);
			}
		}
		if(son1 != son) {
			son.setElement(son1.getElement());
		}
		if(son1.getColour() == NodeRBT.BLACK) {
			deleteFixUp(son2);
		}
	}
	
	private void deleteFixUp(NodeRBT<T> son) {
		NodeRBT<T> son1;
		while(root != son && son.getColour() == NodeRBT.BLACK) {
			if(son == son.getFather().getLeftSon()) {
				son1 = son.getFather().getRightSon();
				if(son.getColour() == NodeRBT.RED) {
					son1.setColour(NodeRBT.BLACK);
					son.getFather().setColour(NodeRBT.RED);
					leftRotate(son);
					son1 = son.getFather().getRightSon();
				}
				if(son1.getLeft().getColour() == NodeRBT.BLACK && son1.getRightSon().getColour() == NodeRBT.BLACK) {
					son1.setColour(NodeRBT.RED);
					son = son.getFather();
				}else {
					if(son1.getRightSon().getColour() == NodeRBT.BLACK) {
						son1.getLeftSon().setColour(NodeRBT.BLACK);
						son.setColour(NodeRBT.RED);
						rightRotate(son);
						son = son.getFather();
					}
					son1.setColour(son.getFather().getColour());
					son1.getFather().setColour(NodeRBT.BLACK);
					son1.getRightSon().setColour(NodeRBT.BLACK);
					leftRotate(son.getFather());
					son = root;
				}
			}else {
				son1 = son.getFather().getLeftSon();
				if(son1.getColour() == NodeRBT.RED) {
					son1.setColour(NodeRBT.BLACK);
					son.getFather().setColour(NodeRBT.RED);
					rightRotate(son);
					son1 = son.getFather().getLeft();
				}
				if(son1.getLeftSon().getColour() == NodeRBT.BLACK && son1.getRightSon().getColour() == NodeRBT.BLACK) {
				son1.setColour(NodeRBT.RED);
					son = son.getFather();
				}else {
					if(son1.getLeftSon().getColour() == NodeRBT.BLACK) {
						son1.getRightSon().setColour(NodeRBT.BLACK);
						son1.setColour(NodeRBT.RED);
						leftRotate(son1);
						son1 = son.getFather();
					}
					son1.setColour(son.getFather().getColour());
					son.getFather().setColour(NodeRBT.BLACK);
					son1.getLeft().setColour(NodeRBT.BLACK);
					rightRotate(son.getFather());
					son = root;
				}
			}
		}son.setColour(NodeRBT.BLACK);
	}
		



	

}