import java.io.*;
import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] cmdLine = br.readLine().split(" ");
            processCommand(cmdLine);
        }
        if(sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1); // 마지막 줄바꿈 문자열 제거
        System.out.println(sb);
        br.close();
    }

    public static void processCommand(String[] cmdLine) {
        if (cmdLine[0].equals("add"))
            set.add(cmdLine[1]);
        else if (cmdLine[0].equals("remove"))
            set.remove(cmdLine[1]);
        else if (cmdLine[0].equals("check")) {
            if (set.contains(cmdLine[1]))
                sb.append("1");
            else
                sb.append("0");
            sb.append("\n");
        }
        else if (cmdLine[0].equals("toggle")) {
            if (set.contains(cmdLine[1]))
                set.remove(cmdLine[1]);
            else
                set.add(cmdLine[1]);
        }
        else if (cmdLine[0].equals("all"))
            setAll();
        else if (cmdLine[0].equals("empty"))
            set.clear();
    }

    public static void setAll() {
        for (int i = 1; i <= 20; i++)
            set.add(String.valueOf(i));
    }
}
