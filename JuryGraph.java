package jury;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JuryGraph {
	int graph_Size = 0;
	/*size of the graph = number of vertices
	The graph is represented in the adjacency list form. The 'Candidate' class is
	interpreted as vertex. The adjacency list for a candidate X is the list of candidates
	X is related to directly. 
	*/
	ArrayList<Candidate> candidate_List = new ArrayList<>();
	//Constructs initial list of candidates (vertices). 

	public JuryGraph(String file_name) {
		Path fl_path = Paths.get(file_name);
		try {
		Scanner graph_in = new Scanner(fl_path);
		graph_Size = graph_in.nextInt();
		if (graph_Size <= 0) {
			System.out.println("Size of the graph must be positive.");
			graph_in.close();
			return;
		}
		candidate_List = new ArrayList<>(graph_Size+1);
		for (int i = 0; i < graph_Size+1; i++) {
			Candidate candi = new Candidate(i);
			candidate_List.add(i, candi);
		}
		while(graph_in.hasNextLine()) {

		String graph_data = graph_in.nextLine();

		int vertexNo = 0;
		Pattern p = Pattern.compile("-?\\d+");
		Matcher m = p.matcher(graph_data);
		int tmpLabel = 0;
		while (m.find()) {
			int edge_vertex = Integer.parseInt(m.group());
			if(vertexNo == 0) {
				tmpLabel = edge_vertex;
				vertexNo++;
				continue;
			}
			Candidate vert_Adj = candidate_List.get(edge_vertex);
			Candidate vertComp = candidate_List.get(tmpLabel);

			candidate_List.get(tmpLabel).adj_List.add(vert_Adj);
			candidate_List.get(edge_vertex).adj_List.add(vertComp);
		}
		}
		graph_in.close();
		}
		catch (IOException ioException)
		 	{
			System.err.println("Error opening file. Terminating.");
			System.exit(1);
		 	}
	
	}
	void printGraph() {
		for (int i = 1; i < this.graph_Size+1;i++) {
			System.out.print(this.candidate_List.get(i).id+": ");
			for (int j = 0; j < this.candidate_List.get(i).adj_List.size(); j++) {
				System.out.print(this.candidate_List.get(i).adj_List.get(j).id + ",");
			}
			System.out.println('\n');
		}
		
	}

}
//Author: Tanvir Hossain