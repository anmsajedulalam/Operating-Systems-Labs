/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankersalgo;
import java.io.*;
import java.util.*;
/**
 *
 * @author BRACU\12201027
 */
public class BankersAlgo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BufferedReader k=new BufferedReader(new FileReader("file.txt"));
        int row=Integer.parseInt(k.readLine());
        int col=Integer.parseInt(k.readLine());
        int [][]max=new int[row][col];
        int [][]allocation=new int[row][col];
        int [][]need=new int[row][col];
        int [][]avail=new int[row+1][col];
        for(int i=0;i<row;i++)
        {
            String go=k.readLine();
            StringTokenizer goal=new StringTokenizer(go," ");
            for(int j=0;j<col;j++)
            {
                max[i][j]=Integer.parseInt(goal.nextToken());
            }
        }
        for(int i=0;i<row;i++)
        {
            String done=k.readLine();
            StringTokenizer goal=new StringTokenizer(done," ");
            for(int j=0;j<col;j++)
            {
                allocation[i][j]=Integer.parseInt(goal.nextToken());
                need[i][j]=max[i][j]-allocation[i][j];
            }
        }
        System.out.print("need");
        for(int i=0;i<row;i++)
        {
            System.out.println();
            for(int j=0;j<col;j++)
            {
                System.out.print(need[i][j]);
            }
        }
        System.out.println();
        String poor=k.readLine();
        StringTokenizer prince=new StringTokenizer(poor," ");
        LinkedList link=new LinkedList();
        
        int newCount=0;
        while(prince.hasMoreTokens())
        {
            avail[0][newCount]=Integer.parseInt(prince.nextToken());
            newCount++;
        }
       
       newCount=0;
       for(int i=0;;i++)
       {
           i=i%row;
           boolean finish=true;
           for(int j=0;j<col;j++)
           {
               if(need[i][j]<=avail[newCount][j])
               {
                   
               }
               else
               {
                  finish=false;
                  break;
               }
               if(finish&&j==(col-1)&&!link.contains(i))
               {
                   for(int g=0;g<row;g++)
                   {
                       avail[newCount+1][g]=avail[newCount][g]+allocation[i][g];
                       
                       
                   }
                   link.addLast(i);
                   newCount++;
               }
           }
           if(link.size()==row)
           {
               break;
           }
       }
    
        System.out.println("safeSequence");
        for(int i=0;i<link.size();i++)
        {
            System.out.print(Character.toString((char)((int)link.get(i)+65))+" ");
           
        }
        System.out.println();
        System.out.print("updatesInAvailable");
        for(int y=1;y<avail.length;y++)
        {
           System.out.println();
           for(int y1=0;y1<row;y1++)
           {
               System.out.print(avail[y][y1]);
           }
       }
        System.out.println();
        
    }
    
}
