import java.util.ArrayList;
import java.util.PriorityQueue;

public class pre_Priority_Scheduler {
	PriorityQueue ready;
	
	pre_Priority_Scheduler(ArrayList<process> processes){
		//comparator made to compare processes
		processComparator PC = new processComparator();
		
		//priority queue to holdd ready processes
		this.ready = new PriorityQueue(processes.size(), PC);
		for(process p: processes) {
			if(p.getArrivalTime() == 0) {
				this.ready.add(p);
			}
		}
	}
}
