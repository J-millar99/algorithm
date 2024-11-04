# 좌표압축
n = int(input())
arr = list(map(int, input().split()))
sorted_arr = sorted(arr)

dic = {}
k = 0
for i in range(n):
    if not sorted_arr[i] in dic:
        dic[sorted_arr[i]] = k
        k += 1
for j in arr:
    print(dic[j], end=" ")
