# 피보나치 함수

def fibonacci(n):
    # 0과 1의 등장 횟수를 저장할 리스트
    count_0 = [0] * (n + 1)
    count_1 = [0] * (n + 1)

    # 초기값 설정
    count_0[0] = 1  # fib(0) = 0 일 때 0이 1번 등장
    count_1[1] = 1  # fib(1) = 1 일 때 1이 1번 등장

    # 피보나치 수열과 동시에 등장 횟수 계산
    for i in range(2, n + 1):
        count_0[i] = count_0[i - 1] + count_0[i - 2]
        count_1[i] = count_1[i - 1] + count_1[i - 2]
    print(count_0.pop(), count_1.pop())
    
import sys
input = sys.stdin.readline
n = int(input())
for _ in range(n):
    num = int(input())
    if num == 0:
        print(1, 0)
    else: 
        fibonacci(num)
