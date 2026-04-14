import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] distance;
    static int[] fuel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int i = 0;
        distance = new int[num - 1];
        for (String str : input) {
            int value = Integer.parseInt(str);
            distance[i] = value;
            i++;
        }
        input = br.readLine().split(" ");
        i = 0;
        fuel = new int[num];
        for (String str : input) {
            int value = Integer.parseInt(str);
            fuel[i] = value;
            i++;
        }

        int current = 0;
        long cost = 0;
        while (current < num - 1) {
            int max_distance = getMaxDistance(current);
            cost += getMinFuel(current, max_distance);
            current = max_distance;
        }
        System.out.println(cost);
        br.close();
    }

    public static int getMaxDistance(int pos) {
        int max_distance = pos;
        int min_cost = fuel[pos];
        for (int i = pos + 1; i < fuel.length - 1; i++) {
            if (min_cost > fuel[i])
                break;
            max_distance = i;
        }
        return max_distance + 1;
    }

    public static long getMinFuel(int current, int arrival) {
        long cost = 0;
        int total_distance = 0;
        for (int i = current; i < arrival; i++) {
            total_distance += distance[i];
        }
        cost += (long)fuel[current] * total_distance;
        return cost;
    }
}
