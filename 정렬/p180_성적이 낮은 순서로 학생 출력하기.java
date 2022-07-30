package algorithm;

import java.util.*;

class Score implements Comparable<Score> {
	public int score;
	public String name;
	
	public Score(String n, int s) {
		score = s;
		name = n;
	}
	
	@Override
	public int compareTo(Score other) {
		if (this.score < other.score)
			return -1;
		return 1;
	}
}

public class test {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		s.nextLine();
		List<Score> student = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] str = s.nextLine().split(" ");
			Score ss = new Score(str[0], Integer.parseInt(str[1]));
			student.add(ss);
		}
		
		Collections.sort(student);
		
		for (int i = 0; i < n; i++)
			System.out.print(student.get(i).name + " ");
		
	}
}
