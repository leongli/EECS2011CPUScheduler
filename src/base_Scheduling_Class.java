
public class base_Scheduling_Class {

	double aveWaitTime;
	double aveTurnAroundTime;
	int numProcesses;
	double burstTime;
	double totalWaitTime;
	double totalTurnAroundTime;
	
	//Method to calculate average wait time of processes sent to scheduler
	public double averageWaitTime() {
		
		double wait = this.totalWaitTime/ this.numProcesses;
		return wait;
	}
	//Method to calculate average TurnAround time of processes sent to scheduler
	public double averageTurnAroundTime() {
		double turnArouindWait = this.totalTurnAroundTime / this.numProcesses;
		return turnArouindWait;
	}
	
}
