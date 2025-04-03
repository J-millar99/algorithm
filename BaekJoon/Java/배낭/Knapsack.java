import java.util.Arrays;

public class Knapsack {
    
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};      // 물건들의 무게
        int[] values = {3, 4, 5, 6};       // 물건들의 가치
        int capacity = 8;                  // 배낭의 용량
        int n = weights.length;            // 물건의 개수
        
        // 동적 프로그래밍 방식
        System.out.println("최대 가치 (동적 프로그래밍): " + knapsackDP(weights, values, capacity, n));
        
        // 동적 프로그래밍 & 선택된 아이템 추적
        int[][] dp = new int[n + 1][capacity + 1];
        System.out.println("최대 가치 (DP with 아이템 추적): " + knapsackDPWithItems(weights, values, capacity, n, dp));
        printSelectedItems(dp, weights, values, capacity, n);
        
        // 메모이제이션을 사용한 재귀 방식
        int[][] memo = new int[n + 1][capacity + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        System.out.println("최대 가치 (메모이제이션): " + knapsackMemoization(weights, values, capacity, n, memo));
    }
    
    // 동적 프로그래밍 접근법 (Bottom-up)
    public static int knapsackDP(int[] weights, int[] values, int capacity, int n) {
        // dp[i][j]는 i개의 아이템과 j 용량으로 얻을 수 있는 최대 가치
        int[][] dp = new int[n + 1][capacity + 1];
        
        // 초기 상태: 아이템이 없거나 용량이 0인 경우 가치는 0
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    // 현재 아이템을 포함할 수 있는 경우: 
                    // max(현재 아이템 포함, 현재 아이템 제외)
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    // 현재 아이템을 포함할 수 없는 경우: 이전 상태 유지
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        return dp[n][capacity];
    }
    
    // 동적 프로그래밍 접근법 + 선택된 아이템 추적
    public static int knapsackDPWithItems(int[] weights, int[] values, int capacity, int n, int[][] dp) {
        // 초기 상태: 아이템이 없거나 용량이 0인 경우 가치는 0
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        return dp[n][capacity];
    }
    
    // 선택된 아이템 출력
    public static void printSelectedItems(int[][] dp, int[] weights, int[] values, int capacity, int n) {
        System.out.println("선택된 아이템:");
        
        int res = dp[n][capacity];
        int w = capacity;
        
        for (int i = n; i > 0 && res > 0; i--) {
            // 이전 아이템에서 값이 변하지 않았다면 현재 아이템은 선택되지 않음
            if (res != dp[i - 1][w]) {
                System.out.println("아이템 " + (i - 1) + ": 무게 = " + weights[i - 1] + ", 가치 = " + values[i - 1]);
                
                // 현재 아이템을 제외한 나머지 용량과 가치로 업데이트
                res -= values[i - 1];
                w -= weights[i - 1];
            }
        }
    }
    
    // 메모이제이션을 사용한 재귀 접근법 (Top-down)
    public static int knapsackMemoization(int[] weights, int[] values, int capacity, int n, int[][] memo) {
        // 기저 사례
        if (n == 0 || capacity == 0) {
            return 0;
        }
        
        // 이미 계산된 상태인 경우
        if (memo[n][capacity] != -1) {
            return memo[n][capacity];
        }
        
        // 현재 아이템이 배낭에 들어갈 수 있는 경우
        if (weights[n - 1] <= capacity) {
            // 현재 아이템을 포함하거나 포함하지 않는 경우 중 최대값
            memo[n][capacity] = Math.max(
                values[n - 1] + knapsackMemoization(weights, values, capacity - weights[n - 1], n - 1, memo),
                knapsackMemoization(weights, values, capacity, n - 1, memo)
            );
        } else {
            // 현재 아이템이 배낭에 들어갈 수 없는 경우
            memo[n][capacity] = knapsackMemoization(weights, values, capacity, n - 1, memo);
        }
        
        return memo[n][capacity];
    }
}