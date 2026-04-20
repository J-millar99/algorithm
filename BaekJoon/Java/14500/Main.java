import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int total = 0;

    // I 미노
    static class I {
        // I 미노
        static void move1(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 4; i++) {
                for (int j = 0; j < col; j++) {
                    int sum = field[i][j]
                            + field[i + 1][j]
                            + field[i + 2][j]
                            + field[i + 3][j];
                    total = Math.max(total, sum);
                }
            }
        }

        // ㅡ 미노
        static void move2(int[][] field, int row, int col) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j <= col - 4; j++) {
                    int sum = field[i][j]
                            + field[i][j + 1]
                            + field[i][j + 2]
                            + field[i][j + 3];
                    total = Math.max(total, sum);
                }
            }
        }
    }

    // O 미노
    static class O {
        static void move(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 2; i++) {
                for (int j = 0; j <= col - 2; j++) {
                    int sum = field[i][j]
                            + field[i][j + 1]
                            + field[i + 1][j]
                            + field[i + 1][j + 1];
                    total = Math.max(total, sum);
                }
            }
        }
    }
    
    // L/J 미노
    static class L {
        // L 미노 1
        static void move1(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 3; i++) {
                for (int j = 0; j <= col - 2; j++) {
                    int sum = field[i][j]
                            + field[i + 1][j]
                            + field[i + 2][j]
                            + field[i + 2][j + 1];
                    total = Math.max(total, sum);
                }
            }
        }

        // L 미노 2
        static void move2(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 2; i++) {
                for (int j = 0; j <= col - 3; j++) {
                    int sum = field[i][j]
                            + field[i][j + 1]
                            + field[i][j + 2]
                            + field[i + 1][j];
                    total = Math.max(total, sum);
                }
            }
        }

        // L 미노 3
        static void move3(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 3; i++) {
                for (int j = 0; j <= col - 2; j++) {
                    int sum = field[i][j]
                            + field[i][j + 1]
                            + field[i + 1][j + 1]
                            + field[i + 2][j + 1];
                    total = Math.max(total, sum);
                }
            }
        }

        // L 미노 4
        static void move4(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 2; i++) {
                for (int j = 0; j <= col - 3; j++) {
                    int sum = field[i + 1][j]
                            + field[i + 1][j + 1]
                            + field[i + 1][j + 2]
                            + field[i][j + 2];
                    total = Math.max(total, sum);
                }
            }
        }
    }

    static class J {
        // J 미노 1
        static void move1(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 3; i++) {
                for (int j = 0; j <= col - 2; j++) {
                    int sum = field[i][j + 1]
                            + field[i + 1][j + 1]
                            + field[i + 2][j + 1]
                            + field[i + 2][j];
                    total = Math.max(total, sum);
                }
            }
        }

        // J 미노 2
        static void move2(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 2; i++) {
                for (int j = 0; j <= col - 3; j++) {
                    int sum = field[i][j]
                            + field[i + 1][j]
                            + field[i + 1][j + 1]
                            + field[i + 1][j + 2];
                    total = Math.max(total, sum);
                }
            }
        }

        // J 미노 3
        static void move3(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 2; i++) {
                for (int j = 0; j <= col - 3; j++) {
                    int sum = field[i][j]
                            + field[i][j + 1]
                            + field[i][j + 2]
                            + field[i + 1][j + 2];
                    total = Math.max(total, sum);
                }
            }
        }

        // J 미노 4
        static void move4(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 3; i++) {
                for (int j = 0; j <= col - 2; j++) {
                    int sum = field[i][j]
                            + field[i][j + 1]
                            + field[i + 1][j]
                            + field[i + 2][j];
                    total = Math.max(total, sum);
                }
            }
        }
    }

    // Z/S 미노
    static class Z {
        // Z 미노
        static void move1(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 2; i++) {
                for (int j = 0; j <= col - 3; j++) {
                    int sum = field[i][j]
                            + field[i][j + 1]
                            + field[i + 1][j + 1]
                            + field[i + 1][j + 2];
                    total = Math.max(total, sum);
                }
            }
        }

        // S 미노
        static void move2(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 2; i++) {
                for (int j = 0; j <= col - 3; j++) {
                    int sum = field[i][j + 1]
                            + field[i][j + 2]
                            + field[i + 1][j]
                            + field[i + 1][j + 1];
                    total = Math.max(total, sum);
                }
            }
        }

        // 번개 모양 1
        static void move3(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 3; i++) {
                for (int j = 0; j <= col - 2; j++) {
                    int sum = field[i][j]
                            + field[i + 1][j]
                            + field[i + 1][j + 1]
                            + field[i + 2][j + 1];
                    total = Math.max(total, sum);
                }
            }
        }

        // 번개 모양 2
        static void move4(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 3; i++) {
                for (int j = 0; j <= col - 2; j++) {
                    int sum = field[i][j + 1]
                            + field[i + 1][j + 1]
                            + field[i + 1][j]
                            + field[i + 2][j];
                    total = Math.max(total, sum);
                }
            }
        }
    }

    // T 미노
    static class T {
        // T 미노
        static void move1(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 2; i++) {
                for (int j = 0; j <= col - 3; j++) {
                    int sum = field[i][j]
                            + field[i][j + 1]
                            + field[i][j + 2]
                            + field[i + 1][j + 1];
                    total = Math.max(total, sum);
                }
            }
        }

        // ㅗ 미노
        static void move2(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 2; i++) {
                for (int j = 0; j <= col - 3; j++) {
                    int sum = field[i][j + 1]
                            + field[i + 1][j]
                            + field[i + 1][j + 1]
                            + field[i + 1][j + 2];
                    total = Math.max(total, sum);
                }
            }
        }

        // ㅏ 미노
        static void move3(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 3; i++) {
                for (int j = 0; j <= col - 2; j++) {
                    int sum = field[i][j]
                            + field[i + 1][j]
                            + field[i + 2][j]
                            + field[i + 1][j + 1];
                    total = Math.max(total, sum);
                }
            }
        }

        // ㅓ 미노
        static void move4(int[][] field, int row, int col) {
            for (int i = 0; i <= row - 3; i++) {
                for (int j = 0; j <= col - 2; j++) {
                    int sum = field[i][j + 1]
                            + field[i + 1][j + 1]
                            + field[i + 1][j]
                            + field[i + 2][j + 1];
                    total = Math.max(total, sum);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);

        int[][] field = new int[n][m];

        for (int i = 0; i < n; i++) {
            in = br.readLine().split(" ");
            for (int j = 0; j < m; j++) 
                field[i][j] = Integer.parseInt(in[j]);
        }

        I.move1(field, n, m);
        I.move2(field, n, m);
        O.move(field, n, m);
        T.move1(field, n, m);
        T.move2(field, n, m);
        T.move3(field, n, m);
        T.move4(field, n, m);
        Z.move1(field, n, m);
        Z.move2(field, n, m);
        Z.move3(field, n, m);
        Z.move4(field, n, m);
        L.move1(field, n, m);
        L.move2(field, n, m);
        L.move3(field, n, m);
        L.move4(field, n, m);
        J.move1(field, n, m);
        J.move2(field, n, m);
        J.move3(field, n, m);
        J.move4(field, n, m);
        System.out.println(total);
    }
}
