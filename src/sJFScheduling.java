import java.util.*;
import java.util.Scanner;
public class sJFScheduling extends base_Scheduling_Class{

	public sJFScheduling(ArrayList<process>processes)
    {
		//int numP is equal to number of processes needed
		int numP = processes.size();
		//Clock represents the time of running in the schedulr
		int clock = 0;
		// Clone variable for number of processes also known as numP
		numProcesses=numP;
		//averageWaitTime summation value for usage at end of program
		float totalWaitTime = 0;
		//averageTurnAroundTime summation value for usage at end of program
		float totalTurnAroundTime = 0;
		//Total processes represents total processes completed and will update as processes complete
		int totalProcesses = 0;
		//The completion time in milliseconds of each process is stored in this array
		int compSeconds[] = new int[numP];
		//Completion flags is used to determine whether or not a process has been completed with regards to the burst time of the process
		int completionFlags[] = new int [numP];
		//Stores turn around time of each process, used later to calculate total and averageTurnAroundTime
		int turnaroundTimeArray[] = new int [numP];
				//Stores wait time of each process, used later to calculate total and average wait Time
		int waitingTimeArray[] = new int [numP];
		//Temp array holding burst time as burst time of process is mutated during code
		int tempForBurstTime[] = new int [numP];

		// BIGo(N) loop to transfer burst times to temp burst array
		for (int q = 0; q < numP; q++) {
			//Iterating through process list and setting temp array with burst times
			tempForBurstTime[q] = processes.get(q).getBurstTime();
		}

		while(true){
			// minimum value 
	    	int minimum = 99;
				// int count is set to the number of processes
	    	int count = numP;
				// if totalProcesses increments and becomes the number of processes, this means that the algorithm has finished and it will then break the loop
	    	if (totalProcesses == numP)
	    		break;

					//for loop to determine the order of execution of processes
	    	for (int i=0;i<numP;i++)
	    	{
	    		if ((processes.get(i).getBurstTime() <=clock) && (completionFlags[i]==0) && (processes.get(i).getBurstTime()<minimum))
	    		{
						//after a process is complete, minimum becomes that processes burst time
	    			minimum =processes.get(i).getBurstTime();
						//count will become the number i and will affect the code accordingly
						count = i;
	    		}
	    	}
				//if count increases and becomes equivalent to the number of processes, we increment the clock variable
	    	if (count == numP)
	    		clock++;
	    	else
	    	{
					//If not, we decrement the burst time of the process by 1 until the process is completed
	    		int setburstNew =(processes.get(count).getBurstTime() - 1);
	    		processes.get(count).setBurstTime(setburstNew);
					//clock increments by one second as process decrements by one second.
	    		clock++;
					// when process is complete
	    		if (processes.get(count).getBurstTime()==0)
	    		{
						//completion time of the process is stored as the value of clock
	    			compSeconds[count]= clock;
						//the flag representing the completion of the process is set to 1, meaning process is complete
	    			completionFlags[count]=1;
						//Total number of processes completed increases by 1
	    			totalProcesses++;
	    		}
	    	}
	    }
			//BIGo(N) loop to set arrays with turnaroundtime and waiting time as they will be used in the calculation of average turnaround and waiting times
		for(int j = 0;j < numP; j++)
	     {
				 //turnaround is equal to time of completion - arrival time
			turnaroundTimeArray[j] = compSeconds[j] - processes.get(j).getArrivalTime();
			//waiting time is equal to turnaround time  - burst time
			waitingTimeArray[j] = turnaroundTimeArray[j] - tempForBurstTime[j];
			//loop through and run summation of values in both arrays to get the total waiting and total turnaround time
			totalWaitTime = totalWaitTime+ waitingTimeArray[j];
			totalTurnAroundTime= totalTurnAroundTime + turnaroundTimeArray[j];
	     }
			 //Output average turnaround and average waiting time
		System.out.println("Average wait time is: " + averageWaitTime(totalWaitTime, numP));
		System.out.println("Average turnaround time is: " + averageTurnAroundTime(totalTurnAroundTime, numP));
    }

	}
