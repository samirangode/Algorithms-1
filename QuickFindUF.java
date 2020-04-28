
public class QuickFindUF {
	private int[] id;
	
	public QuickFindUF(int n) {
		id = new int[n];
		for(int i=0;i<n;i++){
			id[i] = i;
		}
	}
	
	public boolean connected(int p, int q) {
		return(id[p]==id[q]);
	}
	
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];		
		for(int i = 0; i<id.length;i++) {
			if(connected(pid,i)) {
				id[i] = qid;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}
