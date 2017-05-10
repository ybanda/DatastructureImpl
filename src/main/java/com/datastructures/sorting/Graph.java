package com.datastructures.sorting;
import java.util.HashMap;
import java.util.TreeSet;

public class Graph {
	
	private HashMap<Vertex, TreeSet<Vertex>> myAdjList;
	
	private HashMap<String, Vertex> myVertices;
	
	private static final TreeSet<Vertex> EMPTY_SET = new TreeSet<Vertex>();
	
	private int myNumVertices;
	
	private int myNumEdges;

	/**
	 * Construct empty Graph
	 */
	public Graph() {
	
		myAdjList = new HashMap<Vertex, TreeSet<Vertex>>();
		
		myVertices = new HashMap<String, Vertex>();
		
		myNumVertices = myNumEdges = 0;

	}

	/**
	 * Add a new vertex name with no neighbors (if vertex does not yet exist)
	 * 
	 * @param name
	 *            vertex to be added
	 */
	public Vertex addVertex(String name) {
		Vertex v;
		v = myVertices.get(name);
		if (v == null) {
			v = new Vertex(name);
			myVertices.put(name, v);
			myAdjList.put(v, new TreeSet<Vertex>());
			myNumVertices += 1;
		}
		return v;
	}

	/**
	 * Returns the Vertex matching v
	 * @param name a String name of a Vertex that may be in
	 * this Graph
	 * @return the Vertex with a name that matches v or null
	 * if no such Vertex exists in this Graph
	 */
	public Vertex getVertex(String name) {
		return myVertices.get(name);
	}

	/**
	 * Returns true iff v is in this Graph, false otherwise
	 * @param name a String name of a Vertex that may be in
	 * this Graph
	 * @return true iff v is in this Graph
	 */
	public boolean hasVertex(String name) {
		return myVertices.containsKey(name);
	}

	/**
	 * Is from-to, an edge in this Graph. The graph is 
	 * undirected so the order of from and to does not
	 * matter.
	 * @param from the name of the first Vertex
	 * @param to the name of the second Vertex
	 * @return true iff from-to exists in this Graph
	 */
	public boolean hasEdge(String from, String to) {

		if (!hasVertex(from) || !hasVertex(to))
			return false;
		return myAdjList.get(myVertices.get(from)).contains(myVertices.get(to));
	}
	
	/**
	 * Add to to from's set of neighbors, and add from to to's
	 * set of neighbors. Does not add an edge if another edge
	 * already exists
	 * @param from the name of the first Vertex
	 * @param to the name of the second Vertex
	 */
	public void addEdge(String from, String to) {
		Vertex v, w;
		if (hasEdge(from, to))
			return;
		myNumEdges += 1;
		if ((v = getVertex(from)) == null)
			v = addVertex(from);
		if ((w = getVertex(to)) == null)
			w = addVertex(to);
		myAdjList.get(v).add(w);
		myAdjList.get(w).add(v);
	}

	/**
	 * Return an iterator over the neighbors of Vertex named v
	 * @param name the String name of a Vertex
	 * @return an Iterator over Vertices that are adjacent
	 * to the Vertex named v, empty set if v is not in graph
	 */
	public Iterable<Vertex> adjacentTo(String name) {
		if (!hasVertex(name))
			return EMPTY_SET;
		return myAdjList.get(getVertex(name));
	}

	/**
	 * Return an iterator over the neighbors of Vertex v
	 * @param v the Vertex
	 * @return an Iterator over Vertices that are adjacent
	 * to the Vertex v, empty set if v is not in graph
	 */
	public Iterable<Vertex> adjacentTo(Vertex v) {
		if (!myAdjList.containsKey(v))
			return EMPTY_SET;
		return myAdjList.get(v);
	}

	/**
	 * Returns an Iterator over all Vertices in this Graph
	 * @return an Iterator over all Vertices in this Graph
	 */
	public Iterable<Vertex> getVertices() {
		return myVertices.values();
	}

	public int numVertices()
	{
		return myNumVertices;
	}
	
	public int numEdges()
	{
		return myNumEdges;
	}

	/*
	 * Returns adjacency-list representation of graph
	 */
	public String toString() {
		String s = "";
		for (Vertex v : myVertices.values()) {
			s += v + ": ";
			for (Vertex w : myAdjList.get(v)) {
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}

	private String escapedVersion(String s) {
		return "\'"+s+"\'";

	}

/*	public void outputGDF(String fileName)
    {
    	HashMap<Vertex, String> idToName = new HashMap<Vertex, String>();
    	 try {
			FileWriter out = new FileWriter(fileName);
			int count = 0;
			out.write("nodedef> name,label,style,distance INTEGER\n");
			// write vertices
			for (Vertex v: myVertices.values())
			{
				String id = "v"+ count++;
				idToName.put(v, id);
				out.write(id + "," + escapedVersion(v.name));
				out.write(",6,"+v.distance+"\n");
			}
			out.write("edgedef> node1,node2,color\n");
			// write edges
		    for (Vertex v : myVertices.values())
		    	for (Vertex w : myAdjList.get(v))  
		    	if (v.compareTo(w) < 0)
		    	{
		    		out.write(idToName.get(v)+","+ 
		    				idToName.get(w) + ",");
		    		if (v.predecessor == w || 
		    				w.predecessor == v)
		    			out.write("blue");
		    		else	
		    			out.write("gray");
		    		out.write("\n");
		    	}
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	 
    }*/

	public static void main(String[] args) {
		Graph G = new Graph();
		G.addEdge("A", "B");
		G.addEdge("A", "C");
		G.addEdge("C", "D");
		G.addEdge("D", "E");
		G.addEdge("D", "G");
		G.addEdge("E", "G");
		G.addVertex("H");
		System.out.println(G.escapedVersion("Bacon, Kevin"));
		// print out graph
		System.out.println(G);

		// print out graph again by iterating over vertices and edges
		for (Vertex v : G.getVertices()) {
			System.out.print(v + ": ");
			for (Vertex w : G.adjacentTo(v.name)) {
				System.out.print(w + " ");
			}
			System.out.println();
		}
	//	G.outputGDF("graph.gdf");
	}
	class Vertex implements Comparable<Vertex> {
		/**
		 * label for Vertex
		 */
		public String name;  
		/**
		 * length of shortest path from source
		 */
		public int distance; 
		/**
		 * previous vertex on path from sourxe
		 */
		public Vertex predecessor; // previous vertex
		
		/**
		 * a measure of the structural importance of a vertex.
		 * The value should initially be set to zero. A higher
		 * centrality score should mean a Vertex is more central.
		 */
		public double centrality;
		/**
		 * Infinite distance indicates that there is no path
		 * from the source to this vertex
		 */
		public static final int INFINITY = Integer.MAX_VALUE;

		public Vertex(String v)
		{
			name = v;
			distance = INFINITY; // start as infinity away
			predecessor = null;
			centrality = 0.0;
		}

		/**
		 * The name of the Vertex is assumed to be unique, so it
		 * is used as a HashCode
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		public int hashCode()
		{
			return name.hashCode();
		}
		
		public String toString()
		{ 
			return name;
		}
		/**
		 * Compare on the basis of distance from source first and 
		 * then lexicographically
		 */
		public int compareTo(Vertex other)
		{
			int diff = distance - other.distance;
			if (diff != 0)
				return diff;
			else
				return name.compareTo(other.name);
		}
	}
}
