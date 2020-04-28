
public class QuickUnionUF {
	private int[] id;
	private int[] sz;
	public QuickUnionUF(int n) {
		id = new int[n];
		for(int i =0;i<n;i++) {
			id[i] = i;
		}
	}
	
	private int root(int i) {
		// to find the original parent
		while(id[i]!=i) i = id[i];
		return i;
	}
	public boolean connected(int p, int q) {
		return root(p)==root(q);
	}
	public void union(int p,int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
		// for weighted quick-union
		/*if(sz[i]<sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		}
		else {
			id[j] = i;
			sz[i] += sz[j];
		}*/
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
