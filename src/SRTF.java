import java.util.ArrayList;

public class SRTF extends base_Scheduling_Class
{
	public SRTF(ArrayList<process>processes, int numP)
	{
		//variable declaration
		int time=0, nextAr, nextB, totalCPU=0, i=0,rem, start=0, arrival=0;
		int [] totalWait= new int[numP];
		int [] totalTu= new int [numP]; 
		ArrayList<process> waitList= new ArrayList<process>();	//waitList mimics the ready queue
		//set instance variable 
		numProcesses=numP;
		//sort the processes list according to their arrival times
		mergeSortProcesses(processes, numP);
		//initialize activeProcess
		process activeProcess= processes.get(0);
		//get total burst (CPU) time
		for (process p: processes) 
			totalCPU+=p.getBurstTime();


		while (time<=totalCPU)	//prevent out of bounds
		{
			if(arrival<numProcesses && time==processes.get(arrival).getArrivalTime())	// if its a arrival
			{
				if(time-start==activeProcess.getBurstTime())//if at arrival its a completion
				{
					i=getIndexID(processes, activeProcess.getId());	//set i as index of the completed process in processes
					totalTu[i]=time-processes.get(i).getArrivalTime(); 	//store turnaround time
					waitList.add(processes.get(arrival));	//add arrived to the wait list
					if(time!=totalCPU)	//check out of bounds
					{
						i=nextShortestBurst(waitList);	//i as the next shortest remaining time process index
						activeProcess=waitList.get(i);//set the new active process
						waitList.remove(i); //remove process from waitlist
						start=time; //mark the time when new process takes over
						i=getIndexID(processes, activeProcess.getId()); 	//set i as index of the new process from wait list
						totalWait[i]+=time;	//sum its wait time
					}

				} else	// if not completion at arrival
				{
					if (arrival==0)//if first arrival
					{
						activeProcess= processes.get(arrival); //set active provess
						start++;	//increment start time 
					}else	//if not first arrival
					{
						nextAr=processes.get(arrival).getArrivalTime(); //the just arrived process
						nextB=processes.get(arrival).getBurstTime();	
						waitList.add(new process(nextAr,nextB,processes.get(arrival).getId())); 	//deep copy arrived and adds to waitList
						rem=activeProcess.getBurstTime()-start;	//remaining time of the active process cpu burst time
						if (rem>nextB)		// if remaining time>= next cpu burst time, preempt 
						{
							waitList.add(new process(activeProcess.getArrivalTime(),rem, activeProcess.getId()));	//add preempted process to wait list
							i=nextShortestBurst(waitList);	//get index of the shortest remaining time next in waitList
							activeProcess= waitList.get(i);	//set active process
							waitList.remove(i);	//remove process from queue
							start=time; //mark the time a new process takes over the cpu
							totalWait[arrival-1]+=(-start);	//subtract the time which a process preempts 
						}else 		// if remaining time is < next cpu burst
						{
							totalWait[arrival]+=(-time);  //time here is the process' arrival time
							System.out.println("totalWait: "+totalWait[arrival]);
						}
					}
				}
				arrival++;//increment for next process arrival
			} 
			else if(time-start==activeProcess.getBurstTime())//if completed process
			{
				i=getIndexID(processes, activeProcess.getId()); 	// set i as index of completed process in processes
				totalTu[i]=time-processes.get(i).getArrivalTime();	// set turnaround time
				if(time!=totalCPU && !waitList.isEmpty())	// get next shortest from the list 
				{
					i=nextShortestBurst(waitList);
					activeProcess=waitList.get(i);//set the new active process
					waitList.remove(i); //remove process from waitlist
					start=time; //mark the time
					i=getIndexID(processes, activeProcess.getId());
					totalWait[i]+=time;
				}
			}
			time++;	// increment time
		}
		totalWaitTime=sumArray(totalWait);
		totalTurnAroundTime=sumArray(totalTu);
	}// end constructor
	// HELPER FUNCTIONS
	//returns sum of elements of an array
	public int sumArray(int []arr)
	{
		int sum=0;
		for (int i=0; i<arr.length; i++)
			sum+=arr[i];
		return sum;
	}
	//returns index of a given process ID in processes
	public int getIndexID(ArrayList<process>processes, String id)
	{
		for (int i=0; i<processes.size(); i++)
			if (processes.get(i).getId()==id)
				return i;
		return -1;
	}
	//returns next shortest remaining burst time in a list of processes
	public int nextShortestBurst(ArrayList<process>processes)
	{
		int index=0,i=0,temp=processes.get(0).getBurstTime();
		for (process p: processes)
		{
			if (p.getBurstTime()<temp)
			{
				temp=p.getBurstTime();
				index=i;
			}
			i++;
		}
		return index;
	}
}//end
