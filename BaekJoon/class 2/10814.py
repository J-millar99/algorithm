import sys
input = sys.stdin.readline
n = int(input())

data = []
for _ in range(n):
    age, name = input().rstrip().split()
    data.append([int(age), name])

data.sort(key=lambda x: x[0])
for age, name in data:
    print(age, name)

# for info in data:
#     print(info[0], info[1])