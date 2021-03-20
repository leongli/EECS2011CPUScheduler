import java.util.ArrayList;
import java.util.PriorityQueue;

public class pre_Priority_Scheduler extends base_Scheduling_Class{
	PriorityQueue ready;
	ArrayList<process> processes;
	
	pre_Priority_Scheduler(ArrayList<process> processes){
		//initialize turnaround and wait time
		this.totalTurnAroundTime = 0;
		this.totalWaitTime = 0;
		this.numProcesses = processes.size();
		
		//Initializes Array List
		this.processes = new ArrayList<process>();
		
		//comparator made to compare processes
		processComparator PC = new processComparator();
		
		//priority queue to hold ready processes
		this.ready = new PriorityQueue(processes.size(), PC);
		for(process p: processes) {
			if(p.getArrivalTime() == 0) {
				this.ready.add(p);
			}else {
				this.processes.add(p);
			}
		}
	}
	
	/* method to model the scheduling algorithm */
	void model(){
		//holds current process that is being processed
		process p;
		//holds current time of model
		int time = 0;
		int turnaroundTime= 0;
		int burst;
		
		try {
		
		//goes through each second until all processes are terminated
		while(!(this.ready.isEmpty() && this.processes.isEmpty())) {
		
			//Check if Ready has a process
			if(!this.ready.isEmpty()) {
				//Get the head process
				p = (process) this.ready.element();
				System.out.println("Executing Process, Time: " + time + ", ArivalTime: " + p.getArrivalTime() + ", burstTime: " + p.getBurstTime() + " Priority: " + p.getProcessPriority() );
				
				//Adjust Burst Time
				p.setBurstTime(p.getBurstTime() - 1);
				
				//Check if Terminated
				if(p.getBurstTime() == 0) {
					this.ready.remove();//remove head process
				}else {
					this.totalWaitTime--;//Since the process is being executed
				}
				
				this.totalTurnAroundTime++;
			
				//Increments Wait time of each process waiting
				for(Object prs: this.ready) {
					this.totalWaitTime++;
				}
			}
			
			//increment time
			time++;
			
			//adds any new arrivals to the queue
			for(int i = 0; i < processes.size(); i++) {
				process prs = processes.get(i);
				//if the process arrives add it to ready queue and remove from list
				if(prs.getArrivalTime() == time) {
					System.out.println("New Process, Time: " + time + ", ArivalTime: " + prs.getArrivalTime() + ", burstTime: " + prs.getBurstTime() + " Priority: " + prs.getProcessPriority() );
					this.ready.add(prs);
					this.processes.remove(prs);
				}
			}
			
			
			
		}
		}catch(Exception e) {
			System.out.println("ERROR in WHILE LOOP");
			System.out.println(e.getMessage());
		}
		//adjusting turnaround time to account for waiting time
		this.totalTurnAroundTime += this.totalWaitTime;
	}
}
