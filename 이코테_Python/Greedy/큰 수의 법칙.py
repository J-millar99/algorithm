n, m, k = map(int, input().split())
data = list(map(int, input().split()))
data.sort()
ret = 0
# while True:
#     for _ in range(k):
#         ret += data[-1]
#         m -= 1
#         if m == 0:
#             break
#     ret += data[-2]
#     m -= 1
#     if m == 0:
#         break

# print(ret)
max1 = data[-1]
max2 = data[-2]
ret = 0

# 가장 큰 수가 더해지는 횟수 : 블럭 단위로 구하는 방법
count = (m // (k + 1)) * k 
# (m // (k + 1)) 가장 큰 블럭 단위의 개수
# "* k" 그 중에서 큰 수가 등장하는 횟수는 k를 곱해야 함
count += m % (k + 1)
# m % (k + 1) 블럭으로 만들어지지 못한 수
# 이미 최대한으로 블럭을 만들었기 때문에 남은 덧셈 피연산자는 가장 큰 수로 등장할 수 있다

ret += max1 * count
ret += (m - count) * max2
# (m - count) 총 덧셈 개수 - 큰 수의 개수 = 두 번재 큰 수 덧셈 개수
print(ret)