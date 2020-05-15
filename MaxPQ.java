
public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N;
	
	public MaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity+1];
	}
	
	public boolean isEmpty() {
		return (N==0);
	}
	
	public void insert(Key k) {
		pq[++N] = k;
		swim(N);
	}
	
	public Key delMax() {
		Key max = pq[1];
		exch(1,N);
		pq[N--] = null;
		sink(1);
		return max;
	}
	
	private void swim(int k) {
		while(less(k/2,k) && k>1) {
			exch(k,k/2);
			k = k/2;
		}
	}
	
	private void sink(int k) {
		
		while(2*k<=N) {
		int j = 2*k;
		
		if(j<N && less(j,j+1)) j++;
		if(!less(k,j)) break;
		exch(j,k);
		k = 2*j; 
		}
	}
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j])<0;
	}
	
	private void exch(int i,int j) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
	
}
