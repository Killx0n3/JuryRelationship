/*
 * The structure of this class is similar to the Jury_Pool1 class. There are two crucial differences. 
 * You have to use a new graph reflecting 2-relationship. 
 * You have to compute 3 fields. The first field easy it is simply the original graph size.
 * The second field is the size of the pool of potential jurors and the third field is a list of juror 
 * id's satisfying the condition that there is no 2-relations between any two. These fields are exactly 
 * like the corresponding fields in Jury_Pool1. The names are slightly modified. 
 */
package jury;

import java.util.ArrayList;

import org.omg.CORBA.ObjectHolder;

public class Jury_Pool2 {
	int initialSize = 0;
	int juryPool2Size = 0;
	int[] juryPool2List;
	
	public Jury_Pool2(String s) {
		Jury_Relation2Graph candidateRelation = new Jury_Relation2Graph(s);
		
		/*
		 The string 's' represents the path to the input file.
		 */
		
		initialSize = candidateRelation.graphSize;
		juryPool2Size = calcPool2size(candidateRelation);
		juryPool2List = calcPool2List(candidateRelation);
	}
	
	public int findMinIdx (int input[], ArrayList<Integer> ignore) {
		int min = -1;
		int minIdx = -1;
		
		if (ignore.size()==0) {
			min = input[0];
			minIdx = 0;
		}
		
		
		for (int i = 0; i < input.length; i++) {
			if(!ignore.contains(i) && input[i]!=0) {
				min = input[i];
				minIdx = i;
				break;
			}
		}

		for (int i = 0; i < input.length; i++) {
			if ((!ignore.contains(i)) && (input[i] != 0 && input[i] <min)) {

				min = input[i];
				minIdx = i;
			}
				
		}
		return minIdx;
	}
	boolean isCut(int[][] arr, int n) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[n][i]!=-1)
				return false;
		}
		return true;
	}
	public int findMinMat (int [][] arr) {
		int minIdx = 0;
		int minSum=0;
		boolean firstTime = true;
		for (int i = 0; i < arr[0].length; i++) {
			if(isCut(arr, i)) {
			
				continue;
			}
				
			int sum = 0;
			for (int j = 0; j < arr[0].length; j++) {

				if(i!=j) {
					if(arr[i][j]==-1)
						sum+=0;
					else
						sum+=arr[i][j];
				}

			}
			if (sum==0) {
				continue;
			}
			if(firstTime) {
				minSum = sum;
				minIdx = i;
				firstTime=false;
			}
			else {
				if (minSum==0) {
					minSum = sum;
				}
				if(sum<minSum) {
					minSum = sum;
					minIdx = i;
				}
			}

		}
		return minIdx;
	}
	
	public void cutTheMat(int arr[][], int n) {
		for (int j = 0; j < arr[0].length; j++) {
			arr[n][j]=-1;
		}
		for (int j = 0; j < arr[0].length; j++) {
			arr[j][n]=-1;
		}
	}
	
	public ArrayList<Integer> calculate (Jury_Relation2Graph jG){
		    

			int bal[][] = new int[jG.finalProduct[0].length][jG.finalProduct[0].length];
			for (int i=0; i<jG.finalProduct[0].length; i++) {
				for (int j = 0; j < jG.finalProduct[0].length; j++) {
					bal[i][j] = jG.finalProduct[i][j];
					
				}
			}
			
		    
		    for (int i=0; i<bal[0].length; i++) {
		    		int min = findMinMat(bal);
		    		
		    		for (int j = 0; j < bal[0].length; j++) {
						if(min!=j && bal[min][j]==1) {
							cutTheMat(bal, j);
						}
					}
		    }

		    
		    ArrayList<Integer> jList = new ArrayList<Integer>();	
		    
		    for (int i=0; i<bal[0].length; i++) {
				for (int j=0; j<bal[0].length; j++) {
					if(bal[i][j]==1)
						jList.add(i+1);
				}
				
			}

			return jList;
		}
	
	int calcPool2size(Jury_Relation2Graph jG) {
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
	int[] calcPool2List(Jury_Relation2Graph jG) {
		int[] poolList = new int[juryPool2Size];
		/*
		 * We have an integer array poolList. To create this array you will have to calculate 
		 * juryPoolSize first. You can change it. But make sure the function returns an array 
		 * of integers that represents an acceptable jury pool. 
		 * It is suggested that you create some classes and methods of your own and call them here. This 
		 * method and the one preceding can be considered 'wrapper' methods. 
		 */
		ArrayList<Integer> x = calculate(jG);
		for (int i=0; i<juryPool2Size; i++)
			poolList[i] = x.get(i);
		return poolList;
	}
	
}
