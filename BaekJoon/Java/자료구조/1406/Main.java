import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int num = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<>();
        for (Character ch : str.toCharArray())
            list.add(ch);

        ListIterator<Character> iter = list.listIterator();

        while (iter.hasNext())
            iter.next();
            
        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];

            if (cmd.equals("L")) {
                if (iter.hasPrevious()) iter.previous();
            } else if (cmd.equals("D")) {
                if (iter.hasNext()) iter.next();
            } else if (cmd.equals("B")) {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if (cmd.equals("P")) {
                iter.add(input[1].charAt(0));
            }
        }

        for (char ch : list) {
            sb.append(ch);
        }
        System.out.println(sb);
        br.close();
    }
}