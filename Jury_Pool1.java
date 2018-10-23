package jury;

import java.util.ArrayList;

public class Jury_Pool1 {
int initialSize = 0;
int juryPoolSize = 0;
int[] juryPoolList;

/*In the constructor below a string is passed as parameter to first 
 * The variable "initialSize" represents the size of the initial list of candidates.
 * The variable "juryPoolSize" is the size of the final pool of potential jurors without any 'relationship' 
 * in the first sense. This number is unique for a given input list of candidates. 
 * The variable "juryPoolList" is an integer array containing a list of potential juror id's. These lists 
 * can vary. But of course they must all satisfy the basic criterion that there is no 'relationship' 
 * (in the first sense) between any pair. 
 * The class JuryGraph represents the basic graph of direct relations. 
 */

public Jury_Pool1(String s) {
	JuryGraph candidateRelation = new JuryGraph(s);
	
	/*
	 The string 's' represents the path to the input file.
	 */
	
	initialSize = candidateRelation.graph_Size;
	juryPoolSize = calcPoolsize(candidateRelation);
	juryPoolList = calcPoolList(candidateRelation);
	System.out.println(juryPoolSize);
	System.out.println("");
	for (int i = 0; i < juryPoolList.length; i++) {
		System.out.println(juryPoolList[i]);
	}
}
public ArrayList<Integer> calculate (JuryGraph jG){
int graph[][] = new int[jG.graph_Size][jG.graph_Size];
	
	for (int i=0; i<jG.graph_Size; i++)
		for (int j=0; j<jG.candidate_List.get(i+1).adj_List.size(); j++) {
			graph[i][jG.candidate_List.get(i+1).adj_List.get(j).id-1] = 1;
		}
		
	GraphClosure g = new GraphClosure(jG.graph_Size);
    g.transitiveClosure(graph);
    
    
    ArrayList<Integer> al = new ArrayList<Integer>();
    for (int i=0; i<graph[0].length; i++) {
		for (int j=0; j<graph[0].length; j++) {
			if (i!=j) {
				if(graph[i][j]==1 && al.contains(i+1)==false) {

					al.add(j+1);
					
				}
			}
		}	
		
	}
    ArrayList<Integer> jList = new ArrayList<Integer>();	
    for (int j = 1; j <= jG.graph_Size; j++) {
		if (!al.contains(jG.candidate_List.get(j).id))
			jList.add(jG.candidate_List.get(j).id);
		
    }	
    
	return jList;
}
int calcPoolsize(JuryGraph jG) {
	int poolSize = 0;

	/*
	The variable poolSize is given as a suggestion. You are free to change it if you wish.
	Of course you have to return some variable of integer type. It has been initialized to 0.  
	Note: 0 is not an acceptable value for the jury pool size. 
	You can write any other classes and methods 
	to help you calculate. 
	*/
	poolSize = calculate(jG).size();
	return poolSize;
}
int[] calcPoolList(JuryGraph jG) {
	int[] poolList = new int[juryPoolSize];
	/*
	 * We have an integer array poolList. To create this array you will have to calculate 
	 * juryPoolSize first. You can change it. But make sure the function returns an array 
	 * of integers that represents an acceptable jury pool. 
	 * It is suggested that you create some classes and methods of your own and call them here. This 
	 * method and the one preceding can be considered 'wrapper' methods. 
	 */
	ArrayList<Integer> x = calculate(jG);
	for (int i=0; i<juryPoolSize; i++)
		poolList[i] = x.get(i);
	return poolList;
}
}
