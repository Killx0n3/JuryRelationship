package jury;

import java.util.ArrayList;

public class Candidate {
	int id;
	ArrayList<Candidate> adj_List;
	public Candidate (int id) {
		adj_List = new ArrayList<Candidate>();
		this.id = id;
	}
}


//Author: Tanvir Hossain