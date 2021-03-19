
public class process {
	int arrivalTime;
	int burstTime; //Temporary to simplify schedulling
	// I/O requirements
	int processPriority;
	
	public process(int aTime, int bTime) {
		this.arrivalTime = aTime;
		this.burstTime = bTime;
	}
	
	public process(int aTime, int bTime, int priority) {
		this.arrivalTime = aTime;
		this.burstTime = bTime;
		this.processPriority = priority;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getBurstTime() {
		return burstTime;
	}
	public void setBurstTime(int burstTime) {
		this.burstTime = burstTime;
	}
	public int getProcessPriority() {
		return processPriority;
	}
	public void setProcessPriority(int processPriority) {
		this.processPriority = processPriority;
	}
	
}
