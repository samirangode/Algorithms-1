
public class Heap {

	// less and exchange methods are to be changed to make them zero indexed
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int k = N/2; k>=1; k--) {
			sink(a,k,N);
		}
		while(N>1) {
			exch(a,1,N);
			sink(a,1,--N);
		}
	}
	
	private static void sink(Comparable[] a, int k , int N) {
		while(2*k<=N) {
			int j = 2*k;
			if(less(a,j,j+1)) j++;
			if(!less(a,k,j)) break;
			exch(a,j,k);
			k = j;
		}
	}
	
	private static boolean less(Comparable[] a, int i, int j) {
		return a[i-1].compareTo(a[j-1])<0;
		//i-1 to make it zero indexed
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = swap;
	}
}
