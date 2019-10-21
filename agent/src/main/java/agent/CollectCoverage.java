package agent;

import java.util.HashMap;

import it.unimi.dsi.fastutil.ints.IntSet;

public class CollectCoverage {
	
	HashMap<String, IntSet> linesCovered;
	HashMap<String, HashMap<String, IntSet>> testCases;
	
	public static void addCoveredLine(String cName, Integer line) {
		System.out.println(cName + "\t" + line);
	}
}
