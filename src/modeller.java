import java.util.ArrayList;
import java.util.Scanner;

/* Class to conduct modeling of multiple scheduling algorithms with different processes */
public class modeller {
	public static void main(String [] args) {
		String schedueller;
		int numP;
		int arivalTime = 0;
		int burstTime = 0;
		int processPriority;
		
		
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
			
			//Loop to store info for each process
			for(int p = 0; p < numP; p++) {
				System.out.println("Enter Info For Process " + (p + 1) + ": ");
				System.out.println("Arival Time: ");
				arivalTime = scan.nextInt();
				
				System.out.println("Burst Time: ");
				burstTime = scan.nextInt();			
				
				//creating and storing new process with found info
				process newProcess = new process(arivalTime, burstTime);
				processes.add(newProcess);				
			}
			//call to conduct modeling with process list
			
			//Output of results
			System.out.println("The Average Waiting Time was: ");
			System.out.println("The Average Turnaround Time was: ");
			
		}else if (schedueller.equals("SJF")) {
			//New List to hold processes
			ArrayList<process> processes = new ArrayList<process>();
			
			//Loop to store info for each process
			for(int p = 0; p < numP; p++) {
				System.out.println("Enter Info For Process " + (p + 1) + ": ");
				System.out.println("Arival Time: ");
				arivalTime = scan.nextInt();
				
				System.out.println("Burst Time: ");
				burstTime = scan.nextInt();			
				
				//creating and storing new process with found info
				process newProcess = new process(arivalTime, burstTime);
				processes.add(newProcess);				
			}
			//call to conduct modeling with process list
			
			//Output of results
			System.out.println("The Average Waiting Time was: ");
			System.out.println("The Average Turnaround Time was: ");
		}else if (schedueller.equals("P-SJF")) {
			//New List to hold processes
			ArrayList<process> processes = new ArrayList<process>();
			
			//Loop to store info for each process
			for(int p = 0; p < numP; p++) {
				System.out.println("Enter Info For Process " + (p + 1) + ": ");
				System.out.println("Arival Time: ");
				arivalTime = scan.nextInt();
				
				System.out.println("Burst Time: ");
				burstTime = scan.nextInt();
				
				System.out.println("Enter Priority");
				processPriority = scan.nextInt();
				
				//creating and storing new process with found info
				process newProcess = new process(arivalTime, burstTime);
				processes.add(newProcess);				
			}
			//call to conduct modeling with process list
			
			//Output of results
			System.out.println("The Average Waiting Time was: ");
			System.out.println("The Average Turnaround Time was: ");
		}else if (schedueller.equals("PS")) {
			// New List to hold processes
			ArrayList<process> processes = new ArrayList<process>();

			// Loop to store info for each process
			for (int p = 0; p < numP; p++) {
				System.out.println("Enter Info For Process " + (p + 1) + ": ");
				// System.out.println("Arival Time: ");
				// arivalTime = scan.nextInt();

				System.out.println("Burst Time: ");
				burstTime = scan.nextInt();
				if (burstTime < 0) {
					
				}
				System.out.println("Enter Priority");
				processPriority = scan.nextInt();
				if (burstTime < 0) {
					
				}

				// creating and storing new process with found info
				process newProcess = new process(arivalTime, burstTime, processPriority);
				processes.add(newProcess);
			}
			// call to conduct modeling with process list
			Collections.sort(processes); // sorts list from highest priority to lowest

			int totalWaitTime = 0;
			double avgWaitTime;
			int totalTurnAroundTime = 0;
			double avgTurnAroundTime;

			int burstTimeArr[] = new int[processes.size()];
			int turnAroundTime[] = new int[processes.size() + 1];
			int waitingTime[] = new int[processes.size() + 1];

 
			for (int i = 0; i < processes.size(); i++) { // stores burst times of sorted list into array
				process str = processes.get(i);
				burstTimeArr[i] += str.getBurstTime();
			}

			for (int i = 0; i < processes.size(); i++) { // // stores turnaround time and  waiting time of sorted list into array
				turnAroundTime[i] = burstTimeArr[i] + waitingTime[i];
				waitingTime[i + 1] = turnAroundTime[i];
			}

			for (int i = 0; i < processes.size(); i++) { // calculates total turnaround time and total waiting time
				totalTurnAroundTime += (waitingTime[i] + burstTimeArr[i]);
				totalWaitTime += waitingTime[i];
			}
			avgWaitTime = totalWaitTime / (double) processes.size(); // calculates average waiting time
			avgTurnAroundTime = totalTurnAroundTime / (double) processes.size();// calculates average turnaround time

			// Output of results
			System.out.println("The Average Waiting Time was: " + avgWaitTime);
			System.out.println("The Average Turnaround Time was: " + avgTurnAroundTime);

			
		}else if (schedueller.equals("P-PS")) {
			//New List to hold processes
			ArrayList<process> processes = new ArrayList<process>();
			
			//Loop to store info for each process
			for(int p = 0; p < numP; p++) {
				System.out.println("Enter Info For Process " + (p + 1) + ": ");
				System.out.println("Arival Time: ");
				arivalTime = scan.nextInt();
				
				System.out.println("Burst Time: ");
				burstTime = scan.nextInt();
				
				System.out.println("Enter Priority");
				processPriority = scan.nextInt();
				
				//creating and storing new process with found info
				process newProcess = new process(arivalTime, burstTime, processPriority);
				processes.add(newProcess);				
			}
			//call to conduct modeling with process list
			pre_Priority_Scheduler scheduler = new pre_Priority_Scheduler(processes);
			scheduler.model();
			
			//Output of results
			System.out.println("The Average Waiting Time was: " + scheduler.averageWaitTime());
			System.out.println("The Average Turnaround Time was: " + scheduler.averageTurnAroundTime());
		}else if (schedueller.equals("P-RR")) {
			//New List to hold processes
			ArrayList<process> processes = new ArrayList<process>();
			
			//Loop to store info for each process
			for(int p = 0; p < numP; p++) {
				System.out.println("Enter Info For Process " + (p + 1) + ": ");
				System.out.println("Arival Time: ");
				arivalTime = scan.nextInt();
				
				System.out.println("Burst Time: ");
				burstTime = scan.nextInt();
				
				System.out.println("Enter Priority");
				processPriority = scan.nextInt();
				
				//creating and storing new process with found info
				process newProcess = new process(arivalTime, burstTime, processPriority);
				processes.add(newProcess);				
			}
			//call to conduct modeling with process list
			
			//Output of results
			System.out.println("The Average Waiting Time was: ");
			System.out.println("The Average Turnaround Time was: ");
		}
		
	}
}
