// linked list implementation of stack

public class LinkedStackOfStrings {
	
	private Node first = null;
	
	private class Node{
		String item;
		Node next;
	}
	
	public boolean isEmpty(){ 
		return first==null;
	}
	
	public void push(String item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public String pop(){
		String temp = first.item;
		first = first.next;
		return temp;
	}
	
}
