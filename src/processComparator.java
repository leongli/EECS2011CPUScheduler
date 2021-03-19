import java.util.Comparator;

public class processComparator implements Comparator<process> {
	
	public processComparator() {}
	public int compare(process p1, process p2) {
		return p1.getProcessPriority() - p2.getProcessPriority();
	}
	
	public boolean equals(process p1, process p2) {
		return p1.getProcessPriority() == p2.getProcessPriority();
	}
}
