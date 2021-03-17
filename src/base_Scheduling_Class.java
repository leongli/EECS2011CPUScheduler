
public class base_Scheduling_Class {

	double aveWaitTime;
	double aveTurnAroundTime;
	int numProcesses;
	double burstTime;
	double totalWaitTime;
	double totalTurnAroundTime;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Method to calculate average wait time of processes sent to scheduler
	public double averageWaitTime(double a, int b) {
		
		double wait = a / b;
		return wait;
	}
	//Method to calculate average TurnAround time of processes sent to scheduler
	public double averageTurnAroundTime(double a, int b) {
		double turnArouindWait = a / b;
		return turnArouindWait;
	}
	
}
