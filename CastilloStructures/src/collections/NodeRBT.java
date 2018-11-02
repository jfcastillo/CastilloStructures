package collections;


public class NodeRBT <E extends Comparable<E>> {
	
	public static final String RED="Red";
	public static final String BLACK="Black";
	
	E element;
	
	NodeRBT<E> father;
	NodeRBT<E> leftSon;
	NodeRBT<E> rightSon;
	String colour;
	//crea nodo color rojo no hoja
	public NodeRBT(E element ) {
		
		this.element=element;
		father=null;
		colour= RED;
		changeLeftSon(new NodeRBT<>());;
		changeRightSon(new NodeRBT<>());
		
	}
	public NodeRBT() {
		this.element=null;
		colour= BLACK;
		father=null;
	}
	
	
	public void changeRightSon(NodeRBT<E> son) {
		if(son!=null) {
			son.setFather(this);
			rightSon=son;
		}
		
	}
	public void changeLeftSon(NodeRBT<E> son) {
		if(son!=null) {
			son.setFather(this);
			leftSon=son;
		}
		
	}
	
	
	
 


	public NodeRBT<E> getFather() {
		return father;
	}
	public void setFather(NodeRBT<E> father) {
		this.father = father;
	}
	public NodeRBT<E> getLeftSon() {
		return leftSon;
	}
	public void setLeftSon(NodeRBT<E> leftSon) {
		this.leftSon = leftSon;
	}
	public NodeRBT<E> getRightSon() {
		return rightSon;
	}
	public void setRightSon(NodeRBT<E> rightSon) {
		this.rightSon = rightSon;
	}
	public NodeRBT<E> getLeft() {
		return leftSon;
	}






	public String getColour() {
		return colour;
	}






	public void setColour(String colour) {
		this.colour = colour;
	}






	public E getElement() {
		return element;
	}




	public void setElement(E element) {
		this.element = element;
	}
	
	
	public NodeRBT<E> getUncle(){
		NodeRBT<E> uncle=null;
		NodeRBT<E> grandFather=father.getFather();
		if(father!=null&&grandFather!=null) {
			if(grandFather.isRigthSon(father)==1) {
				uncle=grandFather.leftSon;
			}else {
				uncle=grandFather.rightSon;
			}
		}
		return uncle;
		
	}
		
		public int isRigthSon(NodeRBT<E> node) {
			int is=0;
			if(node==rightSon) {
				is=1;
			}else {
				is=2;
			}
			
	return is;
		
		
		
		
		}
		
		
		
	
		
		public boolean isSheet() {
			boolean is=false;
			
			if(leftSon==null&&rightSon==null) {
				is=true;
			}
			
			return is;
		}
		
		public int compareTo(NodeRBT<E> o) {
			return element.compareTo(o.getElement());
		}
		
		
	
	
}
