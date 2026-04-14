import java.util.ArrayList;
import java.util.List;

public class Backtracking {

    static int[] digits;          // 문자열을 숫자 배열로 변환
    static boolean[] used;        // 1~9 사용 여부
    static List<Integer> blanks;  // 0인 위치(인덱스) 목록
    static List<String> results;  // 결과 저장

    public static void main(String[] args) {
        String[] testCases = {
            "400120070",   // 일반 케이스
        };

        for (String input : testCases) {
            System.out.println("입력: " + input);
            List<String> answer = solve(input);
            System.out.println("결과 수: " + answer.size());
            answer.forEach(System.out::println);
            System.out.println();
        }
    }

    public static List<String> solve(String input) {
        results = new ArrayList<>();

        // 입력 유효성 검사
        if (input == null || input.length() != 9) {
            System.out.println("유효하지 않은 입력입니다.");
            return results;
        }

        digits = new int[9];
        used = new boolean[10]; // 인덱스 1~9 사용
        blanks = new ArrayList<>();

        // 초기화: 고정 숫자 등록 & 빈칸 위치 수집
        for (int i = 0; i < 9; i++) {
            digits[i] = input.charAt(i) - '0';

            if (digits[i] == 0) {
                blanks.add(i); // 0인 위치를 빈칸으로 등록
            } else {
                // 중복 숫자가 있으면 해결 불가
                if (used[digits[i]]) {
                    System.out.println("중복 숫자 존재 → 해결 불가");
                    return results;
                }
                used[digits[i]] = true;
            }
        }

        // 백트래킹 시작
        backtrack(0);
        return results;
    }

    /**
     * @param depth 현재 채우고 있는 빈칸의 순서 (blanks 리스트의 인덱스)
     */
    static void backtrack(int depth) {
        // 기저 조건: 모든 빈칸을 채웠으면 결과 저장
        if (depth == blanks.size()) {
            StringBuilder sb = new StringBuilder();
            for (int d : digits) sb.append(d);
            results.add(sb.toString());
            return;
        }

        int pos = blanks.get(depth); // 현재 채울 위치

        for (int num = 1; num <= 9; num++) {
            if (!used[num]) {          // 아직 사용하지 않은 숫자만
                // 선택
                digits[pos] = num;
                used[num] = true;

                // 다음 빈칸으로 재귀
                backtrack(depth + 1);

                // 되돌리기 (백트래킹)
                digits[pos] = 0;
                used[num] = false;
            }
        }
    }
}