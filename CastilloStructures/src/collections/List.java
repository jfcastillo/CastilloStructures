package collections;

public class List<T> implements ILinkedList<T>, IStack<T>{
	private Node<T> first;
	private int size;

	public List() {
		first = null;
		size = 0;		
	}

	/**
	 * Add an element at the end of the list
	 */	
	@Override
	public void add(T elem) {
		if (first == null) {
			first = new Node<T>(elem);
			size++;
		}
		else {
			Node<T> nodeAux = first;
			while (nodeAux.getNext() != null) {
				nodeAux = nodeAux.getNext();				
			}
			Node<T> nodeAdd = new Node<T>(elem);
			nodeAux.setNext(nodeAdd);
			size++;
		}

	}
//	@Override
//	public void add(int pos, T elem) {
//		int c = 0;
//		boolean r = false;
//		if (pos > size) {
//			r = false;
//		} else {
//			Node<T> nodeAux = first;
//			while (nodeAux.getNext() != null) {				
//			}
//		}		
//	}

	/**
	 * Search the element to remove
	 * and remove if it exist
	 */
	@Override
	public void remove(T elem) {
		if (exist(elem)) {
			if (first.getInfo() == elem) {
				first = first.getNext();
				size--;
			}
			else {
				Node aux = first;
				while (aux.getNext().getInfo() != elem) {
					aux = aux.getNext();					
				}
//				Node next = aux.getNext().getNext();
//				aux.setNext(next);
				aux.disconectNext();
				size--;
			}			
		}		
	}
	

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean exist(T elem) {
		Node aux = first;
		boolean exist = false;
		if (!isEmpty()) {
			while (aux != null && exist != true) {
				if (aux.getInfo() == elem) {
					exist = true;
				}
				else
				aux = aux.getNext();
				
			}
		}
		
		return exist;
	}	

	@Override
	public T get(int pos) {
		int c = 0;
		Node<T> nodo = null;
		Node<T> nodoReturn = null;
		if (pos >= 0 && pos<size) {
			if (pos == 0) {
				nodoReturn = first;
			}
			else {
				boolean exit = false;
				nodo = first;
//				while (nodo != null && !exit) {
//					if (pos == c) {
//						nodoReturn = nodo;
//						exit = true;
//					}
//					else {
//						nodo = nodo.getNext();
//						c++;
//					}					
//				}
				for (int i = 0; i < pos; i++) {
					nodo = nodo.getNext();
				}
				nodoReturn = nodo;
			}
		}	
		
		return nodoReturn.getInfo();
	}

	@Override
	public boolean isEmpty() {
		return first==null;
	}
	

	@Override
	public void push(T elem) {
		Node node = new Node<T>(elem);
		if (isEmpty()) {
			first = node;
			size++;
		}
		else {
			node.setNext(first);
			first = node;
			size++;
		}
		
		
	}

	@Override
	public T top() {
		T r = null;
		try {
			if (isEmpty()) 
				throw new Exception("The stack is empty");			
			else
				r =  first.getInfo();
		} catch (Exception e) {
			e.getMessage();
		}
		return r;
		
	}

	@Override
	public void pop() {
		try {
			if (!isEmpty()) {
				first = first.getNext();
				size--;
			}
			else
				throw new Exception("The stack is empty");
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

	@Override
	public T search(T elem) {
		Node ret = null;
		for (Node<T> f = first; f != null ; f.getNext()) {
			if (f.getInfo().equals(elem)) {
				ret = f;
			}
		}
		return (T) ret.getInfo();
	}

	
//	public void leerTxt() throws IOException, ClassNotFoundException{
//		
//		
//		
//		FileInputStream fis =new FileInputStream( "./data/randomPlayer.txt" );
//		ObjectInputStream leerObjeto =  new ObjectInputStream( fis );
//		int i=0;
//		while(i<10000){
//			Player m  = (Player) leerObjeto.readObject();
//			addPlayerQueue(m);
//			addPlayersHash(m);
//			players2[i]=m;
//			i++;
//		}
//		
//		leerObjeto.close();	
//}
//	public void guardar() {
//		System.out.println("guardar");
////		File archivo = new File("baseDeDatos.dat");
//		player = cargarDatosJugador();
//		player.add(actualPlayer);
//		try {
//			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/baseDeDatos.dat"));
//			oos.writeObject(player);
//			oos.close();
//		} catch(IOException e) {
//			e.printStackTrace();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}	
//	
//	public ArrayList<Jugador> cargarDatosJugador() {
//		
//		try {
//			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/baseDeDatos.dat"));
//			player = (ArrayList<Jugador>)ois.readObject();
////			actualPlayer = (Jugador)ois.readObject();
//			ois.close();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		String listaJugadores = "";
//		for (int i = 0; i < player.size(); i++) {
//			String nickname = player.get(i).getNickname();
//			int puntaje = player.get(i).getPuntaje();
//			int nivel = player.get(i).getNivel();
//			listaJugadores += ("Nickname: "+nickname+" Puntaje: "+puntaje+" Nivel: "+nivel+"\n");
////			System.out.println(player.size());
////			System.out.println(listaJugadores);
//		}
//		return player;
//	}

}
