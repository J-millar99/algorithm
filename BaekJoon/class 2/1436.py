n = int(input())
base = 666
ret = [base]
while len(ret) != n:
    base += 1
    if "666" in str(base):
        ret.append(int(base))

print(ret.pop())