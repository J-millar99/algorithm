import java.io.*;
import java.util.*;

public class Main {
	
	// 학생의 좌표를 저장하는 클래스
	public static class Cordinate {
		double x, y;
		
		public Cordinate(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); // 학생들의 수
		
		List<Cordinate> u = new LinkedList<>(); // 위쪽
		List<Cordinate> d = new LinkedList<>(); // 아래쪽
		List<Cordinate> r = new LinkedList<>(); // 왼쪽
		List<Cordinate> l = new LinkedList<>(); // 오른쪽
		List<Cordinate> ul = new LinkedList<>(); // 위오른쪽
		List<Cordinate> ur = new LinkedList<>(); // 위왼쪽
		List<Cordinate> dl = new LinkedList<>(); // 아래오른쪽
		List<Cordinate> dr = new LinkedList<>(); // 아래왼쪽
		
		double x, y;
		StringTokenizer st;
		while(n-- > 0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()); // 학생의 x좌표
			y = Integer.parseInt(st.nextToken()); // 학생의 y좌표
			
			// 해당하는 좌표 위치에 맞게 리스트 저장.
			if (x == 0 && y > 0) {
				u.add(new Cordinate(x, y));
			} else if (x == 0 && y < 0) {
				d.add(new Cordinate(x, y));
			} else if (x > 0 && y == 0) {
				l.add(new Cordinate(x, y));
			} else if (x < 0 && y == 0) {
				r.add(new Cordinate(x, y));
			} else if (x > 0 && y > 0) {
				ul.add(new Cordinate(x, y));
			} else if (x > 0 && y < 0) {
				dl.add(new Cordinate(x, y));
			} else if (x < 0 && y > 0) {
				ur.add(new Cordinate(x, y));
			} else {
				dr.add(new Cordinate(x, y));
			}
		}
		
		int count = 0;
		
		// 일직선 상에 있는 인원은 한명 밖에 안보인다.
		if (u.size() > 0) {
			count++;
		}
		
		if (d.size() > 0) { 
			count++;
		}
		
		if (l.size() > 0) {
			count++;
		}
		
		if (r.size() > 0) {
			count++;
		}
		
		// 평면 위에 있는 인원은 각자 방향의 기울기를 통해 보이는 인원 확인
		HashSet<Double> set = new LinkedHashSet<>();
		for (Cordinate co : ul) {
			set.add(Math.abs(co.y) / Math.abs(co.x));
		}
		
		count += set.size();
		
		set = new LinkedHashSet<>();
		for (Cordinate co : ur) {
			set.add(Math.abs(co.y) / Math.abs(co.x));
		}
		
		count += set.size();
		
		set = new LinkedHashSet<>();
		for (Cordinate co : dl) {
			set.add(Math.abs(co.y) / Math.abs(co.x));
		}
		
		count += set.size();
		
		set = new LinkedHashSet<>();
		for (Cordinate co : dr) {
			set.add(Math.abs(co.y) / Math.abs(co.x));
		}
		
		count += set.size();
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}
}