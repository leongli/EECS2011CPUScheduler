public class process implements java.lang.Comparable<process> {
	int arrivalTime;
	int burstTime; // Temporary to simplify schedulling
	// I/O requirements
	int processPriority;
	String processNum;
	int numOfProcess;

	public process(int aTime, int bTime) {
		this.arrivalTime = aTime;
		this.burstTime = bTime;
	}

	public process(int aTime, int bTime, int priority) {
		this.arrivalTime = aTime;
		this.burstTime = bTime;
		this.processPriority = priority;
	}

	public process(String processNum, int numOfProcess, int burstTime, int processPriority) {
		this.processNum = processNum;
		this.numOfProcess = numOfProcess;
		this.burstTime = burstTime;
		this.processPriority = processPriority;
	}

	public process(String processNum, int burstTime, int processPriority) {
		this.processNum = processNum;
		this.burstTime = burstTime;
		this.processPriority = processPriority;
	}

	public int getNumOfProcess() {
		return numOfProcess;
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

	@Override
	public int compareTo(process compareProcess) {
		int comparePriority = ((process) compareProcess).getProcessPriority();
		return this.processPriority - comparePriority;
	}
}
