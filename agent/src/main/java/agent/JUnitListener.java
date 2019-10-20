package agent;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public class JUnitListener extends RunListener {
	public void testStarted(Description desc) {
        System.out.println("\n\n\nStarting .... " + desc.getMethodName());
    }
    public void testFinished(Description desc) {
        System.out.println("Finished .... "+ desc.getMethodName());
    }
    public void testRunFinished(Result result) {
        System.out.println("\n\n");
    }
}
