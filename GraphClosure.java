package jury;


import java.util.*;
import java.lang.*;
import java.io.*;

class GraphClosure
{
	static int V; 
	public GraphClosure(int size) {
		V = size;
	}
 

 void transitiveClosure(int graph[][])
 {
     int reach[][] = new int[V][V];
     int  i, j, k;

     for (i = 0; i < V; i++)
         for (j = 0; j < V; j++)
             reach[i][j] = graph[i][j];

     for (k = 0; k < V; k++)
     {
         for (i = 0; i < V; i++)
         {

             for (j = 0; j < V; j++)
             {

                 reach[i][j] = (reach[i][j]!=0) ||
                          ((reach[i][k]!=0) && (reach[k][j]!=0))?1:0;
             }
         }
     }

     for (int i2=0; i2<graph[0].length; i2++) {
 		for (int j2=0; j2<graph[0].length; j2++) {
 			graph[i2][j2]=reach[i2][j2];
 		}
 		
 	}
     
 }


 void printSolution(int reach[][])
 {
     for (int i = 0; i < V; i++)
     {
         for (int j = 0; j < V; j++)
             System.out.print(reach[i][j]+" ");
         System.out.println();
     }
 }

}
