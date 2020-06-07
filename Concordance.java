import java.util.*;
import java.io.*;

public class Concordance {
	public static void main(String[] args)throws Exception {
		File file = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp;
		HashMap<String,Set<Integer>> st = new HashMap<String,Set<Integer>>();
		Scanner scan = new Scanner(System.in);
		while((temp=br.readLine())!=null) {
			String[] tokens = temp.split("\\s+");
			for(int i =0; i<tokens.length-1; i++) {
				if(!st.containsKey(tokens[i]))
					st.put(tokens[i], new HashSet<Integer>());
				Set<Integer> set = st.get(tokens[i]);
				set.add(i);
				
			}
		while(scan.hasNext()) {
			String n = scan.next();
			if(st.containsKey(n)) {
				Set<Integer> set = st.get(n);
				for(int k:set) {
					System.out.println(k-4); System.out.println(k-3); System.out.println(k-2);
					System.out.println(k-1); System.out.println(k); System.out.println(k+1);
					System.out.println(k+2); System.out.println(k+3); System.out.println(k+4);
				}
			}
		}
			
		}
		
		
	}
}
