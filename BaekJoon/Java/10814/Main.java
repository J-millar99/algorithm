import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int age;
        String name;
        Pair(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        ArrayList<Pair> arr = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String[] in = br.readLine().split(" ");
            Pair pair = new Pair(Integer.parseInt(in[0]), in[1]);
            arr.add(pair);
        }
        
        arr.sort(Comparator.comparing((Pair p) -> p.age)); // 페어에서 특정 요소르 기준으로 정렬
        StringBuilder sb = new StringBuilder();
        for (Pair pair : arr)
            sb.append(pair.age).append(" ").append(pair.name).append("\n");
        System.out.print(sb);
        br.close();
    }
}
