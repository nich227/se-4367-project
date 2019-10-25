package agent;

import it.unimi.dsi.fastutil.ints.IntLinkedOpenHashSet;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class JUnitListener extends RunListener {

	public void testRunStarted(Description description) throws Exception {

		if (CollectCoverage.testCases == null) {
			CollectCoverage.testCases = new HashMap<String, HashMap<String, IntLinkedOpenHashSet>>();
		}
	}

	public void testStarted(Description description) {
		System.out.println("\n-----\nStart ... " + description.getMethodName());
		CollectCoverage.testName = "[TEST]" + description.getClassName() + ":" + description.getMethodName();
		CollectCoverage.linesCovered = new HashMap<String, IntLinkedOpenHashSet>();
	}

	public void testFinished(Description description) {
		System.out.println("Finish ... " + description.getMethodName());
		CollectCoverage.testCases.put(CollectCoverage.testName, CollectCoverage.linesCovered);
	}

	public void testRunFinished(Result result) throws IOException {
		System.out.println("Done\n\n");

		File fout = new File("stmt-cov.txt");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		StringBuilder builder = new StringBuilder();
		for (String testCaseName : CollectCoverage.testCases.keySet()) {
			System.out.println("Test case: " + testCaseName);
			builder.append(testCaseName + "\n");

			HashMap<String, IntLinkedOpenHashSet> caseCoverage = CollectCoverage.testCases.get(testCaseName);
			System.out.println(Arrays.asList(caseCoverage));

			for (String className : caseCoverage.keySet()) {
				int[] lines = caseCoverage.get(className).toIntArray();

				Arrays.sort(lines);
				System.out.println(Arrays.toString(lines));
				for (int i = 0; i < lines.length; i++) {
					builder.append(className + ":" + lines[i] + "\n");
				}
			}
		}

		bw.write(builder.toString());
		bw.close();
	}

}