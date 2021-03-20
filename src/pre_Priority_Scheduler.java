import java.util.ArrayList;
import java.util.PriorityQueue;

public class pre_Priority_Scheduler extends base_Scheduling_Class{
	PriorityQueue ready;
	ArrayList<process> processes;
	
	pre_Priority_Scheduler(ArrayList<process> processes){
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
		boolean terminated = true;
		
		while(!this.ready.isEmpty()) {
			if(terminated) {
				
			}
			//remove a process from the ready queue
			p = (process) this.ready.remove();
			if(p.getBurstTime() > 1) {
				p.setBurstTime(p.getBurstTime() - 1);
				time += p.getBurstTime();
								
				
			}else {
				
				time++;
				
			}
			
			//adds any new arrivals to the queue
			for(process prs: this.processes) {
				//if the process arrives add it to ready queue and remove from list
				if(prs.getArrivalTime() == 0) {
					this.ready.add(p);
					this.processes.remove(prs);
				}
			}
			
			//Calculates Wait time of each process waiting
			for(Object prs: this.ready) {
				totalWaitTime++;
			}
		}
	}
}
