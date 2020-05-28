
public class RedBlackBST<Key extends Comparable<Key>,Value> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	Node root;
	private class Node{
		Key key;
		Value val;
		Node left, right;
		boolean colour;
		
		Node(Key k, Value val, boolean bool){
			this.key = k;
			this.val = val;
			this.colour = bool;
		}
	}
	
	private boolean isRed(Node x) {
		return x.colour == RED;
	}
	
	public Value getKey(Key key) {
		Node x = root;
		
		while(x!= null) {
			int cmp = key.compareTo(x.key);
			if(cmp<0) x = x.left;
			else if(cmp>0) x = x.right;
			else return x.val;
		}
		return null;
	}

	private Node rotateLeft(Node h) {
		
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		h.colour = RED;
		x.colour = h.colour;
		return x;	
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.colour = h.colour;
		h.colour = RED;
		return x;
	}
	
	private void flipColours(Node h) {
		h.colour = RED;
		h.right.colour = BLACK;
		h.left.colour = BLACK;	
	}
	
	private Node put(Node h, Key key, Value val) {
		if(h== null) return new Node(key, val, RED);
		
		int cmp = key.compareTo(h.key);
		if(cmp<0) put(h.left, key, val);
		else if(cmp>0) put(h.right, key, val);
		else h.val = val;
		
		if(isRed(h.right)&&!isRed(h.left)) h=rotateLeft(h);
		if(isRed(h.left)&&isRed(h.left.left)) h =  rotateRight(h);
		if(isRed(h.left)&&isRed(h.right)) flipColours(h);
		
		return h;
	}

}
