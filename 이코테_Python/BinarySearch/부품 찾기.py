def binary_search(target, s, e):
    if s >= e:
        return False
    mid = (s + e) // 2
    if data[mid] == target:
        return True
    elif data[mid] > target:
        return binary_search(target, s, mid - 1)   
    elif data[mid] < target:
        return binary_search(target, mid + 1, e)

n = int(input())
data = list(map(int, input().split()))
m = int(input())
order = list(map(int, input().split()))

for i in range(m):
    if binary_search(order[i], 0, n - 1):
       print("yes")
    else:
        print("no")

# 계수정렬 : 최대 부품 수 만큼에 배열을 생성하고 부품의 배열에 해당하는 인덱스로 접근
# n = int(input())
# array = [0] * 1000001
# for i in input().split():
#     array[int(i)] = 1

# m = int(input())
# order = list(input().split())

# for i in order:
#     if array[i] == 1:
#         print("yes")
#     else:
#         print("no")

# 집합 자료형을 이용 : 집합은 중복을 허용하지 않아서 부품이 존재하는지 아닌지만 확인하면 됨
# n = int(input())
# data = set(map(int, input().split()))
# m = int(input())
# order = list(map(int, input().split()))

# for i in order:
#     if i in data:
#         print("yes")
#     else:
#         print("no")