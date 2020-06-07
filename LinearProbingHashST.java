
public class LinearProbingHashST<Key, Value> {
	private int M = 3001;
	@SuppressWarnings("unchecked")
	private Value[] vals = (Value[]) new Object[M];
	@SuppressWarnings("unchecked")
	private Key[] keys = (Key[]) new Object[M];
	
	private int hash(Key key) {
		return (key.hashCode()& 0x7fffffff)%M;
	}
	
	public void put(Key key, Value val) {
//		int i = hash(key);
/*		if(keys[i]==null) { 
			keys[i] = key;
			vals[i] = val;
		}
*/		int i;
		for(i = hash(key);keys[i]!=null;i = (i+1)%M) {
			if(keys[i]==key) break;
		}
		keys[i] = key;
		vals[i] = val;
	}
	
	public Value get(Key key) {
		int i = hash(key);
		while(keys[i]!=null) {
			if(keys[i]==key) return vals[i];
			i = (i+1)%M;
		}
		return null;
	}
	
	
}
