package collections;

public class HashTable<K,V> implements IHashTable<K,V> {
	//Prime number used to the hash table size and his function
	public static final int INITIAL_SIZE = 100003;
	private int length;
	private int size;
	private long amountOfElements;
	private List<HashEntry<K, V>> [] entries;
//	private HashEntry[] entries;
//	private ILinkedList<T>[] entries;

	public HashTable() {
		size = INITIAL_SIZE;
		length = 0;
		entries = new List[size];
		createTable();
	}

	@Override
	public void createTable() {		
		for (int i = 0; i < entries.length; i++) {
			entries [i] = new List<>(); 
		}
		
		
//		entries = new List<>();
//		entries = new HashEntry [size];
		
	}

	@Override
	public boolean isEmpty() {
		
		return entries[0] == null;
	}

	/**
	 * Determines the number of items in the table.
	 */
	@Override
	public long tableLength() {
		return length;
	}

	@Override
	public void tableInsert(K key, V newItem) {
		int index = hashFunction(key);
		HashEntry<K, V> entry = new HashEntry<K, V>(key, newItem);		
		entries [hashFunction(key)].add(entry); 
//		entries[hashFunction(key)] = new HashEntry<K,V>(key, newItem);
		length++;
		
	}
	public int hashFunction(K key) {
		return (Integer)key%INITIAL_SIZE;
	}

	@Override
	public void tableDelete(K searchKey) {
		int index = hashFunction(searchKey);
//		if (entries[index].getKey() == searchKey) {
//			entries[index] = null;
//			length--;
//		}
		
	}

	@Override
	public List<HashEntry<K, V>> tableRetrieve(K searchKey) {
		int index = hashFunction(searchKey);
		List<HashEntry<K, V>> valueFound = entries[index];
		
//		if (valueFound.ge == searchKey) {
//			ret = entries[index];
//		}		
		return valueFound;
	}

	/**
	 * Return the size of the hash table
	 */
	@Override
	public long size() {		
		return size;
	}

}
