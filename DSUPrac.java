package naman123;

import java.util.Arrays;

class DSU2{
	int n;
	int[] parent;
	int[] size;
	int[] rank;
	
	public DSU2(int n) {
		this.n = n;
		parent = new int[n];		
		size = new int[n];
		rank = new int[n];
		
		for(int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
			rank[i] = 0;
		}			
		
	}
	
	int findUltP(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findUltP(parent[x]);
	}
	
	public void union(int x, int y) {
		int ultPX = findUltP(x);
		int ultPY = findUltP(y);
		
		if(ultPX == ultPY) {
			return;
		}
		
		if(size[ultPX] > size[ultPY]) {
			size[ultPX] += size[ultPY];
			parent[ultPY] = ultPX;
		} else {
			size[ultPY] += size[ultPX];
			parent[ultPX] = ultPY;		
		}
		
	}
	
	public void unionByRank(int x, int y) {
		int ultPX = findUltP(x);
		int ultPY = findUltP(y);
		
		if(ultPX == ultPY) {
			return;
		}
		
		if(rank[ultPX] > rank[ultPY]) {
			rank[ultPX]++;
			parent[ultPY] = ultPX;
		} else {
			rank[ultPY]++;
			parent[ultPX] = ultPY;		
		}
		
	}
	
	
}

public class DSUPrac {
	public static void main(String[] args) {
		DSU2 ds = new DSU2(5);
		ds.unionByRank(0, 2);
		ds.unionByRank(2, 3);
		
		ds.unionByRank(4, 1);
		
		System.out.println(Arrays.toString(ds.parent));
	}
}
