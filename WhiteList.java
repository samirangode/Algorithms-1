import java.util.*;
// Set data structure
public class WhiteList {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		Scanner in = new Scanner(System.in);
		for(String val:args) {
			set.add(val);
		}
		
		while(in.hasNext()) {
			String val = in.next();
			if(set.contains(val)) {
				System.out.println(val);
			}
		}
	}
}