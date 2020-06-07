import java.io.*;
import java.util.*;
public class DictionaryLookupCSV {

	public static void main(String[] args)throws Exception {	
		// TODO implement Dictionary data structure 
		File file = new File(args[0]);
		BufferedReader br = new BufferedReader(new FileReader(file));
		Scanner scan = new Scanner(System.in);
		int keyField = Integer.parseInt(args[1]);
		int valField = Integer.parseInt(args[2]);
		
		HashMap<String,String> map = new HashMap();
		
		String st;
		while((st=br.readLine())!=null) {
			String[] tokens = st.split(",");
			String key = tokens[keyField];
			String val = tokens[valField];
			map.put(key, val);
		}
		String temp;
		while(scan.hasNext()) {
			if(map.containsKey(temp = scan.next()))
				System.out.println(map.get(temp));
			else System.out.println("Not found");
		}

		
	}

}
