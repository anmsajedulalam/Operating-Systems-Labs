/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.shceduling;

/**
 *
 * @author BRACU\12201027
 */
import java.util.*;
public class ProcessShceduling {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner k=new Scanner(System.in);
        int burstTime[]=new int [3];
        String [] processes= new String[3];
//        burstTime[0]=24;
//        burstTime[1]=3;
//        burstTime[2]=3;
//        processes[0]="P1";
//        processes[1]="P2";
//        processes[2]="P3";
        int completionTime=0;
        int totalWaitingTime=0;
        int theTimeProcessGetsCPU=0;
        int waitingTime=0;
        int averageWaitingTime=0;
        int arrivalTime=0;
        int turnAroundTime=0;
        int totalTurnAroundTime=0;
        int averageTurnaroundTime=0;
        int finishedTime=0;
        int count=1;
        for(int i=0;i<burstTime.length;i++)
        {
            System.out.println("For Process "+"P"+(i+1)+" Burst Time: ");
            burstTime[i]=k.nextInt();
        }
        for(int c=0;c<processes.length;c++)
        {
            System.out.println("Working on process: "+(c+1));
            if(c!=0)
            {
                theTimeProcessGetsCPU=finishedTime;
                System.out.println("theTimeProcessGetsCPU :"+theTimeProcessGetsCPU);
            }
            else
            {
                theTimeProcessGetsCPU=0;
                System.out.println("theTimeProcessGetsCPU :"+theTimeProcessGetsCPU);
            }
            waitingTime=theTimeProcessGetsCPU-arrivalTime;
            totalWaitingTime=waitingTime+totalWaitingTime;
            System.out.println("waitingTime :"+waitingTime);
            finishedTime=burstTime[c]+finishedTime;
            System.out.println("finishedTime :"+finishedTime);
            turnAroundTime=finishedTime-arrivalTime;
            System.out.println("TurnAroundTime :"+turnAroundTime);
            totalTurnAroundTime=turnAroundTime+totalTurnAroundTime;
            System.out.print("P"+(c+1)+" | "+finishedTime+" | ");
            System.out.println();
        }
        System.out.println("Total waiting time :"+totalWaitingTime);
        averageWaitingTime=totalWaitingTime/processes.length;
        System.out.println("Average waiting time :"+averageWaitingTime);
         System.out.println("Total Turnaround time :"+totalTurnAroundTime);
        averageTurnaroundTime=totalTurnAroundTime/processes.length;
        System.out.println("Average Turnaround Time :"+averageTurnaroundTime);
        
        
        
    }
    
}
