import java.util.ArrayList;
import java.util.Scanner;

/* Class to conduct modeling of multiple scheduling algorithms with different processes */
public class modeller {
	public static void main(String [] args) {
		String schedueller;
		int numP;
		int arivalTime;
		int burstTime;
		int priority;
		
		
		Scanner scan = new Scanner(System.in);
		
		//Prompt for scheduling algorithm
		System.out.println("Enter the acronym of the Scheduling Alogrithm to Model\nFCFS - Nonpreemptive First-Come First-Served Scheduling\nSJF- Nonpreemptive Shortest-Job-First Scheduling");
		System.out.println("P-SJF - Preemptive SJF (Shortest-Remaining-Time-First) Scheduling\nPS - Nonpreemptive Priority Scheduling\nP-PS - Preemptive Priority Scheduling\nP-RR - Preemptive Round-Robin (RR) Scheduling");
		schedueller = scan.nextLine();
		
		//Prompt for number of processes
		System.out.println("Enter The Number of Processes to Model");
		numP = scan.nextInt();
		
		if(schedueller.equals("FCFS")) {
			//New List to hold processes
			ArrayList<process> processes = new ArrayList<process>();
			
			for(int p = 0; p < numP; p++) {
				System.out.println("Enter Info For Process " + (p + 1) + ": ");
				System.out.println("Arival Time: ");
				arivalTime = scan.nextInt();
				
				System.out.println("Burst Time: ");
				burstTime = scan.nextInt();			
				
				process newProcess = new process(arivalTime, burstTime);
				processes.add(newProcess);				
			}
			//call to conduct modeling with process list
			
			//Output of results
			System.out.println("The Average Waiting Time was: ");
			System.out.println("The Average Turnaround Time was: ");
			
		}else if (schedueller.equals("SJF")) {
			
		}else if (schedueller.equals("P-SJF")) {
			
		}else if (schedueller.equals("PS")) {
			
		}else if (schedueller.equals("P-PS")) {
			
		}else if (schedueller.equals("P-RR")) {
			
		}
	}
}
