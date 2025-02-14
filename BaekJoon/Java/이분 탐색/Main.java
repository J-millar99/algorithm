import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static boolean myBinarySearch(List<Integer> elements, int find) {
        int s, e;
        s = 0;
        e = elements.size() - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            if (elements.get(mid) == find)
                return true;
            else if (elements.get(mid) < find)
                s = mid + 1;
            else if (elements.get(mid) > find)
                e = mid - 1;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String[] input1 = br.readLine().split(" ");
        List<Integer> elements = new ArrayList<>();
        for (String element : input1)
            elements.add(Integer.parseInt(element));
        Collections.sort(elements);         br.readLine();
    
        String[] input2 = br.readLine().split(" ");
        List<Integer> find = new ArrayList<>();
        for (String element : input2)
            find.add(Integer.parseInt(element));

        
        for (int i = 0; i < find.size(); i++) {

            // int t = Collections.binarySearch(elements, find.get(i));
            // if (t >= 0)
            //     System.out.println("1");
            // else
            //     System.out.println("0");
            
            if (myBinarySearch(elements, find.get(i)))
                System.out.println("1");
            else
                System.out.println("0");
        }
        br.close();
    }
}
