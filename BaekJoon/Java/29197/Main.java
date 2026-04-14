import java.io.*;
import java.util.*;

public class Main {
	static class Pos {
		double x;
		double y;
		Pos (double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Pos> u = new ArrayList<>();
		List<Pos> d = new ArrayList<>();
		List<Pos> r = new ArrayList<>();
		List<Pos> l = new ArrayList<>();
		List<Pos> q1 = new ArrayList<>();
		List<Pos> q2 = new ArrayList<>();
		List<Pos> q3 = new ArrayList<>();
		List<Pos> q4 = new ArrayList<>();

		int num = Integer.parseInt(br.readLine());
		double x, y;
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			x = Double.parseDouble(st.nextToken()); // 학생의 x좌표
			y = Double.parseDouble(st.nextToken()); // 학생의 y좌표
			
			if (x == 0 && y > 0)
				u.add(new Pos(x, y));
			else if (x == 0 && y < 0)
				d.add(new Pos(x, y));
			else if (x > 0 && y == 0)
				r.add(new Pos(x, y));
			else if (x < 0 && y == 0)
				l.add(new Pos(x, y));
			else if (x > 0 && y > 0)
				q1.add(new Pos(x, y));
			else if (x < 0 && y > 0)
				q2.add(new Pos(x, y));
			else if (x < 0 && y < 0)
				q3.add(new Pos(x, y));
			else if (x > 0 && y < 0)
				q4.add(new Pos(x, y));
		}

		int count = 0;
		if (u.size() > 0)
			count++;
		if (d.size() > 0)
			count++;
		if (r.size() > 0)
			count++;
		if (l.size() > 0)
			count++;

		HashSet<Double> set = new HashSet<>();
		for (Pos pos : q1) {
			set.add(pos.y / pos.x);
		}
		count += set.size();

		set = new HashSet<>();
		for (Pos pos : q2) {
			set.add(pos.y / pos.x);
		}
		count += set.size();

		set = new HashSet<>();
		for (Pos pos : q3) {
			set.add(pos.y / pos.x);
		}
		count += set.size();

		set = new HashSet<>();
		for (Pos pos : q4) {
			set.add(pos.y / pos.x);
		}
		count += set.size();
		System.out.println(count);
		br.close();
	}
}