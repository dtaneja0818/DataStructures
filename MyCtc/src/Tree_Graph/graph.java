package Tree_Graph;

import java.util.*;

class Neighbour{
	public int vertexNum;
	public Neighbour next;
	public Neighbour(int vnum,Neighbour nbr){
		this.vertexNum=vnum;
		next=nbr;
	}
}

class Vertex {
	String name;
	Neighbour adjList;
	Vertex(String name,Neighbour nbrs){
		this.name=name;
		this.adjList=nbrs;
	}
}

public class graph {
	
	Vertex[] adjLists;
	public graph(int vnum){
		adjLists=new Vertex[vnum];
		Scanner in=new Scanner(System.in);
		System.out.println("enter the vertex names\n");
		for(int v=0;v<adjLists.length;v++){
			String name=in.nextLine();
			adjLists[v]=new Vertex(name,null);
		}
	}
	//read edges
	public void addEdge(String v1name,String v2name){
		int v1=indexForName(v1name);
		int v2=indexForName(v2name);
		adjLists[v1].adjList=new Neighbour(v2,adjLists[v1].adjList);
		//if undirected add below stmt as well
		//adjLists[v2].adjList=new Neighbour(v1,adjLists[v2].adjList);
	}
	//below function returns the index of the vertex in the adj list
	public int indexForName(String str) {
		for(int v=0;v<adjLists.length;v++){
			if(adjLists[v].name.equals(str))
				return v;
		}
		return -1;
	}
	public void print(){
		System.out.println();
		for(int v=0;v<adjLists.length;v++){
			System.out.println(adjLists[v].name);
			for(Neighbour nbr=adjLists[v].adjList;nbr!=null;nbr=nbr.next){
				System.out.println("-->"+adjLists[nbr.vertexNum].name);
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number of vertices");
		int n=sc.nextInt();
		graph g=new graph(n);
		g.addEdge("A", "B");
		g.addEdge("A", "C");
		g.addEdge("B", "C");
		g.addEdge("C", "D");
		g.print();
		
	}
}