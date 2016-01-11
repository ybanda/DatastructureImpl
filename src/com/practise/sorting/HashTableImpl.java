package com.practise.sorting;


/**
 * 
 * @author Yashwanth
 *
 * @param <K>
 * @param <V>
 */
public class HashTableImpl<K,V> {

	private double loadFactor =0.75;

	public static class HashNode<K,V>
	{
		K key;

		/**
		 * @return the key
		 */
		public K getKey() {
			return key;
		}

		/**
		 * @param key the key to set
		 */
		public void setKey(K key) {
			this.key = key;
		}

		/**
		 * @return the value
		 */
		public V getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(V value) {
			this.value = value;
		}

		/**
		 * @return the next
		 */
		public HashNode<K, V> getNext() {
			return next;
		}

		/**
		 * @param next the next to set
		 */
		public void setNext(HashNode<K, V> next) {
			this.next = next;
		}

		V value;

		HashNode<K,V> next;
	}

	public HashNode[] table;

	private int count;

	public HashTableImpl()
	{
		table = new HashNode[10];

	}

	public HashTableImpl(int initialSize)
	{
		if (initialSize <= 0)
			throw new IllegalArgumentException("Illegal table size");
		table = new HashNode[initialSize];
	}

	private int hash(K key) {
		return (Math.abs(key.hashCode())) % table.length;
	}

	public void put(K key ,V value)
	{
		int bucket = hash(key);

		if(null!=key)
		{

			HashNode<K, V> list =	table[bucket];

			while(list!=null)
			{
				if(list.getKey().equals(key))
					break;

				list = list.getNext();
			}
			if(list!=null)
			{
				list.setValue(value);
			}
			else
			{
				if(count>=table.length*loadFactor)
				{
					resize();
					bucket = hash(key);
				}

				HashNode<K,V> node = new HashNode<K,V>();
				node.setKey(key);
				node.setValue(value);
				node.setNext(table[bucket]);
				table[bucket]=node;
				count++;

			}
		}
	}
	public V get(K key)
	{
		int bucket = hash(key);
		HashNode<K,V> list = table[bucket];
		while(list!=null)
		{
			
			
			if(list.getKey().equals(key))
				return list.getValue();
			list =list.getNext();
		}
		return null;
	}

	public void resize()
	{

	}

	public void remove(K key)
	{

	}
	public boolean containsKey(K key)
	{

		return true;
	}
	public int getSize()
	{
		return count;

	}
	public  void dump() {
		System.out.println();
		for (int i = 0; i < table.length; i++) {
			// Print out the location number and the list of
			// key/value pairs in this location.
			System.out.print(i + ":");
			HashNode<K,V> list = table[i]; // For traversing linked list number i.
			while (list!= null) {

				System.out.print("  (" + list.key + "," + list.value + ")");
				list = list.next;
			}
			System.out.println();
		}
	} // end dump()

	public static void main(String[] args)
	{
		HashTableImpl<String,String> node = new HashTableImpl<String,String>();

		node.put("12", "123");
		node.put("13", "123ssd2323");
		node.put("14", "1232AAAA3");
		node.put("a12", "12323QWQW");
		node.put("b13", "12323FFS");
		node.put("c14", "12323VVV");
		node.put("c24", "12323");
		node.put("b23", "123231111");
		node.put("a22", "123232222");
		node.put("aF1", "123233333");
		node.put("bF2", "12323---");
		node.put("cF3", "12323====");
		node.dump();
		System.out.println(
				"12=="+node.get("12")+"\n"
				+"13=="+node.get("13")+"\n"
				+"14=="+node.get("14")+"\n"+
				"b13=="+node.get("b13")+"\n"+
				"a12=="+node.get("a12")+"\n"+
				"c14=="+node.get("c14")+"\n"+
				"c24=="+node.get("c24")+"\n"+
				"b23=="+node.get("b23")+"\n"+
				"a22=="+node.get("a22")+"\n"+
				"aF1=="+node.get("aF1")+"\n"+
				"bF2=="+node.get("bF2")+"\n"
				+"cF3=="+node.get("cF3")+"\n");

	}


}
