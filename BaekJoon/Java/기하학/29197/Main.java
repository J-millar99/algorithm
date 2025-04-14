import java.io.*;
import java.util.*;

public class Main {
	
	static class Pos {
		int x;
		int y;
		Pos (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Set<Pos> set = new HashSet<>();
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			String[] in = br.readLine().split(" ");
			int x = Integer.parseInt(in[0]);
			int y = Integer.parseInt(in[1]);
			
			if (x == 0 || y == 0)
				set.add(new Pos(0, 0));
			else {
				int g = Math.abs(gcd(x, y));
				x /= g;
				y /= g;
				if (x < 0) {
					x = -x;
					y = -y;
				}
				set.add(new Pos(x, y));
			}
		}
		System.out.println(set.size());
		br.close();
	}

	public static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
}