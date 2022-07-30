package algorithm;

import java.util.*;
import queue.LinkedQueue;

public class test {
	
	public static boolean[] visited1 = new boolean[9];
	public static boolean[] visited2 = new boolean[9];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void dfs(int x) {
		visited1[x] = true;
		System.out.print(x + " ");
		for (int i = 0; i < graph.get(x).size(); i++) {
			int k = graph.get(x).get(i);
			if (!visited1[k])
				dfs(k);
		}
	}
	
	public static void bfs(int start) {
		LinkedQueue<Integer> q = new LinkedQueue<>();
		q.enqueue(start);
		visited2[start] = true;
		
		while (!q.isEmpty()) {
			int x = q.dequeue();
			System.out.print(x + " ");
			for (int i = 0; i < graph.get(x).size(); i++) {
				int k = graph.get(x).get(i);
				if (!visited2[k]) {
					visited2[k] = true;
					q.enqueue(k);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 노드 1에 연결된 노드 정보 저장 
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        
        // 노드 2에 연결된 노드 정보 저장 
        graph.get(2).add(1);
        graph.get(2).add(7);
        
        // 노드 3에 연결된 노드 정보 저장 
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        // 노드 4에 연결된 노드 정보 저장 
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        // 노드 5에 연결된 노드 정보 저장 
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        // 노드 6에 연결된 노드 정보 저장 
        graph.get(6).add(7);
        
        // 노드 7에 연결된 노드 정보 저장 
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        // 노드 8에 연결된 노드 정보 저장 
        graph.get(8).add(1);
        graph.get(8).add(7);

        dfs(1);
        System.out.println();
        bfs(1);
	}
}
