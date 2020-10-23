package bankersalgonew;
import java.io.*;
import java.util.*;
/**
 *
 * @author BRACU\12201027
 */
public class BankersAlgoNew {
    public static void main(String[] args) throws Exception {
        BufferedReader b=new BufferedReader(new FileReader("file.txt"));
        int c1=Integer.parseInt(b.readLine());
        int c2=Integer.parseInt(b.readLine());
        int [][]max=new int[c1][c2];
        int [][]allocation=new int[c1][c2];
        int [][]need=new int[c1][c2];
        int [][]avail=new int[c1+1][c2];
        for(int i=0;i<c1;i++)
        {
            String s=b.readLine();
            StringTokenizer st=new StringTokenizer(s," ");
            for(int j=0;j<c2;j++)
            {
                max[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<c1;i++)
        {
            String s=b.readLine();
            StringTokenizer st=new StringTokenizer(s," ");
            for(int j=0;j<c2;j++)
            {
                allocation[i][j]=Integer.parseInt(st.nextToken());
                need[i][j]=max[i][j]-allocation[i][j];
            }
        }
        System.out.print("Need Matrix:");
        for(int i=0;i<c1;i++)
        {
            System.out.println();
            for(int j=0;j<c2;j++)
            {
                System.out.print(need[i][j]);
            }
        }
        System.out.println();
        String s=b.readLine();
        StringTokenizer st=new StringTokenizer(s," ");
        LinkedList sl=new LinkedList();
        
        int c3=0;
        while(st.hasMoreTokens())
        {
            avail[0][c3]=Integer.parseInt(st.nextToken());
            c3++;
        }
       
       c3=0;
       for(int i=0;;i++)
       {
           i=i%c1;
           boolean t=true;
           for(int j=0;j<c2;j++)
           {
               if(need[i][j]<=avail[c3][j])
               {
                   
               }
               else
               {
                  t=false;
                  break;
               }
               if(t&&j==(c2-1)&&!sl.contains(i))
               {
                   for(int g=0;g<c2;g++)
                   {
                       avail[c3+1][g]=avail[c3][g]+allocation[i][g];
                       
                       
                   }
                   sl.addLast(i);
                   c3++;
               }
           }
           if(sl.size()==c1)
           {
               break;
           }
       }
    
        System.out.println("Safe Sequence:");
        for(int i=0;i<sl.size();i++)
        {
            System.out.print(Character.toString((char)((int)sl.get(i)+65))+" ");
           
        }
        System.out.println();
        System.out.print("Change in available resource matrix : ");
        for(int y=1;y<avail.length;y++)
        {
           System.out.println();
           for(int y1=0;y1<c2;y1++)
           {
               System.out.print(avail[y][y1]);
           }
       }
        System.out.println();
        
    }
    
}
