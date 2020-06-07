import java.util.*;
import java.io.*;

public class FileIndex {
	
	public static void main(String[] args)throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		HashMap<String, Set<File>> st = new HashMap<String,Set<File>>();
		
		for(String filename:args) {
			File file = new File(filename);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String temp;
			while((temp=br.readLine())!=null) {
				String[] tokens = temp.split(",");
				for(String i:tokens) {
					if(!st.containsKey(i)) st.put(i, new HashSet<File>());
					Set<File> set = st.get(i);
					set.add(file);
				}
			}
		}
	
		while(scan.hasNext()) {
			String query = scan.next();
		//	Set<File> set = st.get(query);
			System.out.println(st.get(query));
		}
	
	
	
	}
}