package agent;

import java.util.HashMap;
import it.unimi.dsi.fastutil.ints.IntSet;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;

public class CollectCoverage {
	
	public static HashMap<String, IntLinkedOpenHashSet> linesCovered;
	public static HashMap<String, HashMap<String, IntLinkedOpenHashSet>> testCases;
	public static String testName;
	
	//Constructors
	public CollectCoverage() {
		linesCovered = new HashMap<String, IntLinkedOpenHashSet>();
		testCases = new HashMap<String, HashMap<String, IntLinkedOpenHashSet>>();
		testName = "";
	}

	//Accessors

	
	
	public static void addCoveredLine(String name, Integer line) {
		
		//The lines covered is empty
		if(linesCovered == null || linesCovered.isEmpty() == true){

		System.out.println("This is the line " + name +"| "+ line);

	    }

	   IntLinkedOpenHashSet covered_lines = linesCovered.get(name);
		//If linesCovered has no values for the specified class name
		if(covered_lines == null) {
			int[] new_set = {line};
			System.out.println("This is the line " + name +"| "+ line);
			linesCovered.put(name, new IntLinkedOpenHashSet(new_set));
			//System.out.println("Putting line number" + line + "in" + name);
		}
		
		else{
		//If adding lines to existing linesCovered
		covered_lines = new IntLinkedOpenHashSet(new int[]{line});
			System.out.println("This is the line " + name +"| "+ line);
		   linesCovered.put(name, covered_lines);
		} 
	}
		
	
}
