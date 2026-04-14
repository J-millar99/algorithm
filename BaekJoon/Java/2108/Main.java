import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            arr.add(num);
        }
        Collections.sort(arr);
        System.out.println(getMean());
        System.out.println(getMedian());
        System.out.println(getMode());
        System.out.println(getRange());
        br.close();
    }

    public static int getMean() {
        double ret = 0;
        for (int num : arr)
            ret += num;
        ret /= arr.size();
        return (int)Math.round(ret);
    }

    public static int getMedian() {
        return arr.get(arr.size() / 2);
    }

    public static int getMode() {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : arr)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        
        int maxCount = 0;
        for (int count : frequencyMap.values())
            if (count > maxCount)
                maxCount = count;
        
        // 최빈값들이 여러 개일 수 있으므로, 모든 최빈값을 리스트에 저장
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxCount) {
                modes.add(entry.getKey());
            }
        }
        Collections.sort(modes);
        if (modes.size() != 1) // 최빈값 배열 또한 오름차순 정렬이기 때문에
            return modes.get(1); // 두 번째로 작은 값은 index: 1
        return modes.get(0); // 배열 크기가 1이라면 최빈값이 하나로 유일
    }

    public static int getRange() {
        return arr.get(arr.size() - 1) - arr.get(0);
    }
}