
public class Selection {

	public static void sort(Comparable[] a) {
		int N = a.length;
		
		for(int i = 0; i<N; i++) {
			int minIndex = i;
			for(int j = i; j<N; j++) {
				
				if(less(a[j],a[minIndex])){
					minIndex = j;		
				}
			}
			exchange(a,i,minIndex);
		}
	}


	
	
	private static boolean less(Comparable v, Comparable w)
	{ return v.compareTo(w) < 0; }
	
	private static void exchange(Comparable a[], int i, int j ) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

}