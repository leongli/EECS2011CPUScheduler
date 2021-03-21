import java.util.*;
import java.util.Scanner;
public class sJFScheduling extends base_Scheduling_Class{

	//Global variable arraylist ready will hold the ready queue for the modeling class.
	ArrayList<process> ready;

	public sJFScheduling(ArrayList<process>processes)
    {
		//int numP is equal to number of processes needed
		int numP = processes.size();
		int clock = 0;
		numProcesses=numP;
		float averageWaitTime = 0;
		float averageTurnAroundTime = 0;
		int totalProcesses = 0;
		int compSeconds[] = new int[numP];
		int completionFlags[] = new int [numP];
		int turnaroundTimeArray[] = new int [numP];
		int waitingTimeArray[] = new int [numP];
		int tempForWaitingTime[] = new int [numP];

		for (int q = 0; q < numP; q++) {
			tempForWaitingTime[q] = processes.get(q).getBurstTime();
		}

		while(true){
	    	int minimum = 99;
	    	int count = numP;
	    	if (totalProcesses == numP)
	    		break;

	    	for (int i=0;i<numP;i++)
	    	{
	    		if ((processes.get(i).getBurstTime() <=clock) && (completionFlags[i]==0) && (processes.get(i).getBurstTime()<minimum))
	    		{
	    			minimum =processes.get(i).getBurstTime();
	    			count = i;
	    		}
	    	}

	    	if (count == numP)
	    		clock++;
	    	else
	    	{
	    		int setburstNew =(processes.get(count).getBurstTime() - 1);
	    		processes.get(count).setBurstTime(setburstNew);
	    		clock++;
	    		if (processes.get(count).getBurstTime()==0)
	    		{
	    			compSeconds[count]= clock;
	    			completionFlags[count]=1;
	    			totalProcesses++;
	    		}
	    	}
	    }
		for(int j = 0;j < numP; j++)
	     {
			turnaroundTimeArray[j] = compSeconds[j] - processes.get(j).getArrivalTime();
			waitingTimeArray[j] = turnaroundTimeArray[j] - tempForWaitingTime[j];
			averageWaitTime+= waitingTimeArray[j];
			averageTurnAroundTime+= turnaroundTimeArray[j];
	     }
		System.out.println("Average wait time is: " + averageWaitTime(averageWaitTime, numP));
		System.out.println("Average turnaround time is: " + averageTurnAroundTime(averageTurnAroundTime, numP));
    }


	}
