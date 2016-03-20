package maze_assignment;

import java.io.BufferedReader;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class maain {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		int [][]a=CreateMaze();
		
		/*for(int i=0;i<a.length;i++)
		{
			
			for(int j=0;j<5;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}*/
		traversal(a);
	
	}
	public static void traversal(int[][] a) throws Exception{
		
		
		String str="";
		int j,row,col,len;
		String[] s=null;
		BufferedReader br;
	
	    br = new BufferedReader(new FileReader("TraverseMaze.txt"));	
      
	
	    while( (str = br.readLine()) != null)
        {
		
            s = str.split(" ");
            len=s.length;
            int[] t=new int[len];
            int i=0;
            row=Integer.parseInt(s[0]);
            for(j=1;j<len;j++)
            {
            	t[i]=Integer.parseInt(s[j]);
            	i++;
            }
            
            /*
            for(int g=0;g<i;g++)
            {
            	System.out.print(" " +t[g]);
            }*/
            //System.out.println();
            int room=0;
            //TRAVERSING THE 2D ARRAY
            for(col=0;col<len-1;col++)
            {
            	room=a[row-1][t[col]+1];
              	if(room!=0)
            	{
            		row=room;
               	    System.out.print(" "+row);
            		
            	}
            }
            System.out.println();
            System.out.println("last"+row);
           
            PrintWriter fout = null;
            try{
            fout = new PrintWriter(new FileWriter("Destination.txt",true));
            fout.println(row);
            fout.close();
            }
            catch(Exception e)
            {
            	System.out.println(e);
            
	        }
            finally{System.out.println();}
        }
            
	}	
	
	
		public static int[][] CreateMaze() throws Exception{

			
			int[][] a=new int[20][5];
			String str="";
			int j = 0;
			String[] s=null;
			BufferedReader br;
			
		 br = new BufferedReader(new FileReader("CreateMaze.txt"));	
		
		while( (str = br.readLine()) != null)
	    {
			
	            s = str.split(" ");
	           for(int i=0;i<s.length;i++)
	            {
	        		//System.out.println(s[i]);
	        		a[j][i]=Integer.parseInt(s[i]);
	        		
	        	}
	            j++;
	    }
		int[][] create=new int[j][5];
		for(int f=0;f<j;f++){
			for(int h=0;h<5;h++){
			create[f][h]=a[f][h];
			}
		}
	
		br.close();
	  return create;
	  }


	}



