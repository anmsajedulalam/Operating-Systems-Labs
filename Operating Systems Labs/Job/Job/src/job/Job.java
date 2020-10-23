/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package job;

/**
 *
 * @author 12201027
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
public class Job {
    String lineParser;
    String[] job;
    int[] time;
    int[] priority;
    /**
     * @param args the command line arguments
     */
    Job()
    {
        int count = 0;
        
        File file=new File("File.txt");  
	Scanner kb;
        Scanner kb2;
        
        try {
            
            kb = new Scanner(file);
            kb2 = new Scanner(file);
            while(kb.hasNextLine())
            {
                lineParser=kb.nextLine();
                count++;
                
            }
            job = new String[count];
            time = new int[count];
            priority = new int[count];
            count =0;
            while(kb2.hasNextLine())
            {
                lineParser=kb2.nextLine();
                String[] brk = lineParser.split(",");
                job[count]=brk[0];
                time[count]=Integer.parseInt(brk[1]);
                priority[count]=Integer.parseInt(brk[2]);
                count++;
                
            }
        }catch(Exception e)
        {
            
        }
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Job j = new Job();
        j.roundRobin();
        System.out.println();
        j.priorityMethod();
        System.out.println();
        j.FCFS();
        System.out.println();
        j.SJF();
    }
    
    public void FCFS() 
    {
        int timer = 0;
        System.out.println("FCFS");
        for(int i=0; i<job.length; i++)
        {
            System.out.print(job[i]+" : ");
            timer = timer + time[i];
            System.out.println(timer);
        }
    }
    
    public void priorityMethod()
    {
        System.out.println("Priority Scheduling");
        int[] dup = new int[job.length];
        for(int i=0; i<job.length; i++)
        {
            dup[i] = priority[i];
        }
        
        int max=0;
        int index=0;
        int timer=0;
        
        for(int i=0; i<job.length; i++)
        {
            max=0;
            for(int j=0; j<job.length; j++)
            {
                if(dup[j]>max)
                {
                    max = dup[j];
                    index=j;
                }
            }
            System.out.print(job[index]+" : ");
            timer = timer+ time[index];
            System.out.println(timer);
            dup[index]=-99999;
        }
    }
    
    
    public void SJF()
    {
        System.out.println("SJF");
        int[] dup = new int[job.length];
        for(int i=0; i<job.length; i++)
        {
            dup[i] = time[i];
        }
        
        int min=0;
        int index=0;
        int timer=0;
        
        for(int i=0; i<job.length; i++)
        {
            min=Integer.MAX_VALUE;
            for(int j=0; j<job.length; j++)
            {
                if(dup[j]<min)
                {
                    min = dup[j];
                    index=j;
                }
            }
            System.out.print(job[index]+" : ");
            timer = timer+ time[index];
            System.out.println(timer);
            dup[index]=Integer.MAX_VALUE;
        }
    }
    
    public void roundRobin()
    {
        System.out.println("Round Robin");
        int[] dup = new int[job.length];
        int timer=0;
        for(int i=0; i<job.length; i++)
        {
            dup[i] = time[i];
        }
        
        while(true)
        {
            for(int i=0; i<job.length;i++)
            {
                if(dup[i]>=0)
                {
                dup[i]--;
                timer++;
                }
            }
            
            for(int i=0; i<job.length; i++)
            {
                if(dup[i]==0)
                {
                    System.out.print(job[i]+" : ");
                    System.out.println(timer);
                    dup[i]=-99999;
                }
            }
            int check=0;
            for(int i=0; i<job.length;i++)
            {
                if(dup[i]>=0)
                {
                    check=1;
                }
            }
            if(check==0)
            {
                break;
            }
        }
    }
    
}
