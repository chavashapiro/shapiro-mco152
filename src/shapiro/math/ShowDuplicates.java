package shapiro.math;

import java.util.HashSet;

public class ShowDuplicates {
	public static void main(String[] args) {
		String[] array = new String[] {
				"A", "B", "B", "B", "B", "C"
		};
		
		HashSet<String> unique = new HashSet<String>();
		HashSet<String> printed = new HashSet<String>();
		for (String s : array) {
			if (unique.contains(s)) {
				if (!printed.contains(s)) {
					System.out.println(s);
					printed.add(s);
				}
			} 
			unique.add(s);	
		}
	}
}
