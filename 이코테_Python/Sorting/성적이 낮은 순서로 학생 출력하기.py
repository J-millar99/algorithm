n = int(input())

def score(info):
    return int(info[1])

data = []
for _ in range(n):
    data.append(tuple(input().split()))

data.sort(key=score) # key=lambda info: info[1]

for info in data:
    print(info[0], end=" ")