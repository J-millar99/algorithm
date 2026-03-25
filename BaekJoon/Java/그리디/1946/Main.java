import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static class Person implements Comparable<Person> {
        int a, b;

        Person(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Person o) {
            if (this.a != o.a)
                return this.a - o.a;
            return this.b - o.b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            int n = Integer.parseInt(br.readLine());
            Person[] arr = new Person[n];
            for (int j = 0; j < n; j++) {
                String[] in = br.readLine().split(" ");

                int a, b;
                a = Integer.parseInt(in[0]);
                b = Integer.parseInt(in[1]);
                arr[j] = new Person(a, b);
            }
            Arrays.sort(arr);

            int pivot = arr[0].b;
            int count = 1;
            for (int j = 1; j < n; j++) {
                if (arr[j].b < pivot) {
                    pivot = arr[j].b;
                    count++;
                }
            }
            System.out.println(count);
        }
        br.close();
    }
}