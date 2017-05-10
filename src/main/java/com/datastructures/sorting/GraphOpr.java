package com.datastructures.sorting;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class GraphOpr<T> {

  public static final int VISIT_COLOR_WHITE = 1;

  public static final int VISIT_COLOR_GREY = 2;

  public static final int VISIT_COLOR_BLACK = 3;

  private List<Vertex<T>> verticies;

  private List<Edge<T>> edges;

  private Vertex<T> rootVertex;

  public GraphOpr() {
    
	  verticies = new ArrayList<Vertex<T>>();
    
      edges = new ArrayList<Edge<T>>();
  }
  
public static void main(String[] args) {
	
	GraphOpr<String> grop = new GraphOpr<String>();
	
	Vertex<String> vertexA = new Vertex<String>("A");
	
	Vertex<String> vertexB = new Vertex<String>("B");
	
	vertexA.setData("Data VA");
	
	vertexB.setData("Data VB");
	
	Edge<String> edgeA = new Edge<String>(vertexA, vertexB);
	
	vertexA.addEdge(edgeA);
		
	grop.verticies.add(vertexA);
	
	grop.verticies.add(vertexA);
	
	grop.verticies.add(vertexB);
	
	grop.addEdge(grop.verticies.get(1), grop.verticies.get(2), 1);
	
	System.out.println(grop.toString());
}
  
  public boolean isEmpty() {
    return verticies.size() == 0;
  }

  public boolean addVertex(Vertex<T> v) {
    boolean added = false;
    if (verticies.contains(v) == false) {
      added = verticies.add(v);
    }
    return added;
  }

  public int size() {
    return verticies.size();
  }

  public Vertex<T> getRootVertex() {
    return rootVertex;
  }
  
  public void setRootVertex(Vertex<T> root)
  {
    this.rootVertex = root;
  
    if (verticies.contains(root) == false)
      this.addVertex(root);
  }

  public Vertex<T> getVertex(int n) {
    return verticies.get(n);
  }

  /**
   * Get the graph verticies
   * 
   * @return the graph verticies
   */
  public List<Vertex<T>> getVerticies() {
    return this.verticies;
  }
  public boolean addEdge(Vertex<T> from, Vertex<T> to, int cost) throws IllegalArgumentException {
    if (verticies.contains(from) == false)
      throw new IllegalArgumentException("from is not in graph");
    if (verticies.contains(to) == false)
      throw new IllegalArgumentException("to is not in graph");

    Edge<T> e = new Edge<T>(from, to, cost);
    if (from.findEdge(to) != null)
      return false;
    else {
      from.addEdge(e);
      to.addEdge(e);
      edges.add(e);
      return true;
    }
  }
  public boolean insertBiEdge(Vertex<T> from, Vertex<T> to, int cost)
      throws IllegalArgumentException {
    return addEdge(from, to, cost) && addEdge(to, from, cost);
  }

  /**
   * Get the graph edges
   * 
   * @return the graph edges
   */
  public List<Edge<T>> getEdges() {
    return this.edges;
  }

  /**
   * Remove a vertex from the graph
   * 
   * @param v
   *          the Vertex to remove
   * @return true if the Vertex was removed
   */
  public boolean removeVertex(Vertex<T> v) {
    if (!verticies.contains(v))
      return false;

    verticies.remove(v);
    if (v == rootVertex)
      rootVertex = null;

    // Remove the edges associated with v
    for (int n = 0; n < v.getOutgoingEdgeCount(); n++) {
      Edge<T> e = v.getOutgoingEdge(n);
      v.remove(e);
      Vertex<T> to = e.getTo();
      to.remove(e);
      edges.remove(e);
    }
    for (int n = 0; n < v.getIncomingEdgeCount(); n++) {
      Edge<T> e = v.getIncomingEdge(n);
      v.remove(e);
      Vertex<T> predecessor = e.getFrom();
      predecessor.remove(e);
    }
    return true;
  }

  /**
   * Remove an Edge<T> from the graph
   * 
   * @param from -
   *          the Edge<T> starting vertex
   * @param to -
   *          the Edge<T> ending vertex
   * @return true if the Edge<T> exists, false otherwise
   */
  public boolean removeEdge(Vertex<T> from, Vertex<T> to) {
    Edge<T> e = from.findEdge(to);
    if (e == null)
      return false;
    else {
      from.remove(e);
      to.remove(e);
      edges.remove(e);
      return true;
    }
  }

  /**
   * Clear the mark state of all verticies in the graph by calling clearMark()
   * on all verticies.
   * 
   * @see Vertex#clearMark()
   */
  public void clearMark() {
    for (Vertex<T> w : verticies)
      w.clearMark();
  }

  /**
   * Clear the mark state of all edges in the graph by calling clearMark() on
   * all edges.
   */
  public void clearEdges() {
    for (Edge<T> e : edges)
      e.clearMark();
  }

  /**
   * Perform a depth first serach using recursion.
   * 
   * @param v -
   *          the Vertex to start the search from
   * @param visitor -
   *          the vistor to inform prior to
   * @see Visitor#visit(Graph, Vertex)
   */
  public void depthFirstSearch(Vertex<T> v, final Visitor<T> visitor) {
    VisitorEX<T, RuntimeException> wrapper = new VisitorEX<T, RuntimeException>() {
      public void visit(GraphOpr<T> g, Vertex<T> v) throws RuntimeException {
        if (visitor != null)
          visitor.visit(g, v);
      }
    };
    this.depthFirstSearch(v, wrapper);
  }

  /**
   * Perform a depth first serach using recursion. The search may be cut short
   * if the visitor throws an exception.
   * 
   * @param <E>
   * 
   * @param v -
   *          the Vertex to start the search from
   * @param visitor -
   *          the vistor to inform prior to
   * @see Visitor#visit(Graph, Vertex)
   * @throws E
   *           if visitor.visit throws an exception
   */
  public <E extends Exception> void depthFirstSearch(Vertex<T> v, VisitorEX<T, E> visitor) throws E {
    if (visitor != null)
      visitor.visit(this, v);
    v.visit();
    for (int i = 0; i < v.getOutgoingEdgeCount(); i++) {
      Edge<T> e = v.getOutgoingEdge(i);
      if (!e.getTo().visited()) {
        depthFirstSearch(e.getTo(), visitor);
      }
    }
  }

  /**
   * Perform a breadth first search of this graph, starting at v.
   * 
   * @param v -
   *          the search starting point
   * @param visitor -
   *          the vistor whose vist method is called prior to visting a vertex.
   */
  public void breadthFirstSearch(Vertex<T> v, final Visitor<T> visitor) {
    VisitorEX<T, RuntimeException> wrapper = new VisitorEX<T, RuntimeException>() {
      public void visit(GraphOpr<T> g, Vertex<T> v) throws RuntimeException {
        if (visitor != null)
          visitor.visit(g, v);
      }
    };
    this.breadthFirstSearch(v, wrapper);
  }

  /**
   * Perform a breadth first search of this graph, starting at v. The vist may
   * be cut short if visitor throws an exception during a vist callback.
   * 
   * @param <E>
   * 
   * @param v -
   *          the search starting point
   * @param visitor -
   *          the vistor whose vist method is called prior to visting a vertex.
   * @throws E
   *           if vistor.visit throws an exception
   */
  public <E extends Exception> void breadthFirstSearch(Vertex<T> v, VisitorEX<T, E> visitor)
      throws E {
    LinkedList<Vertex<T>> q = new LinkedList<Vertex<T>>();

    q.add(v);
    if (visitor != null)
      visitor.visit(this, v);
    v.visit();
    while (q.isEmpty() == false) {
      v = q.removeFirst();
      for (int i = 0; i < v.getOutgoingEdgeCount(); i++) {
        Edge<T> e = v.getOutgoingEdge(i);
        Vertex<T> to = e.getTo();
        if (!to.visited()) {
          q.add(to);
          if (visitor != null)
            visitor.visit(this, to);
          to.visit();
        }
      }
    }
  }

  /**
   * Find the spanning tree using a DFS starting from v.
   * 
   * @param v -
   *          the vertex to start the search from
   * @param visitor -
   *          visitor invoked after each vertex is visited and an edge is added
   *          to the tree.
   */
  public void dfsSpanningTree(Vertex<T> v, DFSVisitor<T> visitor) {
    v.visit();
    if (visitor != null)
      visitor.visit(this, v);

    for (int i = 0; i < v.getOutgoingEdgeCount(); i++) {
      Edge<T> e = v.getOutgoingEdge(i);
      if (!e.getTo().visited()) {
        if (visitor != null)
          visitor.visit(this, v, e);
        e.mark();
        dfsSpanningTree(e.getTo(), visitor);
      }
    }
  }

  /**
   * Search the verticies for one with name.
   * 
   * @param name -
   *          the vertex name
   * @return the first vertex with a matching name, null if no matches are found
   */
  public Vertex<T> findVertexByName(String name) {
    Vertex<T> match = null;
    for (Vertex<T> v : verticies) {
      if (name.equals(v.getName())) {
        match = v;
        break;
      }
    }
    return match;
  }

  /**
   * Search the verticies for one with data.
   * 
   * @param data -
   *          the vertex data to match
   * @param compare -
   *          the comparator to perform the match
   * @return the first vertex with a matching data, null if no matches are found
   */
  public Vertex<T> findVertexByData(T data, Comparator<T> compare) {
    Vertex<T> match = null;
    for (Vertex<T> v : verticies) {
      if (compare.compare(data, v.getData()) == 0) {
        match = v;
        break;
      }
    }
    return match;
  }

  public Edge<T>[] findCycles() {
    ArrayList<Edge<T>> cycleEdges = new ArrayList<Edge<T>>();
    // Mark all verticies as white
    for (int n = 0; n < verticies.size(); n++) {
      Vertex<T> v = getVertex(n);
      v.setMarkState(VISIT_COLOR_WHITE);
    }
    for (int n = 0; n < verticies.size(); n++) {
      Vertex<T> v = getVertex(n);
      visit(v, cycleEdges);
    }

    Edge<T>[] cycles = new Edge[cycleEdges.size()];
    cycleEdges.toArray(cycles);
    return cycles;
  }

  private void visit(Vertex<T> v, ArrayList<Edge<T>> cycleEdges) {
    v.setMarkState(VISIT_COLOR_GREY);
    int count = v.getOutgoingEdgeCount();
    for (int n = 0; n < count; n++) {
      Edge<T> e = v.getOutgoingEdge(n);
      Vertex<T> u = e.getTo();
      if (u.getMarkState() == VISIT_COLOR_GREY) {
        // A cycle Edge<T>
        cycleEdges.add(e);
      } else if (u.getMarkState() == VISIT_COLOR_WHITE) {
        visit(u, cycleEdges);
      }
    }
    v.setMarkState(VISIT_COLOR_BLACK);
  }

  public String toString() {
    StringBuffer tmp = new StringBuffer("Graph[");
    for (Vertex<T> v : verticies)
      tmp.append(v);
    tmp.append(']');
    return tmp.toString();
  }

}
class Edge<T> {
  private Vertex<T> from;

  private Vertex<T> to;

  private int cost;

  private boolean mark;

  /**
   * Create a zero cost edge between from and to
   * 
   * @param from
   *          the starting vertex
   * @param to
   *          the ending vertex
   */
  public Edge(Vertex<T> from, Vertex<T> to) {
    this(from, to, 0);
  }

  /**
   * Create an edge between from and to with the given cost.
   * 
   * @param from
   *          the starting vertex
   * @param to
   *          the ending vertex
   * @param cost
   *          the cost of the edge
   */
  public Edge(Vertex<T> from, Vertex<T> to, int cost) {
    this.from = from;
    this.to = to;
    this.cost = cost;
    mark = false;
  }

  /**
   * Get the ending vertex
   * 
   * @return ending vertex
   */
  public Vertex<T> getTo() {
    return to;
  }

  /**
   * Get the starting vertex
   * 
   * @return starting vertex
   */
  public Vertex<T> getFrom() {
    return from;
  }

  /**
   * Get the cost of the edge
   * 
   * @return cost of the edge
   */
  public int getCost() {
    return cost;
  }

  /**
   * Set the mark flag of the edge
   * 
   */
  public void mark() {
    mark = true;
  }

  /**
   * Clear the edge mark flag
   * 
   */
  public void clearMark() {
    mark = false;
  }

  /**
   * Get the edge mark flag
   * 
   * @return edge mark flag
   */
  public boolean isMarked() {
    return mark;
  }

  /**
   * String rep of edge
   * 
   * @return string rep with from/to vertex names and cost
   */
  public String toString() {
    StringBuffer tmp = new StringBuffer("Edge[from: ");
    tmp.append(from.getName());
    tmp.append(",to: ");
    tmp.append(to.getName());
    tmp.append(", cost: ");
    tmp.append(cost);
    tmp.append("]");
    return tmp.toString();
  }
}


@SuppressWarnings("unchecked")
class Vertex<T> {
  private List<Edge<T>> incomingEdges;

  private List<Edge<T>> outgoingEdges;

  private String name;

  private boolean mark;

  private int markState;

  private T data;

  /**
   * Calls this(null, null).
   */
  public Vertex() {
    this(null, null);
  }

  /**
   * Create a vertex with the given name and no data
   * 
   * @param n
   */
  public Vertex(String n) {
    this(n, null);
  }

  /**
   * Create a Vertex with name n and given data
   * 
   * @param n -
   *          name of vertex
   * @param data -
   *          data associated with vertex
   */
  public Vertex(String n, T data) {
    incomingEdges = new ArrayList<Edge<T>>();
    outgoingEdges = new ArrayList<Edge<T>>();
    name = n;
    mark = false;
    this.data = data;
  }

  /**
   * @return the possibly null name of the vertex
   */
  public String getName() {
    return name;
  }

  /**
   * @return the possibly null data of the vertex
   */
  public T getData() {
    return this.data;
  }

  /**
   * @param data
   *          The data to set.
   */
  public void setData(T data) {
    this.data = data;
  }

  /**
   * Add an edge to the vertex. If edge.from is this vertex, its an outgoing
   * edge. If edge.to is this vertex, its an incoming edge. If neither from or
   * to is this vertex, the edge is not added.
   * 
   * @param e -
   *          the edge to add
   * @return true if the edge was added, false otherwise
   */
  public boolean addEdge(Edge<T> e) {
    if (e.getFrom() == this)
      outgoingEdges.add(e);
    else if (e.getTo() == this)
      incomingEdges.add(e);
    else
      return false;
    return true;
  }

  /**
   * Add an outgoing edge ending at to.
   * 
   * @param to -
   *          the destination vertex
   * @param cost
   *          the edge cost
   */
  public void addOutgoingEdge(Vertex<T> to, int cost) {
    Edge<T> out = new Edge<T>(this, to, cost);
    outgoingEdges.add(out);
  }

  /**
   * Add an incoming edge starting at from
   * 
   * @param from -
   *          the starting vertex
   * @param cost
   *          the edge cost
   */
  public void addIncomingEdge(Vertex<T> from, int cost) {
    Edge<T> out = new Edge<T>(this, from, cost);
    incomingEdges.add(out);
  }

  /**
   * Check the vertex for either an incoming or outgoing edge mathcing e.
   * 
   * @param e
   *          the edge to check
   * @return true it has an edge
   */
  public boolean hasEdge(Edge<T> e) {
    if (e.getFrom() == this)
      return incomingEdges.contains(e);
    else if (e.getTo() == this)
      return outgoingEdges.contains(e);
    else
      return false;
  }

  /**
   * Remove an edge from this vertex
   * 
   * @param e -
   *          the edge to remove
   * @return true if the edge was removed, false if the edge was not connected
   *         to this vertex
   */
  public boolean remove(Edge<T> e) {
    if (e.getFrom() == this)
      incomingEdges.remove(e);
    else if (e.getTo() == this)
      outgoingEdges.remove(e);
    else
      return false;
    return true;
  }

  /**
   * 
   * @return the count of incoming edges
   */
  public int getIncomingEdgeCount() {
    return incomingEdges.size();
  }

  /**
   * Get the ith incoming edge
   * 
   * @param i
   *          the index into incoming edges
   * @return ith incoming edge
   */
  public Edge<T> getIncomingEdge(int i) {
    return incomingEdges.get(i);
  }

  /**
   * Get the incoming edges
   * 
   * @return incoming edge list
   */
  public List getIncomingEdges() {
    return this.incomingEdges;
  }

  /**
   * 
   * @return the count of incoming edges
   */
  public int getOutgoingEdgeCount() {
    return outgoingEdges.size();
  }

  /**
   * Get the ith outgoing edge
   * 
   * @param i
   *          the index into outgoing edges
   * @return ith outgoing edge
   */
  public Edge<T> getOutgoingEdge(int i) {
    return outgoingEdges.get(i);
  }

  /**
   * Get the outgoing edges
   * 
   * @return outgoing edge list
   */
  public List getOutgoingEdges() {
    return this.outgoingEdges;
  }

  /**
   * Search the outgoing edges looking for an edge whose's edge.to == dest.
   * 
   * @param dest
   *          the destination
   * @return the outgoing edge going to dest if one exists, null otherwise.
   */
  public Edge<T> findEdge(Vertex<T> dest) {
    for (Edge<T> e : outgoingEdges) {
      if (e.getTo() == dest)
        return e;
    }
    return null;
  }

  /**
   * Search the outgoing edges for a match to e.
   * 
   * @param e -
   *          the edge to check
   * @return e if its a member of the outgoing edges, null otherwise.
   */
  public Edge<T> findEdge(Edge<T> e) {
    if (outgoingEdges.contains(e))
      return e;
    else
      return null;
  }

  /**
   * What is the cost from this vertext to the dest vertex.
   * 
   * @param dest -
   *          the destination vertex.
   * @return Return Integer.MAX_VALUE if we have no edge to dest, 0 if dest is
   *         this vertex, the cost of the outgoing edge otherwise.
   */
  public int cost(Vertex<T> dest) {
    if (dest == this)
      return 0;

    Edge<T> e = findEdge(dest);
    int cost = Integer.MAX_VALUE;
    if (e != null)
      cost = e.getCost();
    return cost;
  }

  /**
   * Is there an outgoing edge ending at dest.
   * 
   * @param dest -
   *          the vertex to check
   * @return true if there is an outgoing edge ending at vertex, false
   *         otherwise.
   */
  public boolean hasEdge(Vertex<T> dest) {
    return (findEdge(dest) != null);
  }

  /**
   * Has this vertex been marked during a visit
   * 
   * @return true is visit has been called
   */
  public boolean visited() {
    return mark;
  }

  /**
   * Set the vertex mark flag.
   * 
   */
  public void mark() {
    mark = true;
  }

  /**
   * Set the mark state to state.
   * 
   * @param state
   *          the state
   */
  public void setMarkState(int state) {
    markState = state;
  }

  /**
   * Get the mark state value.
   * 
   * @return the mark state
   */
  public int getMarkState() {
    return markState;
  }

  /**
   * Visit the vertex and set the mark flag to true.
   * 
   */
  public void visit() {
    mark();
  }

  /**
   * Clear the visited mark flag.
   * 
   */
  public void clearMark() {
    mark = false;
  }

  /**
   * @return a string form of the vertex with in and out edges.
   */
  public String toString() {
    StringBuffer tmp = new StringBuffer("Vertex(");
    tmp.append(name);
    tmp.append(", data=");
    tmp.append(data);
    tmp.append("), in:[");
    for (int i = 0; i < incomingEdges.size(); i++) {
      Edge<T> e = incomingEdges.get(i);
      if (i > 0)
        tmp.append(',');
      tmp.append('{');
      tmp.append(e.getFrom().name);
      tmp.append(',');
      tmp.append(e.getCost());
      tmp.append('}');
    }
    tmp.append("], out:[");
    for (int i = 0; i < outgoingEdges.size(); i++) {
      Edge<T> e = outgoingEdges.get(i);
      if (i > 0)
        tmp.append(',');
      tmp.append('{');
      tmp.append(e.getTo().name);
      tmp.append(',');
      tmp.append(e.getCost());
      tmp.append('}');
    }
    tmp.append(']');
    return tmp.toString();
  }
}
interface Visitor<T> {
  public void visit(GraphOpr<T> g, Vertex<T> v);
}

interface VisitorEX<T, E extends Exception> {
  public void visit(GraphOpr<T> g, Vertex<T> v) throws E;
}

interface DFSVisitor<T> {
  public void visit(GraphOpr<T> g, Vertex<T> v);
  public void visit(GraphOpr<T> g, Vertex<T> v, Edge<T> e);
}