package agent;

import java.util.HashMap;

import it.unimi.dsi.fastutil.ints.IntSet;

public class CollectCoverage {
	
	private HashMap<String, IntSet> linesCovered;
	private HashMap<String, HashMap<String, IntSet>> testCases;
	
	//Accessors
	public HashMap<String, IntSet> getLinesCovered() {return linesCovered;}
	public HashMap<String, HashMap<String, IntSet>> getTestCases() {return testCases;}
	
	public static void addCoveredLine(String cName, Integer line) {
		System.out.println(cName + "\t" + line);
	}
}
