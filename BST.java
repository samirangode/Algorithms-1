import java.util.*;
public class BST<Key extends Comparable<Key>,Value> {
	
	private Node root;
	
	private class Node{
		private Key key;
		private Value val;
		private Node left, right;
		private int count;
		public Node(Key key, Value val) {
			
			this.key = key;
			this.val = val;
		}
	
	}
	
	public int size(){
		return size(root);
	}
	
	private int size(Node x) {
		if(x == null) return 0;
		return x.count;
	}
	
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val){
		
		if(x == null) return new Node(key, val);
		
		if(key.compareTo(x.key)>0) 
			x.right = put(x.right, key, val);
		else if(key.compareTo(x.key)<0)
			x.left = put(x.left, key , val);
		else x.val = val;
		
		x.count = 1 + size(x.right) + size(x.left);
		return x;
	}
	
	public Value get(Key key) {
		Node x = root;
		while(x != null) {
			int cmp  = key.compareTo(x.key);
			if(cmp>0) x = x.right;
			else if(cmp<0) x = x.left;
			else return x.val;	
		}
		return null;
	}
	
	public Key floor(Key key) {
		Node x = floor(root, key);
		if(x==null) return null;
		return x.key;
	}
	
	private Node floor(Node x, Key key) {
		if(x==null) return null;
		
		
		int cmp = key.compareTo(x.key);
		if(cmp==0) return x;
		
		else if(cmp<0) x.left = floor(x.left, key);
		
		Node t = floor(x.right, key);
		if(t!=null) return t;
		else return x;
	}
	
	public int rank(Key key) {
		return rank(root,key);
	}
	
	private int rank(Node x, Key key) {
		if(x==null) return 0; 
		
		int cmp = key.compareTo(x.key);
		if(cmp==0) return size(x.left);
		
		else if(cmp>0) return 1 + size(x.left) + rank(x.right, key);
		
		else return rank(x.left, key);
		
	}
	
	public void delete(Key key) {
		
	}
	
	public Iterable<Key> keys(){
		Queue<Key> q = new LinkedList<Key>();
		inorder(root,q);
		return q;
	}
	
	private void inorder(Node x, Queue<Key> q) {
		if(x==null) return;
		inorder(x.left, q);
		q.add(x.key);
		inorder(x.right,q);
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x) {
		if(x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	/*public Iterable<Key> iterator(){
		
	}*/
}
