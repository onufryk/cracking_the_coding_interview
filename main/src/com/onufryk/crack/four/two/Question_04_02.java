/*
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
package com.onufryk.crack.four.two;

import java.util.ArrayList;

class Vertice {
	public Integer value = null;
	public Boolean visited = false;
	public ArrayList<Vertice> outbound = new ArrayList<>();
	
	public Vertice(Integer value) {
		this.value = value;
		this.visited = false;
	}
	
}

class Graph {
	public int count = 0;
	public ArrayList<Vertice> vertices = new ArrayList<>();
	
	public Graph() {
	}
	public Graph add(Vertice vertice) {
		this.vertices.add(vertice);		
		return this;
	}

	public Graph link(Vertice from, Vertice to) {
		from.outbound.add(to);
		return this;
	}
	
	public void searchInDepth(Vertice start, Vertice check) {
		this.count++;
		start.visited = true;
		for (Vertice c : start.outbound) {
			if (c == check) {
				c.visited = true;
				return;
			}
			if (c.visited) {
				continue;
			}
			this.searchInDepth(c, check);
		}
	}
	
	public void reset() {
		for (Vertice v : this.vertices) {
			v.visited = false;
		}
		this.count = 0;
	}
	
	public Boolean areConnected(Vertice from, Vertice to) {
		this.reset();
		this.searchInDepth(from, to);
		return to.visited;
	}

	@Override
	public String toString() {
		StringBuffer output = new StringBuffer();
		
		for (Vertice v : vertices) {
			output.append("Vertice : " + v.value);
			output.append((v.visited?" VISITED ":" not visited ") + "\n");
			
			if (v.outbound != null && !v.outbound.isEmpty()) {
				output.append("Links:\n");
				for (Vertice o : v.outbound) {
					output.append("     to : " + o.value + "\n");
				}
			} else {
				output.append("No outbound edges\n");
			}
			
			output.append("\n");
		}
		
		return output.toString();
	}
	
	
}

public class Question_04_02 {

	public static void main(String[] args) {
		Vertice v1 = new Vertice(1);
		Vertice v2 = new Vertice(2);
		Vertice v3 = new Vertice(3);
		Vertice v4 = new Vertice(4);
		Vertice v5 = new Vertice(5);
		Vertice v6 = new Vertice(6);
		
		Graph graph = new Graph().add(v1).add(v2).add(v3).add(v4).add(v5).add(v6);
		
		graph.link(v1, v2).link(v1, v3).link(v4, v5).link(v5, v6).link(v4, v6);
//		graph.link(v6, v1);
//		graph.link(v3, v4);

		System.out.println(graph.areConnected(v1, v3));
		System.out.println(graph.areConnected(v1, v4));
		System.out.println(graph.areConnected(v4, v6));
		System.out.println(graph.areConnected(v4, v1));
		System.out.println(graph.areConnected(v1, v6));
	}

}
