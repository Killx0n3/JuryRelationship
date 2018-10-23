package jury;

import java.util.ArrayList;

/*This class relates to the second relationship in the assignment.
 * You have to create a new graph from original direct relation graph. 
 * The graph size will be the same as the original direct relation graph. The degree 
 * of a vertex is the number of edges incident on it. It is the same as the length of 
 * the adjacency list. So you have to compute the adjacency list of each vertex. The field candidate_List2
 * will contain the vertices (Candidates) and their respective adjacency list. 
 */
public class Jury_Relation2Graph {
	int graphSize = 0;
	ArrayList<Candidate> candidate_List2;
	int[] degreeArr;
	int[][] finalProduct;
	/*This variable gives the degree of each vertex in the graph. 
	 * The constructor takes the original graph as input and constructs the new
	 * graph. The two graphs have the same size. 
	 */
	public Jury_Relation2Graph(String s) {
		JuryGraph jG1 = new JuryGraph(s);
		graphSize = jG1.graph_Size;
		candidate_List2 = makeRelation2Graph(jG1);
		degreeArr = computeDegrees(candidate_List2);

	}
	ArrayList<Candidate> makeRelation2Graph(JuryGraph jG){
		ArrayList<Candidate> canList2 = new ArrayList<>();
		
		int graph2[][] = new int[jG.graph_Size][jG.graph_Size];
		
		for (int i=0; i<jG.graph_Size; i++)
			for (int j=0; j<jG.candidate_List.get(i+1).adj_List.size(); j++) {
				graph2[i][jG.candidate_List.get(i+1).adj_List.get(j).id-1] = 1;
			}
		

		int[][] product = multiplyMatrices(graph2, graph2, graph2[0].length, graph2[0].length, graph2[0].length);
		finalProduct = addMatrices(graph2, product, graph2[0].length);
		
		canList2.add(new Candidate(0));
		for (int i=0; i<finalProduct[0].length; i++) {
			Candidate c = new Candidate(i+1);
			for (int j=0; j<finalProduct[0].length; j++) {
				if(i!=j)
					if(finalProduct[i][j]!=0) {
						c.adj_List.add(new Candidate(j+1));
					}
			}
			canList2.add(c);
			
		}
		/*
		 * The input is graph representing direct relations among
		 * candidates. You have to make new adjacency lists for each vertex reflecting 2-relations.
		 */
		return canList2;
	}
	
	public static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix, int r1, int c1, int c2) {
        int[][] product = new int[r1][c2];
        for(int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
                if (product[i][j]>0)
                		product[i][j]=1;
            }
        }

        return product;
    }
	
	public int[][] addMatrices(int[][] firstMat, int[][] secondMat, int r){
		int[][] pro = new int[r][r];
		for (int i=0; i<r; i++) {
			for (int j=0; j<r; j++) {
				pro[i][j] = firstMat[i][j]+secondMat[i][j];
				if (pro[i][j]>0)
            		pro[i][j]=1;
			}
		}
		return pro;
	}
	
	int[]  computeDegrees(ArrayList<Candidate> cList2) {
		int[] degAr = new int[graphSize];
		
		for (int i=0; i<graphSize; i++) {
			degAr[i]=cList2.get(i+1).adj_List.size();
		}
		/*
		 * It is quite straightforward to compute array
		 * entries from the adjacency list of vertices. Use the "size()" function of 
		 * ArrayList class. 
		 */
		return degAr;
	}

}
