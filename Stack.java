import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		
		public boolean hasNext() {
			return current!=null;
		}
		public void remove()
		{ /* not supported */
		}
		
		public Item next(){
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
}
/*
public class Stack<Item> implements Iterable<Item>
{
	public Iterator<Item> iterator()
	{ return new ReverseArrayIterator(); }
	private class ReverseArrayIterator implements Iterator<Item>
	{
		private int i = N;
		public boolean hasNext() {
		public void remove()
		{
			public Item next()
					{
return i > 0;
// not supported
return s[--i];
}
}
}
}
}


*/
