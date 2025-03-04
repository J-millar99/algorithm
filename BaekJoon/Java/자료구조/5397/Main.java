import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(br.readLine());
        for (int i = 0; i < tries; i++) {
            String input = br.readLine();
            solution(input);
        }
        System.out.print(sb);
        br.close();
    }

    public static void solution(String str) {
        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> iter = list.listIterator();

        for (Character ch : str.toCharArray()) {
            if (ch == '<') {
                if(iter.hasPrevious()) iter.previous();
            } else if (ch == '>') {
                if(iter.hasNext()) iter.next();
            } else if (ch == '-') {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else
                iter.add(ch);
        }

        for (Character character : list) {
            sb.append(character);
        }
        sb.append("\n");
    }
}