package agent;

import java.util.HashMap;

import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import it.unimi.dsi.fastutil.ints.IntSet;

public class CollectCoverage {
	
	private static HashMap<String, IntSet> linesCovered;
	private static HashMap<String, HashMap<String, IntSet>> testCases;
	private static String testName;
	
	//Constructors
	public CollectCoverage() {
		linesCovered = new HashMap<String, IntSet>();
		testCases = new HashMap<String, HashMap<String, IntSet>>();
		testName = "";
	}
	
	//Accessors
	public HashMap<String, IntSet> getLinesCovered() {return linesCovered;}
	public HashMap<String, HashMap<String, IntSet>> getTestCases() {return testCases;}
	public String getTestName() {return testName;}
	
	//Mutators
	public void setLinesCovered(HashMap<String, IntSet> lc) {linesCovered = lc;}
	public void setTestCases(HashMap<String, HashMap<String, IntSet>> tc) {testCases = tc;}
	public void setTestName(String tn) {testName = tn;}
	
	
	public static void addCoveredLine(String name, Integer line) {
		
		//If linesCovered has no values for the specified class name
		if(linesCovered.get(name) == null) {
			int[] new_set = {line};
			linesCovered.put(name, new IntLinkedOpenHashSet(new_set));
			return;
		}
		
		//If adding lines to existing linesCovered
		linesCovered.get(name).add(line);
		
	}
}
