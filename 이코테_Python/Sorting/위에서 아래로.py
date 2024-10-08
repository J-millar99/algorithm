n = int(input())

data = []
for _ in range(n):
    data.append(int(input()))

data.sort(reverse=True)
print(" ".join(map(str, data)))