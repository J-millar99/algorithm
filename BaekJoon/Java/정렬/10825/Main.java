import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static class Student {
        int language, english, mathematics;
        String name;
        Student(String name, int language, int english, int mathematics) {
            this.name = name;
            this.language = language;
            this.english = english;
            this.mathematics = mathematics;
        }

    }
    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());

        List<Student> arr = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String[] in = br.readLine().split(" ");
            arr.add(new Student(in[0],  // 이름
            Integer.parseInt(in[1]),    // 국어
            Integer.parseInt(in[2]),    // 영어
            Integer.parseInt(in[3])));  // 수학
        }

        arr.sort(Comparator.comparing((Student s) -> s.language).reversed()
                .thenComparing((Student s) -> s.english)
                .thenComparing(Comparator.comparing((Student s) -> s.mathematics).reversed()) // 수학에서 개별적으로 역 정렬
                .thenComparing((Student s) -> s.name));
        
        for (Student student : arr) {
            sb.append(student.name).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}